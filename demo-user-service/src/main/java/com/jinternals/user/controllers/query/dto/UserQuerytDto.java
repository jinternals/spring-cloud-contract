package com.jinternals.user.controllers.query.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.jinternals.user.commons.Gender;
import com.jinternals.user.domain.User;
import com.jinternals.user.domain.View;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

import static java.lang.String.format;

public class UserQuerytDto {

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

    @NotNull
    @JsonView(View.V2.class)
    private String fullName;


    public UserQuerytDto() {
    }

    public UserQuerytDto(String email, String firstName, String lastName, Gender gender) {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserQuerytDto)) return false;

        UserQuerytDto user = (UserQuerytDto) o;

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

    public static UserQuerytDto toDto(User user) {
        UserQuerytDto userQuerytDto = new UserQuerytDto();

        userQuerytDto.setId(user.getId());
        userQuerytDto.setEmail(user.getEmail());
        userQuerytDto.setFirstName(user.getFirstName());
        userQuerytDto.setLastName(user.getLastName());
        userQuerytDto.setGender(user.getGender());
        userQuerytDto.setFullName(format("%s %s", user.getFirstName(), user.getLastName()));
        return userQuerytDto;
    }

}
