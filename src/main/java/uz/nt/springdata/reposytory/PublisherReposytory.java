package uz.nt.springdata.reposytory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nt.springdata.DAO.Publisher;

@Repository
public interface PublisherReposytory extends JpaRepository<Publisher, Integer> {
    Publisher getPublisherById(Integer id);
}
