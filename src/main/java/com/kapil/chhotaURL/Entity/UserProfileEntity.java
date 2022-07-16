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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long userId;
    private String userEmail;
    @OneToMany(mappedBy = "userId")
    private List<ChhotaUrlEntity> chhotaUrlsList;

}
