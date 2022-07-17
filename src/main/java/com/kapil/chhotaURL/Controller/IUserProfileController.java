package com.kapil.chhotaURL.Controller;


import com.kapil.chhotaURL.DTO.UserProfileDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public interface IUserProfileController {

    @PostMapping(value = "")
    UserProfileDTO createUserProfile(@RequestBody UserProfileDTO userProfileDTO);

    @GetMapping(value = "/{userEmail}")
    UserProfileDTO getUserProfileByEmail(@PathVariable(name = "userEmail") String userEmail);


}
