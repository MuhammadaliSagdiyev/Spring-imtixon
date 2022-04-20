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

    public static void setEntity(Publisher publisher, PublisherDTO publisherDTO) {
        publisher.setId(publisherDTO.getId());
        publisher.setName(publisherDTO.getName());
        publisher.setAddress_id(publisherDTO.getAddress_id());
    }
}
