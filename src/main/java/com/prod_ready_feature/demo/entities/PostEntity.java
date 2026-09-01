package com.prod_ready_feature.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Audited // Hibernate Envers will create a separate table to store the audit history of this entity on each update. The table name will be "posts_AUD" by default.
public class PostEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

//    @NotAudited If don't want to audit this field, we can use @NotAudited annotation
    @Column(name = "description")
    private String description;

}
