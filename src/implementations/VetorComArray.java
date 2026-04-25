package implementations;

import exceptions.ColocacaoInexistenteException;
import interfaces.VetorInterface;

public class VetorComArray implements VetorInterface {
    private Object[] array;
    private int tamanho;

    public VetorComArray() {
        this.array = new Object[1];
        this.tamanho = 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    private boolean estaCheio() {
        return tamanho == array.length;
    }

    public Object elementoNaColocacao(int colocacao) {
        if(colocacao < 0) {
            throw new ColocacaoInexistenteException("Não existe colocação negativa nessa implementação de vetor.");
        }

        if(colocacao >= this.tamanho) {
            throw new ColocacaoInexistenteException("A colocação informada não existe no vetor, pois é maior que o tamanho do vetor (%d).".formatted(tamanho()));
        }

        return array[colocacao];
    }

    public Object substituirElementoNaColocacao(int colocacao, Object novoElemento) {
        if(colocacao < 0) {
            throw new ColocacaoInexistenteException("Já falei que não existe colocação negativa nessa implementação de vetor.");
        }

        if(colocacao >= this.tamanho) {
            throw new ColocacaoInexistenteException("O tamanho do vetor é %d. Como tú quer que exista colocação %d?".formatted(tamanho(), colocacao));
        }

        Object elementoQueEstavaNaColocacao = array[colocacao];
        array[colocacao] = novoElemento;
        return elementoQueEstavaNaColocacao;
    }
}
