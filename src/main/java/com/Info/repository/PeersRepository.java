package com.Info.repository;

import com.Info.model.entity.Peer;
import org.springframework.stereotype.Repository;

@Repository
public interface PeersRepository extends CommonRepository<Peer, String> {}
