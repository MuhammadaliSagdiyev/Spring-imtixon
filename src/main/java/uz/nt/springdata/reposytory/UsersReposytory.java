package uz.nt.springdata.reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.nt.springdata.DAO.User;
import uz.nt.springdata.DTO.UserDTO;

import java.util.List;

public interface UsersReposytory extends JpaRepository<User, Integer> {
    User getUsernameByUsername(String username);
    User getBookById(Integer id);
}
