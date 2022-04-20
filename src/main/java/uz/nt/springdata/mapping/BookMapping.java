package uz.nt.springdata.mapping;

import lombok.RequiredArgsConstructor;
import uz.nt.springdata.DAO.Book;
import uz.nt.springdata.DTO.BookDTO;
import uz.nt.springdata.servise.AuthorServise;

import java.util.Optional;

@RequiredArgsConstructor
public class BookMapping {

    public static BookDTO toDto(Book book){
        return new BookDTO(book.getId(),
                book.getNameUz(),
                book.getNameRu(),
                book.getCost(),
                book.getPublisherDate(),
                book.getPageCount(),
                book.getGenre());
    }

    public static Book toEntity(BookDTO bookDTO){
        return new Book(bookDTO.getId(),
                bookDTO.getNameUz(),
                bookDTO.getCost(),
                1,
                bookDTO.getGenre());
    }

    public static void setEntity(Book book, BookDTO bookDTO) {
        book.setId(bookDTO.getId());
        book.setNameUz(bookDTO.getNameUz());
        book.setNameRu(bookDTO.getNameRu());
        book.setCost(bookDTO.getCost());
        book.setPageCount(bookDTO.getPageCount());
        book.setPublisherDate(bookDTO.getPublisherDate());
        book.setGenre(bookDTO.getGenre());
    }
}
