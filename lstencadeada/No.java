package lstencadeada;

public class No<T> {
    public T valor;
    public No<T> esquerda;
    public No<T> direita;

    public No(T valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }


    public T getValor() {
        return valor;
    }
    public No<T> getEsquerda() {
        return esquerda;
    }
    public No<T> getDireita() {
        return direita;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }
    public void setDireita(No<T> direita) {
        this.direita = direita;
    }
}


