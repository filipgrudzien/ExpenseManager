package com.expensetracker.DTO;

import com.expensetracker.constraints.PasswordMatching;
import com.expensetracker.constraints.ValidEmail;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@PasswordMatching
public class UserDTO {

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @ValidEmail
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    private String matchingPassword;
}
