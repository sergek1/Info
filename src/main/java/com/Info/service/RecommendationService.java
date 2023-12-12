package com.Info.service;

import com.Info.model.entity.Recommendation;
import com.Info.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService extends CommonService<Recommendation, Long> {

    @Autowired
    public RecommendationService(RecommendationRepository recommendationRepository) {
        super(recommendationRepository);
    }
}
