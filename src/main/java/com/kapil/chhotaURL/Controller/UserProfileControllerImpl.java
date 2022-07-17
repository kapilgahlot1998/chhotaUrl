package com.kapil.chhotaURL.Controller;

import com.kapil.chhotaURL.DTO.UserProfileDTO;
import com.kapil.chhotaURL.Service.IUserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class UserProfileControllerImpl implements IUserProfileController {

    @Autowired
    private IUserProfileService userProfileService;

    @Override
    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
        log.debug("User profile creation request with details : {}", userProfileDTO);
        return userProfileService.createUserProfile(userProfileDTO);
    }

    @Override
    public UserProfileDTO getUserProfileByEmail(String userEmail) {
        log.debug("User profile fetch request for email : {}", userEmail);
        return userProfileService.getUserProfileByEmail(userEmail);
    }
}
