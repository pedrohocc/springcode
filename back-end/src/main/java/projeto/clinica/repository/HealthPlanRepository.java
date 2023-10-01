package projeto.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.clinica.entity.HealthPlan;

@Repository
public interface HealthPlanRepository extends JpaRepository<HealthPlan, Long> {

}
