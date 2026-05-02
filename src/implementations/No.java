package implementations;

import interfaces.NoInterface;

public class No implements NoInterface {
    private No noAEsquerda;
    private Object dado;
    private No noADireita;

    public No(Object dado) {
        noAEsquerda = null;
        this.dado = dado;
        noADireita = null;
    }

    public No getNoAEsquerda() {
        return noAEsquerda;
    }

    public void setNoAEsquerda(No novoNo) {
        noAEsquerda = novoNo;
    }

    public Object getDado() {
        return dado;
    }

    public void setDado(Object novoDado) {
        dado = novoDado;
    }

    public No getNoADireita() {
        return noADireita;
    }

    public void setNoADireita(No novoNo) {
        noADireita = novoNo;
    }

    public boolean temNoAEsquerda() {
        return noAEsquerda != null;
    }

    public boolean temNoADireita() {
        return noADireita != null;
    }

    public No getNooADireita() {
        return noADireita;
    }
}
