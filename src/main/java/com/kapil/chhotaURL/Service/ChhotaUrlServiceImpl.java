package com.kapil.chhotaURL.Service;

import com.kapil.chhotaURL.DTO.ChhotaUrlDTO;
import com.kapil.chhotaURL.Entity.ChhotaUrlEntity;
import com.kapil.chhotaURL.Helper.ChhotaUrlHelper;
import com.kapil.chhotaURL.Repository.IChhotaUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ChhotaUrlServiceImpl implements IChhotaUrlService {

    @Autowired
    private ChhotaUrlHelper chhotaUrlHelper;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IChhotaUrlRepository chhotaUrlRepository;

    @Override
    public ChhotaUrlDTO createChhotaUrl(ChhotaUrlDTO chhotaUrlDTO) {
        String hashCode = chhotaUrlHelper.generateChhotaUrlHashCode(chhotaUrlDTO.getLongUrl());
        chhotaUrlDTO.setHashCode(hashCode);
        chhotaUrlDTO.setChhotaUrl(chhotaUrlHelper.createChhotaUrl(hashCode));
        ChhotaUrlEntity chhotaUrlEntity = modelMapper.map(chhotaUrlDTO, ChhotaUrlEntity.class);
        ChhotaUrlEntity savedChhotaUrlEntity = chhotaUrlRepository.save(chhotaUrlEntity);
        return modelMapper.map(savedChhotaUrlEntity, ChhotaUrlDTO.class);
    }

    @Override
    public ChhotaUrlDTO getChhotaUrlDetails(String hashCode) {
        ChhotaUrlEntity chhotaUrlEntity = chhotaUrlRepository.findByHashCode(hashCode);
        if(chhotaUrlEntity == null)
            throw new RuntimeException("No ChhotaURL Present For Given HashCode " + hashCode);
        return modelMapper.map(chhotaUrlEntity, ChhotaUrlDTO.class);
    }
}
