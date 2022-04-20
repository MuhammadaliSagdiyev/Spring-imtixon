package uz.nt.springdata.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private Integer account;
    private String phone_number;
    private String username;
    private String password;

    public UserDTO(Integer id, String first_name, String last_name, String phone_number, String username, String password){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.username  = username;
        this.password = password;
    }
}
