package colecao;

import java.util.LinkedList;

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
        }
        return null;
    }

    @Override
    public boolean remover(T valor){
        return this.lst.remove(valor);

    }

    @Override
    public int quantidadeNos(){
        return this.lst.size();
    }

    

}