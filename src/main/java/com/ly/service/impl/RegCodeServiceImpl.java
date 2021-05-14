package com.ly.service.impl;

import com.ly.entity.RegistCode;
import com.ly.mapper.RegCodeMapper;
import com.ly.service.RegCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegCodeServiceImpl implements RegCodeService {

    @Autowired
    private RegCodeMapper regCodeMapper;

    @Override
    public void addRegCode(String regCode) {
        regCodeMapper.addRegCode(regCode);
    }

    @Override
    public RegistCode getRegCode(String regCode) {

        return regCodeMapper.getRegCode(regCode);
    }

}