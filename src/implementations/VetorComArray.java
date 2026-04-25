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

    public Object elementoNaColocacao(int colocacao) {
        if(colocacao < 0) {
            throw new ColocacaoInexistenteException("Não existe colocação negativa nessa implementação de vetor.");
        }

        if(colocacao >= this.tamanho) {
            throw new ColocacaoInexistenteException("A colocação informada não existe no vetor, pois é maior que o tamanho do vetor (%d).".formatted(tamanho()));
        }

        return array[colocacao];
    }
}
