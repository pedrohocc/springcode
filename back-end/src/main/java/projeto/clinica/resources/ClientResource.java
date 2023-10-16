package projeto.clinica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projeto.clinica.entities.Client;
import projeto.clinica.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

  @Autowired
  private ClientService services;

  // CREATE
  @PostMapping
  public ResponseEntity<Client> create(@RequestBody Client obj) {

    obj = services.create(obj);

    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }

  // READ
  @GetMapping
  public ResponseEntity<List<Client>> findAll() {

    List<Client> list = services.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Client> findById(@PathVariable Long id) {

    Client obj = services.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  // UPDATE
  @PutMapping(value = "/{id}")
  public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj) {

    obj = services.update(id, obj);

    return ResponseEntity.ok().body(obj);
  }

  // DELETE
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {

    services.delete(id);

    return ResponseEntity.noContent().build();
  }
}
