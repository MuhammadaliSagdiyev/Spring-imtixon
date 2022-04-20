package uz.nt.springdata.mapping;

import uz.nt.springdata.DAO.Publisher;
import uz.nt.springdata.DTO.PublisherDTO;

public class PublisherMapping {

    public static PublisherDTO toDto(Publisher publisher){
        return new PublisherDTO(publisher.getId(),
                publisher.getName(),
                publisher.getAddress_id());
    }

    public static Publisher toEntity(PublisherDTO publisherDTO){
        return new Publisher (publisherDTO.getId(),
                publisherDTO.getName(),
                publisherDTO.getAddress_id());
    }

}
