package com.jinternals.user.controllers.command.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.jinternals.user.commons.Gender;
import com.jinternals.user.domain.User;
import com.jinternals.user.domain.View;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static java.lang.String.format;

public class UserCommandDto implements Serializable {

    @Id
    @JsonView(View.V1.class)
    private String id;

    @Email
    @JsonView(View.V1.class)
    private String email;

    @NotNull
    @JsonView(View.V1.class)
    private String firstName;

    @NotNull
    @JsonView(View.V1.class)
    private String lastName;

    @NotNull
    @JsonView(View.V1.class)
    private Gender gender;

    public UserCommandDto() {
    }

    public UserCommandDto(String email, String firstName, String lastName, Gender gender) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCommandDto)) return false;

        UserCommandDto user = (UserCommandDto) o;

        return getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return getEmail().hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }

    public static UserCommandDto toDto(User user){
        UserCommandDto userCommandDto = new UserCommandDto();

        userCommandDto.setId(user.getId());
        userCommandDto.setEmail(user.getEmail());
        userCommandDto.setFirstName(user.getFirstName());
        userCommandDto.setLastName(user.getLastName());
        userCommandDto.setGender(user.getGender());
        return userCommandDto;
    }

    public static User fromDto(UserCommandDto userCommandDto){
        User user = new User();
        user.setId(userCommandDto.getId());
        user.setEmail(userCommandDto.getEmail());
        user.setFirstName(userCommandDto.getFirstName());
        user.setLastName(userCommandDto.getLastName());
        user.setGender(userCommandDto.getGender());
        return user;
    }
}
