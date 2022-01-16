package com.epicwin.prohub.controller;

import com.epicwin.prohub.model.userImage.UserImage;
import com.epicwin.prohub.model.userImage.UserImageResponseFile;
import com.epicwin.prohub.model.userImage.UserImageResponseMessage;
import com.epicwin.prohub.service.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Controller class for handling user image operations.
 */
@Controller
@CrossOrigin
public class UserImageController {

    @Autowired
    UserImageService userImageService;

    @PostMapping("userImage/{email}")
    public ResponseEntity<UserImageResponseMessage> uploadFile(@RequestParam("data") MultipartFile file,
                                                               @PathVariable String email) {
        String message = "";
        try {
            userImageService.store(file, email);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new UserImageResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new UserImageResponseMessage(message));
        }
    }

    @GetMapping("userImage/{email}/download")
    public ResponseEntity<byte[]> getFile(@PathVariable String email) {
        UserImage userImage  = userImageService.getFile(email);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + userImage.getName() + "\"")
                .body(userImage.getData());
    }

    @GetMapping("userImage/{email}")
    public ResponseEntity<UserImageResponseFile> getUserImageData(@PathVariable String email) {

        UserImage userImage = userImageService.getFile(email);
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/userImage/")
                .path(userImage.getEmail())
                .path("/download/")
                .toUriString();

        UserImageResponseFile responseFile =  new UserImageResponseFile(
                userImage.getName(),
                fileDownloadUri,
                userImage.getType(),
                userImage.getData().length);

        return ResponseEntity.status(HttpStatus.OK).body(responseFile);
    }
}
