package com.Info.service;

import com.Info.model.entity.Verter;
import com.Info.repository.VerterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerterService extends CommonService<Verter, Long> {

    @Autowired
    public VerterService(VerterRepository verterRepository) {
        super(verterRepository);
    }
}
