package ac.cr.ucr.hoVim.repository;

import ac.cr.ucr.hoVim.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
