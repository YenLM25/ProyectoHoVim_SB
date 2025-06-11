package ac.cr.ucr.hoVim.repository;

import ac.cr.ucr.hoVim.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findByName(String name);
}
