package com.prod_ready_feature.demo.repositories;

import com.prod_ready_feature.demo.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {


}


