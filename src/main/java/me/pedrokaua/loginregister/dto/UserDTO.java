package me.pedrokaua.loginregister.dto;

import me.pedrokaua.loginregister.entitites.User;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserDTO {
    private String name;
    private String userName;
    private String gender;
    private String birth;
    private String email;

    public UserDTO(){}

    public UserDTO(User entity){
        this.name = entity.getName();
        this.userName = entity.getUserName();
        this.gender = entity.getGender();
        this.setBirth(entity.getBirth());
        this.email = entity.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getGender() {
        return gender;
    }

    public String getBirth() {
        return birth;
    }

    private void setBirth(LocalDate birth) {
        if (birth != null) {
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            this.birth = f.format(birth);
        }
    }

    public String getEmail() {
        return email;
    }

}
