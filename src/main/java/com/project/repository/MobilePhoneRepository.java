package com.project.repository;

import com.project.model.Mobile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilePhoneRepository extends CrudRepository<Mobile,Long> {
    Mobile findById(String id);
}
