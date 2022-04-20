package uz.nt.springdata.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.nt.springdata.DAO.Author;
import uz.nt.springdata.DAO.Book;
import uz.nt.springdata.DTO.AuthorDTO;
import uz.nt.springdata.DTO.ResponseDTO;
import uz.nt.springdata.mapping.AuthorMapping;
import uz.nt.springdata.mapping.BookMapping;
import uz.nt.springdata.reposytory.AuthorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServise {
    private final AuthorRepository authorRepository;

    public String getAuthorName(Integer id){
        return authorRepository.getAuthorById(id).getFirst_name();
    }

    public ResponseDTO<List<AuthorDTO>> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        if(!authors.isEmpty()){
            List<AuthorDTO> lst = new ArrayList<>();
            for (int i = 0; i < authors.size(); i++) {
                lst.add(AuthorMapping.toDto(authors.get(i)));
            }
            return new ResponseDTO<>(true, 0, "OK", lst);
        }
        return new ResponseDTO<>(false, -1, "ERROR", null);
    }



    public ResponseDTO<AuthorDTO> addAuthor(AuthorDTO authorDTO){
        try {
            Author author = AuthorMapping.toEntity(authorDTO);
            authorRepository.save(author);
            return new ResponseDTO<>(true, 0, "OK", authorDTO);
        }
        catch (Exception e){
            return new ResponseDTO<>(false, -50, "ERROR", null);
        }
    }

    public ResponseDTO<AuthorDTO> updateAuthor(AuthorDTO authorDTO){
        try {
            if(authorDTO.getId()==null){
                return new ResponseDTO<>(false, -2, "ID null bo'lishi mumkin emas!", authorDTO);
            }

            Optional<Author> author1 =  authorRepository.findById(authorDTO.getId());
            if (!author1.isPresent()){
                return new ResponseDTO<>(false, -3, "Bu ID li author topilmadi!", authorDTO);
            }

            Author author = author1.get();
            AuthorMapping.setEntity(author, authorDTO);

            authorRepository.save(author);
            return new ResponseDTO<>(true, 0, "OK", authorDTO);
        }
        catch (Exception e){
            return new ResponseDTO<>(false, -5, "ERROR", null);
        }
    }
}
