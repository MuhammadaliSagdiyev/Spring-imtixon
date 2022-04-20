package uz.nt.springdata.mapping;

import uz.nt.springdata.DAO.Author;
import uz.nt.springdata.DTO.AuthorDTO;

public class AuthorMapping {

    public static AuthorDTO toDto(Author author){
        return new AuthorDTO(author.getId(),
                author.getLast_name(),
                author.getFirst_name(),
                author.getBirth_date()
                );
    }

    public static Author toEntity(AuthorDTO authorDTO){
        return new Author(authorDTO.getId(),
                authorDTO.getLast_name(),
                authorDTO.getFirst_name(),
                authorDTO.getBirth_date());
    }

    public static void setEntity(Author author, AuthorDTO authorDTO) {
        author.setId(authorDTO.getId());
        author.setFirst_name(authorDTO.getFirst_name());
        author.setLast_name(authorDTO.getLast_name());
        author.setBirth_date(authorDTO.getBirth_date());
    }
}
