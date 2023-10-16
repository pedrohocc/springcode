package projeto.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.clinica.entities.Client;
import projeto.clinica.repositories.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  // CREATE
  public Client create(Client obj) {
    return repository.save(obj);
  }

  // READ
  public List<Client> findAll() {
    return repository.findAll();
  }

  public Client findById(Long id) {
    Optional<Client> obj = repository.findById(id);
    return obj.get();
  }

  // UPDATE
  public Client update(Long id, Client obj) {
    Client entity = repository.getReferenceById(id);
    updateFields(entity, obj);
    return repository.save(entity);
  }

  // DELETE
  public void delete(Long id) {
    repository.deleteById(id);
  }

  // UPDATE AUX
  private void updateFields(Client entity, Client obj) {
    entity.setName(obj.getName());
    entity.setCpf(obj.getCpf());
    entity.setAge(obj.getAge());
    entity.setStreetAddress(obj.getStreetAddress());
    entity.setNumberAddress(obj.getNumberAddress());
    entity.setDistrictAddress(obj.getDistrictAddress());
    entity.setCityAddress(obj.getCityAddress());
    entity.setZipCode(obj.getZipCode());
    entity.setPhone(obj.getPhone());
    entity.setPaymentDate(obj.getPaymentDate());
    entity.setPaymentStatus(obj.getPaymentStatus());
    entity.setIsActive(obj.getIsActive());
  }
}
