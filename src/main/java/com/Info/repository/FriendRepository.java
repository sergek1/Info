package com.Info.repository;

import com.Info.model.entity.Friends;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends CommonRepository<Friends, Long> {
}
