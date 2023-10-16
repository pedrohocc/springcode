package projeto.clinica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projeto.clinica.entities.Physiotherapist;
import projeto.clinica.services.PhysiotherapistService;

@RestController
@RequestMapping(value = "/physio")
public class PhysiotherapistResource {

  @Autowired
  private PhysiotherapistService services;

  // CREATE
  @PostMapping
  public ResponseEntity<Physiotherapist> create(@RequestBody Physiotherapist obj) {

    obj = services.create(obj);

    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }

  // READ
  @GetMapping
  public ResponseEntity<List<Physiotherapist>> findAll() {

    List<Physiotherapist> list = services.findAll();

    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Physiotherapist> findById(@PathVariable Long id) {

    Physiotherapist obj = services.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  // UPDATE
  @PutMapping(value = "/{id}")
  public ResponseEntity<Physiotherapist> update(@PathVariable Long id, @RequestBody Physiotherapist obj) {

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
