package com.example.projetoelectrozone;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        System.out.println("Senha Incorreta. A ação não pôde ser confirmada.");
    }
}
