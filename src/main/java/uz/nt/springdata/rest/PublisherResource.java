package uz.nt.springdata.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.springdata.DTO.PublisherDTO;
import uz.nt.springdata.DTO.ResponseDTO;
import uz.nt.springdata.servise.PublisherServise;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublisherResource {

    private final PublisherServise publisherServise;

    @GetMapping("/get-all-publishers")
    public ResponseDTO<List<PublisherDTO>> getPublishers(){
        return publisherServise.getPublishers();
    }

    @PostMapping("/addPublisher")
    public ResponseDTO<PublisherDTO> addPublisher(@RequestBody PublisherDTO publisherDTO){
        return publisherServise.addPublisher(publisherDTO);
    }

    @PutMapping("/updatePublisher")
    public ResponseDTO<PublisherDTO> updatePublisher(@RequestBody PublisherDTO publisherDTO){
        return publisherServise.updatePublisher(publisherDTO);
    }

    @DeleteMapping("/deletePublisher")
    public ResponseDTO<PublisherDTO> deletePublisher(@RequestBody PublisherDTO publisherDTO){
        return publisherServise.deletePublisher(publisherDTO);
    }
}
