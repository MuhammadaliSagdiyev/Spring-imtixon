package uz.nt.springdata.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.nt.springdata.DAO.Author;
import uz.nt.springdata.DAO.Book;
import uz.nt.springdata.DAO.Publisher;
import uz.nt.springdata.DTO.BookDTO;
import uz.nt.springdata.DTO.PublisherDTO;
import uz.nt.springdata.DTO.ResponseDTO;
import uz.nt.springdata.mapping.AuthorMapping;
import uz.nt.springdata.mapping.BookMapping;
import uz.nt.springdata.mapping.PublisherMapping;
import uz.nt.springdata.reposytory.PublisherReposytory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServise {
    private final PublisherReposytory publisherReposytory;

    public ResponseDTO<List<PublisherDTO>> getPublishers(){
        List<Publisher> publishers = publisherReposytory.findAll();
        if(!publishers.isEmpty()){
            List<PublisherDTO> response = new ArrayList<>();
            for (int i = 0; i < publishers.size(); i++){
                response.add(PublisherMapping.toDto(publishers.get(i)));
            }

            return new ResponseDTO<>(true, 0, "OK", response);
        }

        return new ResponseDTO<>(false, -1, "ERROR", null);
    }


    public ResponseDTO<PublisherDTO> addPublisher(PublisherDTO publisherDTO){
        try {
            Publisher publisher = PublisherMapping.toEntity(publisherDTO);
            publisherReposytory.save(publisher);
            return new ResponseDTO<>(true, 0, "OK", publisherDTO);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, -1, "ERROR", null);
        }
    }


    public ResponseDTO<PublisherDTO> updatePublisher(PublisherDTO publisherDTO){
        try {
            if(publisherDTO.getId()==null){
                return new ResponseDTO<>(false, -2, "ID null bo'lishi mumkin emas!", publisherDTO);
            }

            Optional<Publisher> publisher =  publisherReposytory.findById(publisherDTO.getId());
            if (!publisher.isPresent()){
                return new ResponseDTO<>(false, -3, "Bu ID li publisher topilmadi!", publisherDTO);
            }

            Publisher publisher1 = publisher.get();
            PublisherMapping.setEntity(publisher1, publisherDTO);

            publisherReposytory.save(publisher1);
            return new ResponseDTO<>(true, 0, "OK", publisherDTO);
        }
        catch (Exception e){
            return new ResponseDTO<>(false, -5, "ERROR", null);
        }
    }

    public ResponseDTO<PublisherDTO> deletePublisher(PublisherDTO publisherDTO) {
        if(publisherDTO.getId()==null){
            return new ResponseDTO<>(false, -2, "ID null bo'lishi mumkin emas!", publisherDTO);
        }

        if(publisherReposytory.getPublisherById(publisherDTO.getId()) == null){
            return new ResponseDTO<>(false, -3, "Bu ID li publisher topilmadi!", publisherDTO);
        }

        Publisher publisher = PublisherMapping.toEntity(publisherDTO);
        publisherReposytory.delete(publisher);

        return new ResponseDTO<>(true, 0, "OK", publisherDTO);
    }
}
