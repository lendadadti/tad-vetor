package implementations;

import exceptions.ColocacaoInexistenteException;
import interfaces.VetorInterface;

public class VetorComListaDuplamenteEncadeada {
    private No primeiroNo;
    private No ultimoNo;
    private int tamanho;

    public VetorComListaDuplamenteEncadeada() {
        primeiroNo = null;
        ultimoNo = null;
        tamanho = 0;
    }

    private boolean aColocacaoEstaPrimeiraMetadeDoVetor(int colocacao) {
        // A otimização formidável do professor, que tenta transformar a agrevissividade do O(N) para O(log(N))
        return colocacao <= tamanho / 2;
    }

    private void incrementarTamanho() {
        tamanho++;
    }

     public int tamanho() {
        return tamanho;
     }

    private void decrementarTamanho() {
        tamanho--;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    private boolean haPeloMenosUmElementoNoVetor() {
        return tamanho > 0;
    }

    private boolean aColocacaoEhAUltimaDoVetor(int colocacao) {
        return tamanho - 1 == colocacao;
    }

    private void verificarCasosExtremosRecuperacao(int colocacao) {
        if(estaVazio()) {
            throw new ColocacaoInexistenteException("Vetor vazio.");
        }
        if(colocacao < 0) {
            throw new ColocacaoInexistenteException("Não existe colocação negativa nessa implementação de vetor.");
        }
        if(colocacao >= tamanho) {
            throw new ColocacaoInexistenteException("A colocação informada é maior que o tamanho do vetor.");
        }
    }

    public Object elementoNaColocacao(int colocacao) {
        verificarCasosExtremosRecuperacao(colocacao);

        if(colocacao == 0) {
            return primeiroNo.getDado();
        }
        if(aColocacaoEhAUltimaDoVetor(colocacao)) {
            return ultimoNo.getDado();
        }

        return buscarNoNaColocacao(colocacao).getDado();
    }

    public Object substituirElementoNaColocacao(int colocacao, Object novoElemento) {
        verificarCasosExtremosRecuperacao(colocacao);

        Object elementoQueEstavaNaColocacao = null;
        if(colocacao == 0) {
            elementoQueEstavaNaColocacao = primeiroNo.getDado();
            primeiroNo.setDado(novoElemento);
            return elementoQueEstavaNaColocacao;
        }
        if(aColocacaoEhAUltimaDoVetor(colocacao)) {
            elementoQueEstavaNaColocacao = ultimoNo.getDado();
            ultimoNo.setDado(novoElemento);
            return elementoQueEstavaNaColocacao;
        }

        No noAchado = buscarNoNaColocacao(colocacao);
        elementoQueEstavaNaColocacao = noAchado.getDado();
        noAchado.setDado(novoElemento);

        return elementoQueEstavaNaColocacao;
    }

    public void inserirElementoNaColocacao(int colocacao, Object novoElemento) {
        verificarCasosExtremosRecuperacao(colocacao);

        if(colocacao == 0) {

        }
    }

    private No buscarNoNaColocacao(int colocacao) {
        No noAchado = null;
        if(aColocacaoEstaPrimeiraMetadeDoVetor(colocacao)) {
            noAchado = primeiroNo;
            for(int i = 0; i < colocacao; i++) {
                noAchado = noAchado.getNoADireita();
            }
        } else {
            noAchado = ultimoNo;
            for(int i = tamanho - 1; i > colocacao; i--) {
                noAchado = noAchado.getNoAEsquerda();
            }
        }
        return noAchado;
    }
}