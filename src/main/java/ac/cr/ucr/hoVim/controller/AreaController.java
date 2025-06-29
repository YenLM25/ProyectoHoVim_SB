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

@CrossOrigin(origins = "http://127.0.0.1:5500")
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
    @GetMapping("/{areaId}")
    public ResponseEntity<?> getArea (@PathVariable Integer areaId) {

        Optional<Area> area = this.areaService.findAreaById(areaId);

        if (!area.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The area " +areaId+ " was not found" );
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

        area.setAreaId(null);
        Area areaAdd = this.areaService.saveArea(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(areaAdd);

    }

    //Elimina un area si el id esta registrado
    @DeleteMapping("/{areaId}")
    public ResponseEntity<?> deleteArea(@PathVariable Integer areaId) {

        Optional<Area> areaOp = this.areaService.findAreaById(areaId);

        if(!areaOp.isPresent()) {

            return  ResponseEntity.status(HttpStatus.CONFLICT).body("The area "+areaId+ " was not found.");

        }

        this.areaService.deleteArea(areaId);
        return ResponseEntity.status(HttpStatus.CONFLICT).body("The area "+areaId+" was successfully deteled");

    }

    //Edita el area segun id, solo si esta registrado. Verifica que el id no pueda ser editado
    @PutMapping("/{areaId}")
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

            return ResponseEntity.status(HttpStatus.CONFLICT).body("The area with " + areaId + " ID is not registered.");

        }

        if (!areaId.equals(areaEdit.getAreaId())) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("The ID is not the same as requested");

        }

        return ResponseEntity.ok(this.areaService.editArea(areaId, areaEdit));

    }

}
