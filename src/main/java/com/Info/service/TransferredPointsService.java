package com.Info.service;

import com.Info.model.entity.TransferredPoint;
import com.Info.repository.TransferredPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferredPointsService extends CommonService<TransferredPoint, Long> {

    @Autowired
    public TransferredPointsService(TransferredPointRepository transferredPointRepository) {
        super(transferredPointRepository);
    }
}
