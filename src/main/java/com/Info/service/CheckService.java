package com.Info.service;

import com.Info.model.entity.Check;
import com.Info.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService extends CommonService<Check, Long> {

    @Autowired
    public CheckService(CheckRepository repository) {
        super(repository);
    }
}
