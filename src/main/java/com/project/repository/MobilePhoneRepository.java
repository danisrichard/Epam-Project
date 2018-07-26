package com.project.repository;

import com.project.model.Mobile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MobilePhoneRepository extends CrudRepository<Mobile, Long> {
    Optional<Mobile> findById(Long id);
}
