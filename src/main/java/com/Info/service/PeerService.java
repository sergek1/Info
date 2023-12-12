package com.Info.service;

import com.Info.model.entity.Peer;
import com.Info.repository.PeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeerService extends CommonService<Peer, String> {

    private final PeerRepository repository;

    @Autowired
    public PeerService(PeerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public boolean existsByNickname(String nickname) {
        return repository.existsById(nickname);
    }

}
