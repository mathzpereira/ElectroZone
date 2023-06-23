package com.example.projetoelectrozone.exceptions;

public class RegisterFailedException extends Exception{ // Exceção para quando o registro não funciona

    public RegisterFailedException() {
        System.out.println("O Registro de usuário falhou. Tente novamente.");
    }
}
