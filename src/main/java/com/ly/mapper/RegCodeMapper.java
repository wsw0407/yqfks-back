package com.ly.mapper;


import com.ly.entity.RegistCode;
import org.springframework.stereotype.Repository;

@Repository
public interface RegCodeMapper {

    public void addRegCode(String regCode);

    public RegistCode getRegCode(String regCode);
}