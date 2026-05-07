package arvorebinaria;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import colecao.IColecao;
import lstencadeada.No;

public class ArvoreBinaria<T> extends ArvoreBinariaBase<T>  {
    protected No<T> raiz;
    
    public ArvoreBinaria(Comparator<T> comparador){
        super(comparador);
        this.raiz = null;
    }

    @Override
    public int altura(){        
        return calcularAltura(this.raiz);
    
    }     
    private int calcularAltura(No<T> no){
        if (no == null){
            return -1;
        }

        int alturaAnt = calcularAltura(no.getEsquerda());
        int alturaProx = calcularAltura(no.getDireita());

        return Math.max(alturaAnt, alturaProx) + 1;
    }

    @Override
    public String caminharEmNivel(){
        if(this.raiz == null){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        Queue<No<T>> fila = new LinkedList<>();
        fila.add(this.raiz);

        while (!fila.isEmpty()){
            int tam = fila.size();

            for(int i = 0; i < tam ; i++){
                No<T> atual = fila.poll();
            }
        }
    }
    @Override
    public String caminharEmOrdem(){

    }

    @Override
    public void adicionar(T novoValor){
        this.raiz = adicionarRecursivo(No<T> atual, T valor);
        
    }
    private No<T> adicionarRecursivo(No<T> atual, T valor){
        if(atual == null){
            return new No<T>(valor);
        }
        int comp = this.comparador.compare(valor, atual.getValor());
        if(comp < 0){
            atual.setAnterior(adicionarRecursivo(atual.getAnterior(), valor));
        } else if(comp > 0){
            atual.setProximo(adicionarRecursivo(atual.getProximo(), valor));
        }
        return atual;
    }

    @Override
    public T pesquisar(T valor){
        return pesquisarRecursivo(this.raiz, valor);
    }

    private T pesquisarRecursivo(No<T> atual, T valor){
        if(atual == null){
            return null;
        }

        int comp = this.comparador.compare(valor, atual.getValor());

        if (comp == 0){
            return atual.getValor();
        }else if(comp < 0){
            return pesquisarRecursivo(atual.getEsquerda(), valor);
        }else{
            return pesquisarRecursivo(atual.getDireita(), valor);
        }
    }
    
    @Override
    public boolean remover(T valor){
        if (pesquisar(valor) == null){
            return false;
        }

        this.raiz = removerRecursivo(this.raiz, valor);
        return true;
    }

    private No<T> removerRecursivo(No<T> atual, T valor){
        if (atual == null){
            return null;
        }
        int comp = this.comparador.compare(valor, atual.getValor());

        if (comp < 0){
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), valor));
        }else if (comp > 0){
            atual.setDireita(removerRecursivo(atual.getDireita(), valor))
        }else{
            if (atual.getEsquerda == null){
                return atual.getDireita();
            }else if (atual.getDireita == null){
                return atual.getEsquerda();
            }
        }
    }

    @Override
    public int quantidadeNos(){

    }
}    
