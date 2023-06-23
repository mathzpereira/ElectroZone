package com.example.projetoelectrozone.menu;

public class MenuHelper { // Classe helper para controle do logout e encerramento do programa
    private boolean flag;
    private boolean sucesso;

    // Construtor
    public MenuHelper(boolean flag, boolean sucesso) {
        this.flag = flag;
        this.sucesso = sucesso;
    }

    // Getters e setters
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }
}
