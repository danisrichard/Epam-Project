package com.project.repository;

import com.project.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User,UUID> {

    User save(User user);
}
