package projeto.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.clinica.entities.ClinicalProcedure;
import projeto.clinica.repositories.ClinicalProcedureRepository;

@Service
public class ClinicalProcedureService {

  @Autowired
  private ClinicalProcedureRepository repository;

  // CREATE
  public ClinicalProcedure create(ClinicalProcedure obj) {
    return repository.save(obj);
  }

  // READ
  public List<ClinicalProcedure> findAll() {
    return repository.findAll();
  }

  public ClinicalProcedure findById(Long id) {
    Optional<ClinicalProcedure> obj = repository.findById(id);
    return obj.get();
  }

  // UPDATE
  public ClinicalProcedure update(Long id, ClinicalProcedure obj) {
    ClinicalProcedure entity = repository.getReferenceById(id);
    updateFields(entity, obj);
    return repository.save(entity);
  }

  // DELETE
  public void delete(Long id) {
    repository.deleteById(id);
  }

  private void updateFields(ClinicalProcedure entity, ClinicalProcedure obj) {
    entity.setName(obj.getName());
    entity.setIsActive(obj.getIsActive());
  }
}
