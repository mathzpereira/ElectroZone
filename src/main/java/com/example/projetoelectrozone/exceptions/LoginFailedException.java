package com.example.projetoelectrozone.exceptions;

public class LoginFailedException extends Exception{ // Exceção para quando o login não funciona

    public LoginFailedException() {
        System.out.println("E-mail ou senha inválidos");
    }
}
