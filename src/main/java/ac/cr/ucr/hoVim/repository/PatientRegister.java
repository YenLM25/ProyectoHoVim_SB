package ac.cr.ucr.hoVim.repository;

import ac.cr.ucr.hoVim.model.Patient;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRegister {

        private ArrayList<Patient> listPatient;
        public PatientRegister(){
            this.listPatient =new ArrayList<>();

        }

        //@Override
        public Patient addUser(Patient patient) {
            this.listPatient.add(patient);
            return patient;
        }

        //@Override
        public List<Patient> getAllPatient() {
            return this.listPatient;
        }

        //@Override
        public Patient getPatient(Integer id) {
            for (int i = 0; i < this.listPatient.size(); i++) {
                if (this.listPatient.get(i).getPatientId() == id) {
                    return this.listPatient.get(i);
                }
            }
            return new Patient();
        }

        //@Override
        public Patient deletePatient(Integer id) {
            for (int i = 0; i < this.listPatient.size(); i++) {
                if (this.listPatient.get(i).getPatientId() == id) {
                    Patient p = this.listPatient.get(i);
                    this.listPatient.remove(i);
                    return p;
                }
            }
            return new Patient();
        }

        //@Override
        public Patient editPatient(Integer id, Patient patientEdit) {
            for (int i=0;i<this.listPatient.size();i++){
                if(this.listPatient.get(i).getPatientId()==id){
                    this.listPatient.set(i,patientEdit);
                    return this.listPatient.get(i);
                }
            }
            return new Patient();
        }

        public Boolean existID(Integer id) {
            for (int i = 0; i < this.listPatient.size(); i++) {
                if (this.listPatient.get(i).getPatientId() == id) {
                    return true;
                }
            }
            return false;
        }

}