package com.kapil.chhotaURL.Repository;


import com.kapil.chhotaURL.Entity.UserProfileEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfileEntity, Long> {

    UserProfileEntity save(@NonNull UserProfileEntity userProfileEntity);

    UserProfileEntity findByUserEmail(String userEmail);
}
