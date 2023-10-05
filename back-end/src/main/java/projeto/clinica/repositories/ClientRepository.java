package projeto.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.clinica.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
