package com.epicwin.prohub.service;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.userImage.UserImage;
import com.epicwin.prohub.repo.UserImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Objects;

/**
 * Service class for handling user image operations.
 */
@Service
public class UserImageService {

    @Autowired
    UserImageRepo userImageRepo;

    public UserImage saveImageFile(MultipartFile file, String email) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        UserImage userImage = new UserImage(fileName, file.getContentType(), file.getBytes(), email);

        return userImageRepo.save(userImage);
    }

    public UserImage getImageFile(String email) throws EntityNotFoundException {
        UserImage userImage = userImageRepo.findUserImageByEmail(email);
        if(Objects.isNull(userImage)) {
            throw new EntityNotFoundException("Requested User Image Entity Not Found");
        } else {
            return userImage;
        }
    }

    public UserImage updateImageFile(MultipartFile file, String email) throws IOException, EntityNotFoundException {
        UserImage userImage = getImageFile(email);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(Objects.isNull(userImage)) {
            UserImage newUserImage = new UserImage(fileName, file.getContentType(), file.getBytes(), email);
            return userImageRepo.save(newUserImage);
        } else {
            userImage.setData(file.getBytes());
            userImage.setType(file.getContentType());
            userImage.setName(fileName);
            return userImageRepo.save(userImage);
        }
    }

    public void deleteImageFile(String email) throws EntityNotFoundException {
        UserImage userImage = userImageRepo.findUserImageByEmail(email);
        if(Objects.isNull(userImage)) {
            throw new EntityNotFoundException("Requested User Image Entity Not Found");
        } else {
            userImageRepo.deleteUserImageByEmail(email);
        }
    }
}
