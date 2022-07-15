package com.kapil.chhotaURL.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_profile")
@Data
public class UserProfileEntity {

    @Id
    @SequenceGenerator(sequenceName = "userId_seq", name = "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_sequence")
    private Long userId;
    private String userEmail;
    @OneToMany(mappedBy = "userId")
    private List<ChhotaUrlEntity> chhotaUrlsList;

}
