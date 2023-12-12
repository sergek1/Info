package com.Info.service;

import com.Info.model.entity.Xp;
import com.Info.repository.XpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XpService extends CommonService<Xp, Long> {

    @Autowired
    public XpService(XpRepository xpRepository) {
        super(xpRepository);
    }
}
