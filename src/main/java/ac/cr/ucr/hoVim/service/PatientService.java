package ac.cr.ucr.hoVim.service;

import ac.cr.ucr.hoVim.model.Patient;
import ac.cr.ucr.hoVim.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }


    public List<Patient> findAllPatient() {
        return this.patientRepository.findAll();
    }


    public Optional<Patient> findByIDPatient(Integer id) {
        return this.patientRepository.findById(id);
    }


    public void deletePatient(Integer id) {
        this.patientRepository.deleteById(id);
    }

}
