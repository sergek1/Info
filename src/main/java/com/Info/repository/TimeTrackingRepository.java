package com.Info.repository;

import com.Info.model.entity.TimeTracking;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTrackingRepository extends CommonRepository<TimeTracking, Long> {
}
