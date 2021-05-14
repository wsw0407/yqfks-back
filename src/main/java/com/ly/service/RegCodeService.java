package com.ly.service;

import com.ly.entity.RegistCode;

public interface RegCodeService {
    public void addRegCode(String regCode);

    public RegistCode getRegCode(String regCode);
}
