package uz.nt.springdata.servise;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import uz.nt.springdata.DAO.User;
import uz.nt.springdata.DTO.ResponseDTO;
import uz.nt.springdata.DTO.UserDTO;
import uz.nt.springdata.mapping.UserMapping;
import uz.nt.springdata.reposytory.UsersReposytory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UsersServise {

    private final UsersReposytory usersReposytory;

    public ResponseDTO<UserDTO> add(@RequestBody UserDTO userDTO){
        if(userDTO.getUsername() == null || userDTO.getPassword() == null){
            return new ResponseDTO<>(false, -7, "username va password kiritish shart!", userDTO);
        }

        if(userDTO.getPhone_number()==null){
            return new ResponseDTO<>(false, -9, "telefon raqamizgizni kiriting!", userDTO);
        }

        boolean b = Pattern.matches("[+998 [0-9][0-9] [0-9][0-9][0-9] [0-9][0-9] [0-9][0-9]]", userDTO.getPhone_number());

        if (b != false || userDTO.getPhone_number().length()>17){
            return new ResponseDTO<>(false, -10, "Telefon raqamingizni noto'g'ri formatta kirg'izdiz. To'g'ri format : '+998-XX-XXX-XX-XX'", userDTO);
        }

        if(usersReposytory.getUsernameByUsername(userDTO.getUsername()) == null){
            User user = UserMapping.toEntity(userDTO);
            usersReposytory.save(user);
            return new ResponseDTO<>(true, 0, "OK", userDTO);
        }
        return new ResponseDTO<>(false, -20, "Bu username mavjud!", null);
    }




    public ResponseDTO<List<UserDTO>> getUsers(){
        List<User> users = usersReposytory.findAll();
        if(!users.isEmpty()){
            List<UserDTO> list = new ArrayList<>();
            for(int i = 0; i < users.size(); i++){
                list.add(UserMapping.toDto(users.get(i)));
            }
            return new ResponseDTO<>(true, 0, "OK", list);
        }
        return new ResponseDTO<>(false, -1, "ERROR", null);
    }


    public ResponseDTO<UserDTO> updateUser(UserDTO userDTO){
        try {
            if(userDTO.getId()==null){
                return new ResponseDTO<>(false, -2, "ID null bo'lishi mumkin emas!", userDTO);
            }

            Optional<User> user = usersReposytory.findById(userDTO.getId());
            if(!user.isPresent()){
                return new ResponseDTO<>(false, -3, "Bu ID li user topilmadi!", userDTO);
            }

            User user1 = user.get();
            UserMapping.setEntity(user1, userDTO);

            usersReposytory.save(user1);
            return  new ResponseDTO<>(true, 0, "OK", userDTO);
        } catch (Exception e) {
            return new ResponseDTO<>(false, -5, "ERROR", null);
        }
    }


    public ResponseDTO<UserDTO> deleteUser(UserDTO userDTO){
        try {
            if(userDTO.getId()==null){
                return new ResponseDTO<>(false, -2, "ID null bo'lishi mumkin emas!", userDTO);
            }

            if(usersReposytory.getBookById(userDTO.getId()) == null){
                return new ResponseDTO<>(false, -3, "Bu ID li user topilmadi!", userDTO);
            }

            User user = UserMapping.toEntity(userDTO);
            usersReposytory.delete(user);

            return new ResponseDTO<>(true, 0, "OK", userDTO);
        }
        catch (Exception e) {
            return new ResponseDTO<>(false, -50, "ERROR", null);
        }
    }
}
