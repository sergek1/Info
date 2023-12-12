package com.Info.service;

import com.Info.model.entity.Friend;
import com.Info.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService extends CommonService<Friend, Long> {

    @Autowired
    public FriendService(FriendRepository friendRepository) {
        super(friendRepository);
    }
}
