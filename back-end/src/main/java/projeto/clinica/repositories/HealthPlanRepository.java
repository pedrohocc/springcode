package projeto.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.clinica.entities.HealthPlan;

@Repository
public interface HealthPlanRepository extends JpaRepository<HealthPlan, Long> {

}
