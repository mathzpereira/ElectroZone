package com.example.projetoelectrozone;

public class RegisterFailedException extends Exception{

    public RegisterFailedException() {
        System.out.println("O Registro de usuário falhou. Tente novamente.");
    }
}
