package com.jinternals.user.services.impl;

import com.jinternals.user.services.IdentityGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdentityGeneratorImpl implements IdentityGenerator {

    public String generateIdentity() {
        return UUID.randomUUID().toString();
    }

}
