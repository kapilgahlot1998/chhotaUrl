package com.kapil.chhotaURL.Controller;

import com.kapil.chhotaURL.DTO.ChhotaUrlDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/url")
public interface IChhotaUrlController {

    @PostMapping(value = "")
    ChhotaUrlDTO createChhotaUrl(@RequestBody ChhotaUrlDTO chhotaUrlDTO);

    @GetMapping(value = "")
    ChhotaUrlDTO getChhotaUrlDetails(@RequestParam String hashCode);

    @GetMapping(value = "/{hashCode}")
    void redirectChhotaUrl(HttpServletResponse response, @PathVariable(name = "hashCode") String hashCode);
}
