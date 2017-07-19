package com.jinternals.user.dto;

import com.cloud.example.user.domain.User;
import com.mradul.cloud.commons.validators.CheckGender;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import static com.mradul.cloud.commons.enums.Gender.valueOf;

public class UserDTO {

	@NotNull
    @Email
	private String email;

	@NotNull
	@Length(min = 3, max = 20)
	private String firstName;

	@NotNull
	@Length(min = 3, max = 20)
	private String lastName;

    @NotNull
    @NotEmpty
	@CheckGender
	private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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


   public static User fromDTO(UserDTO userDTO){
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setGender(valueOf(userDTO.getGender().toUpperCase()));
        return user;
    }
}
