package ac.cr.ucr.hoVim.service;

import ac.cr.ucr.hoVim.model.User;
import ac.cr.ucr.hoVim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {

        return userRepository.save(user);
    }


    public List<User> findAllUser() {

        return this.userRepository.findAll();
    }


    public Optional<User> findByIdUser(Integer id) {

        return this.userRepository.findById(id);
    }


    public void  deleteUser(Integer id) {

        this.userRepository.deleteById(id);
    }


    public User editUser(Integer id, User userEdited) {
        Optional<User> userOp= this.userRepository.findById(id);
        if(userOp.isPresent()){
            User user= userOp.get();
            user = userEdited;
            return this.userRepository.save(user);
        }
        return null;
    }

}//End


