package com.instagram.api.domain.member.dto;

import com.instagram.api.domain.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Length(min = 4, max = 12)
    @Pattern(regexp = "^[0-9a-zA-Z]+$")
    private String username;

    @NotBlank
    @Length(min = 2, max = 12)
    private String name;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    @Length(min = 4, max = 20)
    private String password;

    @NotBlank
    @Email
    String email;

    public Member convert() {
        return Member.builder()
                .username(getUsername())
                .name(getName())
                .password(getPassword())
                .email(getEmail())
                .build();
    }
}
