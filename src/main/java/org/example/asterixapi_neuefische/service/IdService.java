package org.example.asterixapi_neuefische.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
