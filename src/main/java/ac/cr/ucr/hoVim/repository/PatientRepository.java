package ac.cr.ucr.hoVim.repository;

import ac.cr.ucr.hoVim.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
