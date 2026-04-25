package exceptions;

public class ColocacaoInexistenteException extends RuntimeException {
    public ColocacaoInexistenteException(String mensagem) {
        super(mensagem);
    }

    public ColocacaoInexistenteException() {
        super("A colocação informada não existe no vetor.");
    }
}
