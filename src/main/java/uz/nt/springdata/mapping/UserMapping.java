package uz.nt.springdata.mapping;

import uz.nt.springdata.DAO.User;
import uz.nt.springdata.DTO.UserDTO;

public class UserMapping {
    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.getId(),
                userDTO.getFirst_name(),
                userDTO.getLast_name(),
                userDTO.getAccount(),
                userDTO.getPhone_number(),
                userDTO.getUsername(),
                userDTO.getPassword());
    }

    public static UserDTO toDto(User user){
        return new UserDTO(user.getId(),
                user.getFirst_name(),
                user.getLast_name(),
                user.getPhone_number(),
                user.getUsername(),
                user.getPassword());
    }

    public static void setEntity(User user, UserDTO userDTO){
        user.setId(userDTO.getId());
        user.setFirst_name(userDTO.getFirst_name());
        user.setLast_name(userDTO.getLast_name());
        user.setAccount(userDTO.getAccount());
        user.setPhone_number(userDTO.getPhone_number());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
    }
}
