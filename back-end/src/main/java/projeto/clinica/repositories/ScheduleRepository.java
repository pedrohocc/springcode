package projeto.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto.clinica.entities.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
