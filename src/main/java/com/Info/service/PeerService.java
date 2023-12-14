package com.Info.service;

import com.Info.model.entity.Peer;
import com.Info.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeerService extends CommonService<Peer, Long> {

    private final PeerRepository repository;

    @Autowired
    public PeerService(PeerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public boolean existsByNickname(Long id) {
        return repository.existsById(id);
    }

}
