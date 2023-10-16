package projeto.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.clinica.entities.Physiotherapist;
import projeto.clinica.repositories.PhysiotherapistRepository;

@Service
public class PhysiotherapistService {

  @Autowired
  private PhysiotherapistRepository repository;

  // CREATE
  public Physiotherapist create(Physiotherapist obj) {
    return repository.save(obj);
  }

  // READ
  public List<Physiotherapist> findAll() {
    return repository.findAll();
  }

  public Physiotherapist findById(Long id) {
    Optional<Physiotherapist> obj = repository.findById(id);
    return obj.get();
  }

  // UPDATE
  public Physiotherapist update(Long id, Physiotherapist obj) {
    Physiotherapist entity = repository.getReferenceById(id);
    updateFields(entity, obj);
    return repository.save(entity);
  }

  // DELETE
  public void delete(Long id) {
    repository.deleteById(id);
  }

  private void updateFields(Physiotherapist entity, Physiotherapist obj) {
    entity.setName(obj.getName());
    entity.setCpf(obj.getCpf());
    entity.setCoffito(obj.getCoffito());
    entity.setStreetAddress(obj.getStreetAddress());
    entity.setNumberAddress(obj.getNumberAddress());
    entity.setDistrictAddress(obj.getDistrictAddress());
    entity.setCityAddress(obj.getCityAddress());
    entity.setZipCode(obj.getZipCode());
    entity.setIsActive(obj.getIsActive());
  }
}
