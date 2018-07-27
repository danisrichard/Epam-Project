package com.project.repository;

import com.project.model.mobilesection.Mobile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MobilePhoneRepository extends PagingAndSortingRepository<Mobile, Long> {
    Optional<Mobile> findById(Long id);
}
