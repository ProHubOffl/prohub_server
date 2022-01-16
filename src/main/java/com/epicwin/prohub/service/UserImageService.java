package com.epicwin.prohub.service;

import com.epicwin.prohub.model.userImage.UserImage;
import com.epicwin.prohub.repo.UserImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Service class for handling user image operations.
 */
@Service
public class UserImageService {

    @Autowired
    UserImageRepo userImageRepo;

    public UserImage store(MultipartFile file, String email) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        UserImage userImage = new UserImage(fileName, file.getContentType(), file.getBytes(), email);

        return userImageRepo.save(userImage);
    }

    public UserImage getFile(String email) {
        return userImageRepo.findUserImageByEmail(email);
    }

}
