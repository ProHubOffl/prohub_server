package com.epicwin.prohub.repo;

import com.epicwin.prohub.model.userImage.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for handling user image operations.
 */
@Repository
public interface UserImageRepo extends JpaRepository<UserImage, String> {

    UserImage findUserImageByEmail(String email);
}
