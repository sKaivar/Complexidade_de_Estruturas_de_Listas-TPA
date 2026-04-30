package lstencadeada;

public class No<T> {
    public T valor;
    public No<T> anterior;
    public No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }


    public T getValor() {
        return valor;
    }
    public No<T> getAnterior() {
        return anterior;
    }
    public No<T> getProximo() {
        return proximo;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
}


