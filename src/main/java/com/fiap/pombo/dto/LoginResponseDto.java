package com.fiap.pombo.dto;

public class LoginResponseDto {
    private String message;

    public LoginResponseDto(String message) {
        this.message = message;
    }

    // Getter e Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
