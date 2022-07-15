package com.kapil.chhotaURL.Service;

import com.kapil.chhotaURL.DTO.UserProfileDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserProfileService {

    UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO);

    UserProfileDTO getUserProfileByEmail(String userEmail);

}
