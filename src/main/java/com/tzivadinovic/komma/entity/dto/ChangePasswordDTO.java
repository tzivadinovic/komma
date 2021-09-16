package com.tzivadinovic.komma.entity.dto;

import lombok.Data;

@Data
public class ChangePasswordDTO {
    private String oldPassword;
    private String newPassword;
    private String repeatedPassword;
}
