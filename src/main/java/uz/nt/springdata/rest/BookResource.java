package uz.nt.springdata.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.springdata.DTO.BookDTO;
import uz.nt.springdata.DTO.ResponseDTO;
import uz.nt.springdata.reposytory.AuthorRepository;
import uz.nt.springdata.servise.BookServise;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookResource {

    private final BookServise bookServise;
    private final AuthorRepository AuthorRepository;

    @GetMapping("/get-all")
    public ResponseDTO<List<BookDTO>> getAll(){
        return bookServise.getAllBooks();
    }

    @PostMapping("/add")
    public ResponseDTO<BookDTO> add(@RequestBody BookDTO bookDTO){
        return bookServise.addNew(bookDTO);
    }

    @PutMapping("/update")
    public ResponseDTO<BookDTO> update(@RequestBody BookDTO bookDTO){
        return bookServise.update(bookDTO);
    }

    @DeleteMapping("/delete")
    public ResponseDTO<BookDTO> delete(@RequestBody BookDTO bookDTO){
        return bookServise.delete(bookDTO);
    }

}