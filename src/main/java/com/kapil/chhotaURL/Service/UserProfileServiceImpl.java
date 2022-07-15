package com.kapil.chhotaURL.Service;

import com.kapil.chhotaURL.DTO.UserProfileDTO;
import com.kapil.chhotaURL.Entity.UserProfileEntity;
import com.kapil.chhotaURL.Repository.IUserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserProfileServiceImpl implements IUserProfileService {

    @Autowired
    private IUserProfileRepository userProfileRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserProfileDTO createUserProfile(UserProfileDTO userProfileDTO) {
        UserProfileEntity userProfileEntity = modelMapper.map(userProfileDTO, UserProfileEntity.class);
        UserProfileEntity savedUserProfileEntity = userProfileRepository.save(userProfileEntity);
        return modelMapper.map(savedUserProfileEntity, UserProfileDTO.class);
    }

    @Override
    public UserProfileDTO getUserProfileByEmail(String userEmail) {
        return modelMapper.map(userProfileRepository.findByUserEmail(userEmail), UserProfileDTO.class);
    }
}
