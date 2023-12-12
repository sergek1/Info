package com.Info.repository;

import com.Info.model.entity.Recommendation;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends CommonRepository<Recommendation, Long> {
}
