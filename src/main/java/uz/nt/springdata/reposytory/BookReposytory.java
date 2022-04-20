package uz.nt.springdata.reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.springdata.DAO.Book;
import uz.nt.springdata.DTO.BookDTO;

@Repository
public interface BookReposytory extends JpaRepository<Book, Integer> {
    Book getBookById(Integer id);
}
