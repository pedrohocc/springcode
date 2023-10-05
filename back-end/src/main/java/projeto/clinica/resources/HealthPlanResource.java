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

import projeto.clinica.entities.HealthPlan;
import projeto.clinica.services.HealthPlanService;

@RestController
@RequestMapping(value = "/health-plans")
public class HealthPlanResource {

  @Autowired
  private HealthPlanService services;

  @PostMapping
  public ResponseEntity<HealthPlan> create(@RequestBody HealthPlan obj) {

    obj = services.create(obj);

    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();

    return ResponseEntity.created(uri).body(obj);
  }

  @GetMapping
  public ResponseEntity<List<HealthPlan>> findAll() {

    List<HealthPlan> healthPlansList = services.findAll();

    return ResponseEntity.ok().body(healthPlansList);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<HealthPlan> findById(@PathVariable Long id) {

    HealthPlan obj = services.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<HealthPlan> update(@PathVariable Long id, @RequestBody HealthPlan obj) {

    obj = services.update(id, obj);

    return ResponseEntity.ok().body(obj);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {

    services.delete(id);

    return ResponseEntity.noContent().build();
  }
}
