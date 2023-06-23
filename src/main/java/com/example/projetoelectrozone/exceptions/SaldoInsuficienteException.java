package com.example.projetoelectrozone.exceptions;

public class SaldoInsuficienteException extends Exception{ // Exceção para quando não há saldo para concluir uma compra

    public SaldoInsuficienteException() {
        System.out.println("A compra não foi concluída. Seu saldo é insuficiente.");
    }
}
