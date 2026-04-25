import exceptions.ColocacaoInexistenteException;
import implementations.VetorComArray;

public class Main {
    public static void main(String[] args) {
        System.out.println("Olá, mundo");
        VetorComArray vetor = new VetorComArray();

        // 1º passo
        System.out.println("O vetor deve estar vazio. O vetor está vazio? -> %s.".formatted(vetor.estaVazio() ? "Sim ✅, o vetor está vazio" : "Não ❌, o vetor não está vazio"));
        System.out.println("Se o vetor está vazio, o tamanho dele deve ser 0. O tamanho do vetor é 0? -> %s.".formatted(vetor.tamanho() == 0 ? "Sim ✅, o tamanho do vetor é 0" : "Não ❌, o tamanho do vetor é %d".formatted(vetor.tamanho())));

        // 2º passo
        try {
            vetor.elementoNaColocacao(0);
        } catch (ColocacaoInexistenteException e) {
            System.out.println("Não existe nenhum elemento no vetor ✅. Exceção levantada: %s".formatted(e.getMessage()));
        }
        try {
            vetor.inserirElementoNaColocacao(2, "throw ColocacaoInexistenteException");
        } catch (ColocacaoInexistenteException e) {
            System.out.println("Não existe colocação 2 no vetor ✅, pois seu tamanho ainda é 0. Exceção levantada: %s".formatted(e.getMessage()));
        }

        // 3º passo
        vetor.inserirElementoNaColocacao(0, "Joana");
        System.out.println("Primeiro elemento inserido. Deveria ser \"Joana\". O primeiro elemento é \"Joana\"? -> %s.".formatted(vetor.elementoNaColocacao(0).equals("Joana") ? "Sim ✅, o primeiro elemento é \"Joana\"." : "Não ❌, o primeiro elemento é \"%s\"".formatted(vetor.elementoNaColocacao(0))));

        // 4º passo
        vetor.inserirUltimoElemento("Christian");
        System.out.println("Último elemento inserido. Deveria ser \"Christian\". O último elemento é \"Christian\"? -> %s.".formatted(vetor.elementoNaColocacao(1).equals("Christian") ? "Sim ✅, o último elemento é \"Christian\"." : "Não ❌, o último elemento é \"%s\"".formatted(vetor.elementoNaColocacao(1))));
        System.out.println("O primeiro elemento ainda deve ser \"Joana\". O primeiro elemento é \"Joana\"? -> %s.".formatted(vetor.elementoNaColocacao(0).equals("Joana") ? "Sim ✅, o primeiro elemento é \"Joana\"." : "Não ❌, o primeiro elemento é \"%s\"".formatted(vetor.elementoNaColocacao(0))));
        vetor.inserirElementoNaColocacao(1, "Luan");
        System.out.println("Elemento inserido na posição 1. Deveria ser \"Luan\". O elemento na posição 1 é \"Luan\"? -> %s.".formatted(vetor.elementoNaColocacao(1).equals("Luan") ? "Sim ✅, o elemento na posição 1 é \"Luan\"." : "Não ❌, o elemento na posição 1 é \"%s\"".formatted(vetor.elementoNaColocacao(1))));
        System.out.println("O último elemento agora deve ser \"Christian\" na posição 2. O elemento na posição 2 é \"Christian\"? -> %s.".formatted(vetor.elementoNaColocacao(2).equals("Christian") ? "Sim ✅, o elemento na posição 2 é \"Christian\"." : "Não ❌, o elemento na posição 2 é \"%s\"".formatted(vetor.elementoNaColocacao(2))));
        System.out.println("O primeiro elemento ainda deve ser \"Joana\". O primeiro elemento é \"Joana\"? -> %s.".formatted(vetor.elementoNaColocacao(0).equals("Joana") ? "Sim ✅, o primeiro elemento é \"Joana\"." : "Não ❌, o primeiro elemento é \"%s\"".formatted(vetor.elementoNaColocacao(0))));

        // 5º passo
        Object removido = vetor.removerElementoNaColocacao(1);
        System.out.println("Elemento removido. Deveria ser \"Luan\". O elemento removido é \"Luan\"? -> %s.".formatted(removido.equals("Luan") ? "Sim ✅, o elemento removido é \"Luan\"." : "Não ❌, o elemento removido é \"%s\"".formatted(removido)));
        System.out.println("O tamanho do vetor agora deve ser 2. O tamanho do vetor é 2? -> %s.".formatted(vetor.tamanho() == 2 ? "Sim ✅, o tamanho do vetor é 2" : "Não ❌, o tamanho do vetor é %d".formatted(vetor.tamanho())));
        System.out.println("O elemento na posição 1 agora deve ser \"Christian\". O elemento na posição 1 é \"Christian\"? -> %s.".formatted(vetor.elementoNaColocacao(1).equals("Christian") ? "Sim ✅, o elemento na posição 1 é \"Christian\"." : "Não ❌, o elemento na posição 1 é \"%s\"".formatted(vetor.elementoNaColocacao(1))));
        vetor.inserirElementoNaColocacao(2, "Luan");
        System.out.println("Elemento inserido na posição 2. Deveria ser \"Luan\". O elemento na posição 2 é \"Luan\"? -> %s.".formatted(vetor.elementoNaColocacao(2).equals("Luan") ? "Sim ✅, o elemento na posição 2 é \"Luan\"." : "Não ❌, o elemento na posição 2 é \"%s\"".formatted(vetor.elementoNaColocacao(2))));

        // 6º passo
        vetor.substituirElementoNaColocacao(2, "Shawanny");
        System.out.println("Elemento substituído. Deveria ser \"Shawanny\". O elemento na posição 2 é \"Shawanny\"? -> %s.".formatted(vetor.elementoNaColocacao(2).equals("Shawanny") ? "Sim ✅, o elemento na posição 2 é \"Shawanny\"." : "Não ❌, o elemento na posição 2 é \"%s\"".formatted(vetor.elementoNaColocacao(2))));

        // 7º passo
        for(int i = 0; i <= vetor.tamanho() + 1; i++) {
            vetor.removerUltimoElemento();
        }
        System.out.println("O vetor deve estar vazio. O vetor está vazio? -> %s.".formatted(vetor.estaVazio() ? "Sim ✅, o vetor está vazio" : "Não ❌, o vetor não está vazio"));
        System.out.println("Se o vetor está vazio, o tamanho dele deve ser 0. O tamanho do vetor é 0? -> %s.".formatted(vetor.tamanho() == 0 ? "Sim ✅, o tamanho do vetor é 0" : "Não ❌, o tamanho do vetor é %d".formatted(vetor.tamanho())));

        try {
            vetor.removerUltimoElemento();
        } catch (ColocacaoInexistenteException e) {
            System.out.println("Não existe nenhum elemento no vetor ✅. Exceção levantada: %s".formatted(e.getMessage()));
        }
    }
}