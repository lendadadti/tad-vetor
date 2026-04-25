package interfaces;

public interface VetorInterface {
    /**
    * A interface a seguir deve funcionar tanto para implementações que usam arrays
     * quanto para as que usam listas.
     *
     * Foi traduzida para o Português apenas por capricho didático.
     */
    public Object elementoNaColocacao(int colocacao);
    public Object substituirElementoNaColocacao(int colocacao, Object novoElemento);
    //public void inserirElementoNaColocacao(int colocacao, Object novoElemento);
    //public Object removerElementoNaColocacao(int colocacao);
    public int tamanho();
    public boolean estaVazio();
}
