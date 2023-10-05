package projeto.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.clinica.entities.HealthPlan;
import projeto.clinica.repositories.HealthPlanRepository;

@Service
public class HealthPlanService {

  @Autowired
  private HealthPlanRepository repository;

  // CREATE
  public HealthPlan create(HealthPlan obj) {
    return repository.save(obj);
  }

  // READ
  public List<HealthPlan> findAll() {
    return repository.findAll();
  }

  public HealthPlan findById(Long id) {
    Optional<HealthPlan> obj = repository.findById(id);
    return obj.get();
  }

  // UPDATE
  public HealthPlan update(Long id, HealthPlan obj) {
    HealthPlan entity = repository.getReferenceById(id);
    updateFields(entity, obj);
    return repository.save(entity);
  }

  // DELETE
  public void delete(Long id) {
    repository.deleteById(id);
  }

  private void updateFields(HealthPlan entity, HealthPlan obj) {
    if (obj.getName() != null && obj.getName() != "")
      entity.setName(obj.getName());
    if (obj.getIsActive() != entity.getIsActive())
      entity.setIsActive(obj.getIsActive());
  }
}
