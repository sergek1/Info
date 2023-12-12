package com.Info.repository;

import com.Info.model.entity.Friend;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends CommonRepository<Friend, Long> {
}
