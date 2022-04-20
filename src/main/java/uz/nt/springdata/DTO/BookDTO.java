package uz.nt.springdata.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer id;
    private String nameUz;
    private String nameRu;
    private Integer cost;
    private Date publisherDate;
    private Integer pageCount;
    private AuthorDTO author;
    private String genre;
    private PublisherDTO publisher;


    public BookDTO(Integer id, String nameUz, String nameRu, Integer cost, Date publisherDate, Integer pageCount, String genre){
        this.id = id;
        this.nameUz = nameUz;
        this.nameRu = nameRu;
        this.cost = cost;
        this.publisherDate = publisherDate;
        this.pageCount = pageCount;
        this.genre = genre;
    }

    public String toString(){
        return String.format("%d-kitob: \nNomi: %s \nNarxi: %d \nJanri: %s \nAvtor: %s", id, nameUz, cost, genre, author);
    }
}
