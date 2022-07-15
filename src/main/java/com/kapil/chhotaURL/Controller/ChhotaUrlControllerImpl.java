package com.kapil.chhotaURL.Controller;

import com.kapil.chhotaURL.DTO.ChhotaUrlDTO;
import com.kapil.chhotaURL.Service.IChhotaUrlService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

@Controller
@Slf4j
public class ChhotaUrlControllerImpl implements IChhotaUrlController {

    @Autowired
    private IChhotaUrlService chhotaUrlService;

    @Override
    public ChhotaUrlDTO createChhotaUrl(@NonNull ChhotaUrlDTO chhotaUrlDTO) {
        log.debug("Url received : {}", chhotaUrlDTO.getLongUrl());
        ChhotaUrlDTO chhotaUrlResponseDTO = chhotaUrlService.createChhotaUrl(chhotaUrlDTO);
        log.debug("Chhota URL created : {}", chhotaUrlResponseDTO.getChhotaUrl());
        return chhotaUrlResponseDTO;
    }

    @Override
    public ChhotaUrlDTO getChhotaUrlDetails(String hashCode) {
        log.debug("Request received for hashcode : {}", hashCode);
        return chhotaUrlService.getChhotaUrlDetails(hashCode);
    }

    @Override
    public void redirectChhotaUrl(HttpServletResponse response, String hashCode) {
        ChhotaUrlDTO chhotaUrlDTO = chhotaUrlService.getChhotaUrlDetails(hashCode);
        String longUrl = chhotaUrlDTO.getLongUrl();
        try {
            response.sendRedirect(longUrl);
        } catch (IOException e) {
            throw new RuntimeException("Some issue occurred while redirecting");
        }
    }
}
