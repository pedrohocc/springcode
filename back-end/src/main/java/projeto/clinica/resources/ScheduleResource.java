package projeto.clinica.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projeto.clinica.entities.Schedule;
import projeto.clinica.services.ScheduleService;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleResource {

  private ScheduleService services;

  // CREATE
  @PostMapping
  public ResponseEntity<Schedule> create(@RequestBody Schedule obj) {

    obj = services.create(obj);

    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }

  // READ
  @GetMapping
  public ResponseEntity<List<Schedule>> findAll() {

    List<Schedule> list = services.findAll();

    return ResponseEntity.ok().body(list);
  }

  // UPDATE
  @PutMapping(value = "/{id}")
  public ResponseEntity<Schedule> findById(@PathVariable Long id) {

    Schedule obj = services.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  // DELETE
  public ResponseEntity<Void> delete(@PathVariable Long id) {

    services.delete(id);

    return ResponseEntity.noContent().build();
  }
}
