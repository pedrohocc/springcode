package projeto.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.clinica.entities.Schedule;
import projeto.clinica.repositories.ScheduleRepository;

@Service
public class ScheduleService {

  @Autowired
  private ScheduleRepository repository;

  // CREATE
  public Schedule create(Schedule obj) {
    return repository.save(obj);
  }

  // READ
  public List<Schedule> findAll() {
    return repository.findAll();
  }

  public Schedule findById(Long id) {
    Optional<Schedule> obj = repository.findById(id);
    return obj.get();
  }

  // UPDATE
  public Schedule update(Long id, Schedule obj) {
    Schedule entity = repository.getReferenceById(id);
    updateFields(entity, obj);
    return repository.save(entity);
  }

  // DELETE
  public void delete(Long id) {
    repository.deleteById(id);
  }

  // UPDATE AUX
  private void updateFields(Schedule entity, Schedule obj) {
    entity.setDate(obj.getDate());
    entity.setIsActive(obj.getIsActive());
  }
}
