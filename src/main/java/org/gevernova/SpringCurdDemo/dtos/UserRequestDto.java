package org.gevernova.SpringCurdDemo.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequestDto {

    @NotNull(message = "name should not be null")
    private String name;
    @NotBlank(message = "should not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,}$")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
