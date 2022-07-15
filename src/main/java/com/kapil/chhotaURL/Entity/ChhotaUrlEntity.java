package com.kapil.chhotaURL.Entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chhota_url_details")
@Data
public class ChhotaUrlEntity {

    @Id
    private String hashCode;
    private String chhotaUrl;
    private String longUrl;
    private Long userId;

}
