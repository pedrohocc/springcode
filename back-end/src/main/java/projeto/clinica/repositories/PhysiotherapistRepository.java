package projeto.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.clinica.entities.Physiotherapist;

@Repository
public interface PhysiotherapistRepository extends JpaRepository<Physiotherapist, Long> {

}
