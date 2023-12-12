package com.Info.service;

import com.Info.model.entity.TimeTracking;
import com.Info.repository.TimeTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTrackingService extends CommonService<TimeTracking, Long> {

    @Autowired
    public TimeTrackingService(TimeTrackingRepository timeTrackingRepository) {

        super(timeTrackingRepository);
    }
}
