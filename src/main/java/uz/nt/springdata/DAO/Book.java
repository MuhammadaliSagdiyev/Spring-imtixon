package uz.nt.springdata.DAO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name_uz")
    private String nameUz;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "cost")
    private Integer cost;

    @Column(name = "publisher_date")
    private Date publisherDate;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "author_id")
    private Integer authorId;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publisher_id")
    private Integer publisherId;

    public Book(Integer id, String nameUz, int cost, int authorId, String genre) {
        this.id = id;
        this.nameUz = nameUz;
        this.cost = cost;
        this.authorId = authorId;
        this.genre = genre;
    }
}
