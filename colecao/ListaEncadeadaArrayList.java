package colecao;

import java.util.ArrayList;

public class ListaEncadeadaArrayList<T> implements IColecao<T>{
    private ArrayList<T> lst;

    public ListaEncadeadaArrayList(){
        this.lst = new ArrayList<>();
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
   
}