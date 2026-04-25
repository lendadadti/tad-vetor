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

    private void incrementarTamanho() {
        tamanho++;
    }

    private void decrementarTamanho() {
        tamanho--;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    private boolean oArrayEstaCheio() {
        return tamanho == array.length;
    }

    private boolean haPeloUmElementoNoVetor() {
        return tamanho > 0;
    }

    private boolean oArrayVaiEncherSeColocarMaisUmElemento() {
        return tamanho + 1 == array.length;
    }

    private void duplicarEspacoDoArray() {
        int novaCapacidade = tamanho * 2;
        Object[] novoArray = new Object[novaCapacidade];
        for(int i = 0; i < tamanho; i++) {
            novoArray[i] = array[i];
        }
        array = novoArray;
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

    public void inserirElementoNaColocacao(int colocacao, Object novoElemento) {
        if(colocacao < 0) {
            throw new ColocacaoInexistenteException("Mais uma vez: não existe colocação negativa nessa implementação de vetor.");
        }

        if(colocacao > tamanho) {
            throw new ColocacaoInexistenteException("Já tomasse café hoje? É impossível que um vetor que tem %d elementos ter uma colocação %d. Sabe por quê? Porque as colocações vão de 0 até N, onde N é o número total de elementos armazenados no vetor.".formatted(tamanho(), colocacao));
        }

        int tamanhoAntigo = tamanho;
        if(oArrayEstaCheio() || oArrayVaiEncherSeColocarMaisUmElemento()) {
            duplicarEspacoDoArray();
        }

        for(int i = tamanhoAntigo - 1; i >= colocacao; i--) {
            array[i + 1] = array[i];
        }

        array[colocacao] = novoElemento;

        incrementarTamanho();
    }

    public void inserirPrimeiroElemento(Object novoElemento) {
        inserirElementoNaColocacao(0, novoElemento);
    }

    public void inserirUltimoElemento(Object novoElemento) {
        inserirElementoNaColocacao(tamanho, novoElemento);
    }

    public Object removerElementoNaColocacao(int colocacao) {
        if(colocacao < 0) {
            throw new ColocacaoInexistenteException("Não existe colocação negativa nessa implementação de vetor.");
        }

        if(colocacao >= tamanho) {
            throw new ColocacaoInexistenteException("A colocação informada não existe no vetor, pois é maior que o tamanho do vetor");
        }

        Object elementoQueEstavaNaColocacao = array[colocacao];
        for (int i = colocacao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }

        array[tamanho - 1] = null;
        decrementarTamanho();

        return elementoQueEstavaNaColocacao;
    }

    public Object removerPrimeiroElemento() {
        return removerElementoNaColocacao(0);
    }

    public Object removerUltimoElemento() {
        return removerElementoNaColocacao(tamanho - 1);
    }
}
