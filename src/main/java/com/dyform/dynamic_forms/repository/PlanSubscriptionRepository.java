package com.dyform.dynamic_forms.repository;

import com.dyform.dynamic_forms.entity.PlanSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PlanSubscriptionRepository extends JpaRepository<PlanSubscription, UUID> {
}
