package com.epicwin.prohub.controller;

import com.epicwin.prohub.exception.EntityNotFoundException;
import com.epicwin.prohub.model.userImage.UserImage;
import com.epicwin.prohub.model.userImage.UserImageResponseFile;
import com.epicwin.prohub.model.userImage.UserImageResponseMessage;
import com.epicwin.prohub.service.UserImageService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Base64;

/**
 * Controller class for handling user image operations.
 */
@RestController
@CrossOrigin
public class UserImageController {

    @Autowired
    UserImageService userImageService;

    @PostMapping("userImage/{email}")
    public ResponseEntity<UserImageResponseMessage> uploadFile(@RequestParam("data") MultipartFile file,
                                                               @PathVariable String email) {
        String message = "";
        try {
            userImageService.saveImageFile(file, email);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new UserImageResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new UserImageResponseMessage(message));
        }
    }

    @GetMapping("userImage/{email}/download")
    public ResponseEntity<byte[]> getFile(@PathVariable String email) throws EntityNotFoundException {
        UserImage userImage = userImageService.getImageFile(email);
        byte[] base64encodedData = Base64.getEncoder().encode(userImage.getData());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                        + userImage.getName() + "\"")
                .body(base64encodedData);
    }

    @GetMapping("userImage/{email}")
    public ResponseEntity<UserImageResponseFile> getUserImageData(@PathVariable String email)
            throws EntityNotFoundException {

        UserImage userImage = userImageService.getImageFile(email);
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/userImage/")
                .path(userImage.getEmail())
                .path("/download/")
                .toUriString();

        UserImageResponseFile responseFile = new UserImageResponseFile(
                userImage.getName(),
                fileDownloadUri,
                userImage.getType(),
                userImage.getData().length);

        return ResponseEntity.status(HttpStatus.OK).body(responseFile);
    }

    @PutMapping("/userImage/{email}/update")
    public int updateUserImage(@RequestParam("data") MultipartFile file, @PathVariable String email) {
        try {
            userImageService.updateImageFile(file, email);
            return Response.SC_OK;
        } catch (Exception e) {
            return Response.SC_BAD_GATEWAY;
        }
    }

    @DeleteMapping("/userImage/{email}")
    public void removeUserImage(@PathVariable String email) throws EntityNotFoundException {
        userImageService.deleteImageFile(email);
    }
}
