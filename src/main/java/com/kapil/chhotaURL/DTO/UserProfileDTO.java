package com.kapil.chhotaURL.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {

    private String userId;
    @NonNull
    private String userEmail;
    private List<ChhotaUrlDTO> chhotaUrlsList;

}
