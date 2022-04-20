package uz.nt.springdata.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.springdata.DTO.ResponseDTO;
import uz.nt.springdata.DTO.UserDTO;
import uz.nt.springdata.servise.UsersServise;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserResource {

    private  final UsersServise usersServise;

    @PostMapping("/addUser")
    public ResponseDTO<UserDTO> insert(@RequestBody UserDTO userDTO){
        return usersServise.add(userDTO);
    }

    @GetMapping("/get-all-users")
    public ResponseDTO<List<UserDTO>> getUsers(){
        return usersServise.getUsers();
    }

    @PutMapping("/updateUser")
    public  ResponseDTO<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return usersServise.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public ResponseDTO<UserDTO> deleteUser(@RequestBody UserDTO userDTO){
        return usersServise.deleteUser(userDTO);
    }
}
