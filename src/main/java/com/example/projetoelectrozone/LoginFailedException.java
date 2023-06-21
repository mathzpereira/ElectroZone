package com.example.projetoelectrozone;

public class LoginFailedException extends Exception{

    public LoginFailedException() {
        System.out.println("E-mail ou senha inválidos");
    }
}
