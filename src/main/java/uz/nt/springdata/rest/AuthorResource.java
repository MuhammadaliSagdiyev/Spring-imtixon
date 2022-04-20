package uz.nt.springdata.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.springdata.DTO.AuthorDTO;
import uz.nt.springdata.DTO.ResponseDTO;
import uz.nt.springdata.reposytory.AuthorRepository;
import uz.nt.springdata.servise.AuthorServise;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorResource {

    private final AuthorRepository authorRepository;
    private final AuthorServise authorServise;

    @GetMapping("/get-all-author")
    public ResponseDTO<List<AuthorDTO>> getAuthors(){
        return authorServise.getAllAuthors();
    }

    @PostMapping("/addAuthor")
    public ResponseDTO<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO){
        return authorServise.addAuthor(authorDTO);
    }

    @PutMapping("/updateAuthor")
    public ResponseDTO<AuthorDTO> updateAuthor(@RequestBody AuthorDTO authorDTO){
        return authorServise.updateAuthor(authorDTO);
    }

    @DeleteMapping("/deleteAuthor")
    public ResponseDTO<AuthorDTO> deleteAuthor(@RequestBody AuthorDTO authorDTO){
        return authorServise.deleteAuthor(authorDTO);
    }
}
