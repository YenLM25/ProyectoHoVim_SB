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

@RestController
@RequestMapping("/api/area")
public class AreaController {

    @Autowired
    AreaService areaService;

    @GetMapping
    public List<Area> getAllAreas() {

        return this.areaService.getAllAreas();

    }

    //Area por id
    @GetMapping("/{id}")
    public ResponseEntity<?> getArea(@PathVariable Integer areaId) {

        Area area = this.areaService.getArea(areaId);

        if (area == null || area.getAreaId() == 0) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El area con id: " +areaId+ " no fue encontrada" );
        }

        return ResponseEntity.ok(area);

    }


    @PostMapping
    public ResponseEntity<?> addArea(@Validated @RequestBody Area area, BindingResult result) {

        if (result.hasErrors()) {

            Map<String, String> errors = new HashMap<>();
            for(FieldError error : result.getFieldErrors()) {

                errors.put(error.getField(), error.getDefaultMessage());

            }

            return ResponseEntity.badRequest().body(errors);

        }

        if (this.areaService.existId(area.getAreaId())) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("El area con id "+area.getAreaId()+" ya esta registrada");

        }

        Area areaAdd = this.areaService.addArea(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(areaAdd);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArea(@PathVariable Integer areaId) {

        if (this.areaService.existId(areaId)) {

            this.areaService.deleteArea(areaId);
            return  ResponseEntity.status(HttpStatus.OK).body("El area con id "+areaId+" fue eliminada correctamente");

        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("El area "+areaId+" no se encuentra registrada");

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editArea(@Validated @PathVariable Integer areaId, @RequestBody Area areaEdit, BindingResult result) {

        if(result.hasErrors()){

            Map<String, String> errors = new HashMap<>();

            for(FieldError error: result.getFieldErrors()) {

                errors.put(error.getField(), error.getDefaultMessage());

            }

            return ResponseEntity.badRequest().body(errors);

        }

        if(this.areaService.existId(areaId)) {
            if (areaId != areaEdit.getAreaId()){

                return ResponseEntity.status (HttpStatus.CONFLICT).body("El ID de busqueda no es igual al ID del objeto editado");

            } else {

                return ResponseEntity.ok(this.areaService.editArea(areaId, areaEdit));
            }

        }

        return ResponseEntity.status (HttpStatus.CONFLICT).body("El area con el ID "+areaId+" no se encuentra registrada");


    }


}
