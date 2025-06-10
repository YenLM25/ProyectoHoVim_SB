package ac.cr.ucr.hoVim.controller;

import ac.cr.ucr.hoVim.model.Area;
import ac.cr.ucr.hoVim.service.AreaService;
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
@RequestMapping("/api/hoVim/area")
public class AreaController {

    @Autowired
    AreaService areaService;

    //Muestra todas las areas registradas
    @GetMapping
    public List<Area> getAllAreas() {

        return this.areaService.findAllAreas();

    }

    //Si el id esta registardo, muestra un area
    @GetMapping("/{id}")
    public ResponseEntity<?> getArea (@PathVariable Integer areaId) {

        Optional<Area> area = this.areaService.findAreaById(areaId);

        if (area == null || area.get().getAreaId() == 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El area con id: " +areaId+ " no fue encontrada" );
        }

        return ResponseEntity.ok(area);

    }

    //Guarda un area si no esta registrado el id
    @PostMapping
    public ResponseEntity<?> addArea(@Validated @RequestBody Area area, BindingResult result) {

        if (result.hasErrors()) {

            Map<String, String> errors = new HashMap<>();
            for(FieldError error : result.getFieldErrors()) {

                errors.put(error.getField(), error.getDefaultMessage());

            }

            return ResponseEntity.badRequest().body(errors);

        }

        Optional<Area> areaOp = this.areaService.findAreaById(area.getAreaId());
        if (areaOp.isPresent()) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario con el id "+area.getAreaId()+" ya se encuentra registrado");

        }

        Area areaAdd = this.areaService.saveArea(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(areaAdd);

    }

    //Elimina un area si el id esta registrado
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArea(@PathVariable Integer areaId) {

        Optional<Area> areaOp = this.areaService.findAreaById(areaId);

        if(!areaOp.isPresent()) {

            return  ResponseEntity.status(HttpStatus.CONFLICT).body("El id "+areaId+ " no fue encuntrado.");

        }

        this.areaService.deleteArea(areaId);
        return ResponseEntity.status(HttpStatus.CONFLICT).body("El area "+areaId+" no se encuentra registrada");

    }

    //Edita el area segun id, solo si esta registrado. No verifica que el id no cambie
    @PutMapping("/{id}")
    public ResponseEntity<?> editArea(@Validated @PathVariable Integer areaId, @RequestBody Area areaEdit, BindingResult result) {

        if(result.hasErrors()) {

            Map<String,String> errors = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }

            return  ResponseEntity.badRequest().body(errors);

        }
        Optional<Area> areaOp = this.areaService.findAreaById(areaId);

        if(!areaOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The area with ID: " + areaId + " is not registered.");
        }

        return ResponseEntity.ok(this.areaService.editArea(areaId, areaEdit));

    }

}
