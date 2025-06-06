package ac.cr.ucr.hoVim.repository;

import ac.cr.ucr.hoVim.model.Patient;
import java.util.List;

public interface IPatientRegister {

    public Patient addPatient(Patient patient);
    public List<Patient> getAllPatient();
    public Patient getPatient(Integer id);
    public Patient deletePatient (Integer id);
    public Patient editPatient(Integer id, Patient patient);

}
