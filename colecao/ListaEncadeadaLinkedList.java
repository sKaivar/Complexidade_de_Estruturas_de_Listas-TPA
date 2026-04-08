package colecao;

import java.util.LinkedList;

<<<<<<< Updated upstream
public class ListaEncadeadaLinkedList<T> implements IColecao<T>{
    private LinkedList<T> lst;

    public ListaEncadeadaLinkedList(){
        this.lst = new LinkedList<>();

    }

    @Override
    public void adicionar(T novoValor){
        this.lst.add(novoValor);
    }

    @Override
    public T pesquisar(T valor){
        int i = this.lst.indexOf(valor);
        if (i != -1){
            return this.lst.get(i);
=======
public class ListaEncadeadaLinkedList<T> implements IColecao<T> {
    private LinkedList<T> lista = new LinkedList<>();

    @Override
    public void adicionar(T novoValor) {
        lista.add(novoValor);
    }

    @Override
    public T pesquisar(T valor) {
        int index = lista.indexOf(valor);
        if (index != -1) {
            return lista.get(index);
>>>>>>> Stashed changes
        }
        return null;
    }

    @Override
<<<<<<< Updated upstream
    public boolean remover(T valor){
        return this.lst.remove(valor);

    }

    @Override
    public int quantidadeNos(){
        return this.lst.size();
    }

    @Override
    public String toString(){
        if (this.lst.isEmpty()){
            return "Lista vazia.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.lst.size(); i++){
            sb.append(this.lst.get(i).toString());

            if(i < this.lst.size() - 1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }    

=======
    public boolean remover(T valor) {
        return lista.remove(valor);
    }

    @Override
    public int quantidadeNos() {
        return lista.size();
    }

    @Override
    public String toString() {
        if (lista.isEmpty()) {
            return "Lista vazia.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            sb.append(lista.get(i).toString());
            if (i < lista.size() - 1) {
                sb.append(",\n");
            }
        }
        return sb.toString();
    }
>>>>>>> Stashed changes
}