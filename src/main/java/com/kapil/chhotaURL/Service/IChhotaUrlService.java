package com.kapil.chhotaURL.Service;


import com.kapil.chhotaURL.DTO.ChhotaUrlDTO;


public interface IChhotaUrlService {

    ChhotaUrlDTO createChhotaUrl(ChhotaUrlDTO chhotaUrlDTO);

    ChhotaUrlDTO getChhotaUrlDetails(String hashCode);
}
