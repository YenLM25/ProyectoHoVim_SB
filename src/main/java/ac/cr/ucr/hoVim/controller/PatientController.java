package ac.cr.ucr.hoVim.controller;

import ac.cr.ucr.hoVim.model.Patient;
import ac.cr.ucr.hoVim.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatient(){
        return this.patientService.findAllPatient();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable Integer id){
        Optional<Patient> patient = this.patientService.findByIDPatient(id);
        if(patient==null || patient.get().getPatientId()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente con el ID "+id+" no encontrado");
        }
        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public ResponseEntity<?> addPatient(@Validated @RequestBody Patient patient, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        Patient patientSave = this.patientService.savePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientSave);
    }

}