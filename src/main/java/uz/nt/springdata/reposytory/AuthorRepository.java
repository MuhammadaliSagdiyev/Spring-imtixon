package uz.nt.springdata.reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.springdata.DAO.Author;
import uz.nt.springdata.DTO.AuthorDTO;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author getAuthorById(Integer id);

}
