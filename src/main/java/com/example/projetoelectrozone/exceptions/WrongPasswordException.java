package com.example.projetoelectrozone.exceptions;

public class WrongPasswordException extends Exception{ // Exceção para quando a senha digitada está incorreta
    public WrongPasswordException() {
        System.out.println("Senha Incorreta. A ação não pôde ser confirmada.");
    }
}
