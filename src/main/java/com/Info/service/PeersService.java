package com.Info.service;

import com.Info.model.entity.Peer;
import com.Info.repository.PeersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeersService extends CommonService<Peer, String> {

    private final PeersRepository repository;

    @Autowired
    public PeersService(PeersRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public boolean existsByNickname(String nickname) {
        return repository.existsById(nickname);
    }

}
