package ac.cr.ucr.hoVim.controller;

import ac.cr.ucr.hoVim.model.Visit;
import ac.cr.ucr.hoVim.service.VisitService;
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
@RequestMapping("/api/hoViM/visit")
public class VisitContoller {

    @Autowired
    VisitService visitService;

    @GetMapping
    public List<Visit>getAllVisits(){
        return this.visitService.findAllVisits();
    }

    @GetMapping("/{visitId}")
    public ResponseEntity<?> getVisit(@PathVariable Integer visitId){
        Optional<Visit>visit=this.visitService.findByIdVisit(visitId);
        if (!visit.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The visit with ID: " + visitId + " not found.");
        }
        return ResponseEntity.ok(visit);
    }

    @PostMapping
    public ResponseEntity<?> addVisit(@Validated @RequestBody Visit visit, BindingResult result){
        if (result.hasErrors()){
            Map<String, String> errors=new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Visit visitAdd=this.visitService.saveVisit(visit);
        return ResponseEntity.status(HttpStatus.CREATED).body(visitAdd);
    }

    @DeleteMapping("/{visitId}")
    public ResponseEntity<?> deleteVisit(@PathVariable Integer visitId){
        Optional<Visit>visitOp=this.visitService.findByIdVisit(visitId);
        if(!visitOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The visit with ID: "+visitId+" is not registered.");
        }
        this.visitService.deleteVisit(visitId);
        return ResponseEntity.status(HttpStatus.OK).body("The user with ID: " + visitId + " was deleted.");
    }

    @PutMapping("/{visitId}")
    public ResponseEntity<?> editVisit (@Validated @PathVariable Integer visitId, @RequestBody Visit visitEdited, BindingResult result){
        if(result.hasErrors()){
            Map<String, String> errors=new HashMap<>();
            for (FieldError error: result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Optional<Visit>visitOp=this.visitService.findByIdVisit(visitId);
        if (!visitOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The user with ID: "+visitId+" is not registered.");
        }
        return ResponseEntity.ok(this.visitService.editVisit(visitId, visitEdited));
    }



}//End of class
