package com.prod_ready_feature.demo.controller;

import com.prod_ready_feature.demo.entities.PostEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/{id}")
    public List<PostEntity> getAllAuditInfo(@PathVariable Long id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions = auditReader.getRevisions(PostEntity.class, id);
        return revisions.stream()
                .map(revision -> auditReader.find(PostEntity.class, id, revision))
                .toList();
    }

}
