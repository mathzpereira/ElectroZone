package com.example.projetoelectrozone;

public class MenuHelper {
    private boolean flag;
    private boolean sucesso;

    public MenuHelper(boolean flag, boolean sucesso) {
        this.flag = flag;
        this.sucesso = sucesso;
    }

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
