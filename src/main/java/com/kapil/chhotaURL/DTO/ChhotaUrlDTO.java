package com.kapil.chhotaURL.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChhotaUrlDTO {

    private String hashCode;
    private String chhotaUrl;
    @NonNull
    private String longUrl;
    @NonNull
    private Long UserId;

}
