package com.example.projetoelectrozone;

public class SaldoInsuficienteException extends Exception{

    public SaldoInsuficienteException() {
        System.out.println("A compra não foi concluída. Seu saldo é insuficiente.");
    }
}
