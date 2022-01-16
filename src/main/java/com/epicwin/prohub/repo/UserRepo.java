package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for handling user operations.
 */
public interface UserRepo extends JpaRepository<User,String> {

    User findUserByEmail(String email);

    void deleteByEmail(String email);

    @Transactional
    void deleteUserByEmail(String email);
}

