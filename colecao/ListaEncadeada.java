package colecao;

public class ListaEncadeada<T> implements IColecao<T> {
    private No<T> head;
    private int quantidade;

    public ListaEncadeada() {
        this.head = null;
        this.quantidade = 0;
    }

    public void adicionar(T novoValor) {
        if (head == null) {
            this.head = new No<>(novoValor);
            this.quantidade = 1;
        }
        else {
            No<T> noTemp = head;
            while (noTemp.proximo != null) {
                noTemp = noTemp.proximo;
            }
            noTemp.proximo = new No<T>(novoValor);
            this.quantidade += 1;
        }
    }

    public T pesquisar(T valor) {
        No<T> noTemp = head;
        while (noTemp != null) {
            if (noTemp.valor.equals(valor))
                return noTemp.valor;
            noTemp = noTemp.proximo;
        }
        return null;
    }

    public boolean remover(T valor) {
        if (this.head == null) return false;
        
        if (this.head.valor.equals(valor)) {
            this.head = this.head.proximo;
            this.quantidade--;
            return true;
        }

        No<T> noTemp = this.head;
        
        for (int i = 0; i < this.quantidade; i++) {
            if (noTemp.proximo.valor.equals(valor)) {
                noTemp.proximo = noTemp.proximo.proximo;
                return true;
                }
            }
        
        return false;
    }

    public int quantidadeNos() {
        return this.quantidade;
    }

    @Override
    public String toString(){
        if (head == null){
            return "Lista vazia.";
        }

        StringBuilder sb = new StringBuilder();
        No<T> noTemp = head;

        while (noTemp != null){
            sb.append(noTemp.valor.toString());

            if (noTemp.proximo != null){
                sb.append(",\n");
            }
            noTemp = noTemp.proximo;
        }   

        return sb.toString();

    }
}
