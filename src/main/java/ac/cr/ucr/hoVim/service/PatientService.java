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

    public Patient editPatient(Integer id, Patient patientEdit) {
        Optional<Patient> patientOp = this.patientRepository.findById(id);
        if (patientOp.isPresent()) {
            Patient patient = patientOp.get();
            patient = patientEdit;
            return this.patientRepository.save(patient);
        }
        return null;
    }

    public List<Patient> findByName(String name){
        return this.patientRepository.findByName(name);
    }

}
