package ac.cr.ucr.hoVim.controller;

import ac.cr.ucr.hoVim.model.User;
import ac.cr.ucr.hoVim.service.UserService;
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
@RequestMapping("/api/hoVim/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public List<User> findAllUser(){

        return this.userService.findAllUser();

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdUser(@PathVariable Integer id){
        Optional<User> user = this.userService.findByIdUser(id);
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID: " + id + " not found.");
        }
        return ResponseEntity.ok(user);
    }



    @PostMapping
    public ResponseEntity<?> saveUser(@Validated @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return  ResponseEntity.badRequest().body(errors);
        }
        //verifica si el id existe
        Optional<User> userOp = this.userService.findByIdUser(user.getId());
        if(userOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The user with the ID: " + user.getId() + " is already registered.");
        }
        User userAdd = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userAdd);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        Optional<User> userOp = this.userService.findByIdUser(id);
        if(!userOp.isPresent()){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("The id: "+id+ " not found.");

        }
        this.userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("The user with the ID: " + id + " was successfully deleted.");
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> EditUser(@PathVariable Integer id, @RequestBody User userEdited, BindingResult result){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return  ResponseEntity.badRequest().body(errors);
        }
        Optional<User> userOp = this.userService.findByIdUser(id);
        if(!userOp.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The user with ID: " + id + " is not registered.");
        }
        return ResponseEntity.ok(this.userService.editUser(id, userEdited));
    }

}//End
