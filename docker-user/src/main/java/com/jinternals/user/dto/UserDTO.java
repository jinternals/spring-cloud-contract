package com.jinternals.user.dto;

import com.jinternals.user.commons.Gender;
import com.jinternals.user.domain.User;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


public class UserDTO {


    @Email
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public static User fromDTO(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setGender(userDTO.getGender());
        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO UserDTO = new UserDTO();
        UserDTO.setEmail(user.getEmail());
        UserDTO.setFirstName(user.getFirstName());
        UserDTO.setLastName(user.getLastName());
        UserDTO.setGender(user.getGender());
        return UserDTO;
    }


    public static List<UserDTO> toDTO(List<User> users) {
        List<UserDTO> userDTOs = new ArrayList<>();

        users.forEach(user -> userDTOs.add(toDTO(user)));

        return userDTOs;
    }
}
