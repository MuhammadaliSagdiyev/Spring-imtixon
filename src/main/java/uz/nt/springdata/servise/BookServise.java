package uz.nt.springdata.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.nt.springdata.DAO.Author;
import uz.nt.springdata.DAO.Book;
import uz.nt.springdata.DAO.Publisher;
import uz.nt.springdata.DTO.BookDTO;
import uz.nt.springdata.DTO.ResponseDTO;
import uz.nt.springdata.mapping.AuthorMapping;
import uz.nt.springdata.mapping.BookMapping;
import uz.nt.springdata.mapping.PublisherMapping;
import uz.nt.springdata.reposytory.AuthorRepository;
import uz.nt.springdata.reposytory.BookReposytory;
import uz.nt.springdata.reposytory.PublisherReposytory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServise {

    private final BookReposytory bookReposytory;
    private final AuthorRepository authorRepository;
    private final PublisherReposytory publisherReposytory;



    public ResponseDTO<BookDTO> addNew(BookDTO bookDTO){
        try {
            Book book = BookMapping.toEntity(bookDTO);
            bookReposytory.save(book);
            return new ResponseDTO<>(true, 0, "OK", BookMapping.toDto(book));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, -1, "ERROR", null);
        }
    }



    public ResponseDTO<List<BookDTO>> getAllBooks(){
        List<Book> books = bookReposytory.findAll();
        if(!books.isEmpty()){
            List<BookDTO> response = new ArrayList<>();
            for (int i = 0; i < books.size(); i++){
                response.add(BookMapping.toDto(books.get(i)));
                Author author = authorRepository.getAuthorById(books.get(i).getAuthorId());
                Publisher publisher = publisherReposytory.getPublisherById(books.get(i).getPublisherId());
                response.get(i).setAuthor(AuthorMapping.toDto(author));
                response.get(i).setPublisher(PublisherMapping.toDto(publisher));
            }

            return new ResponseDTO<>(true, 0, "OK", response);
        }

        return new ResponseDTO<>(false, -1, "ERROR", null);
    }



    public ResponseDTO<BookDTO> update(BookDTO bookDTO){
        try {
            if(bookDTO.getId()==null){
                return new ResponseDTO<>(false, -2, "ID null bo'lishi mumkin emas!", bookDTO);
            }

            Optional<Book> book =  bookReposytory.findById(bookDTO.getId());
            if (!book.isPresent()){
                return new ResponseDTO<>(false, -3, "Bu ID li kitob topilmadi!", bookDTO);
            }

            Book book1 = book.get();
            BookMapping.setEntity(book1, bookDTO);

            bookReposytory.save(book1);
            return new ResponseDTO<>(true, 0, "OK", bookDTO);
        }
        catch (Exception e){
            return new ResponseDTO<>(false, -5, "ERROR", null);
        }
    }



    public ResponseDTO<BookDTO> delete(BookDTO bookDTO){
        if(bookDTO.getId()==null){
            return new ResponseDTO<>(false, -2, "ID null bo'lishi mumkin emas!", bookDTO);
        }

        if(bookReposytory.getBookById(bookDTO.getId()) == null){
            return new ResponseDTO<>(false, -3, "Bu ID li kitob topilmadi!", bookDTO);
        }

        Book book = BookMapping.toEntity(bookDTO);
        bookReposytory.delete(book);

        return new ResponseDTO<>(true, 0, "OK", bookDTO);
    }

}