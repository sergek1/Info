package com.Info.service;

import com.Info.model.entity.P2P;
import com.Info.repository.P2PRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class P2PService extends CommonService<P2P, Long> {

    @Autowired
    public P2PService(P2PRepository p2PRepository) {
        super(p2PRepository);
    }
}
