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

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/hoVim/patient")
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
        if(!patient.isPresent()){
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

        Patient patientAdd = this.patientService.savePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientAdd);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id){
        Optional<Patient> patientOp=this.patientService.findByIDPatient(id);
        if(!patientOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID "+id+" NO se encuentra registrado.");
        }
        this.patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editPatient(@Validated @PathVariable Integer id, @RequestBody Patient patientEdit, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            for(FieldError error : result.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Optional<Patient> patientOp = this.patientService.findByIDPatient(id);
        if(!patientOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el ID " + id + " NO se encuentra registrado.");
        }
        return ResponseEntity.ok(this.patientService.editPatient(id, patientEdit));
    }

    @GetMapping("/findByName/{name}")
    public List<Patient> findByName(@PathVariable String name){
        return this.patientService.findByName(name);
    }

}