package projeto.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.clinica.entities.ClinicalProcedure;

@Repository
public interface ClinicalProcedureRepository extends JpaRepository<ClinicalProcedure, Long> {

}
