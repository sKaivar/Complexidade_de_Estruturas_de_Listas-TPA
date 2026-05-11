package arvorebinaria;

import java.util.Comparator;
import lstencadeada.No;

public class ArvoreBinaria<T> extends ArvoreBinariaBase<T>  {
    protected No<T> raiz;
    private int tamNo;
    
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

        int alturaEsq = calcularAltura(no.getEsquerda());
        int alturaDir = calcularAltura(no.getDireita());

        return Math.max(alturaEsq, alturaDir) + 1;
    }

    @Override
    public String caminharEmNivel(){
        if(this.raiz == null){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        int h = altura();
        for(int i = 0; i <= h; i++){
            StringBuilder linha = new StringBuilder();
            gerarLinha(this.raiz, i, linha);

            if(linha.length() > 2){
                linha.setLength(linha.length() - 2);
            }
            sb.append(linha.toString()).append("\n");
            
        }
        sb.append("]");
        return sb.toString();
    }

    private void gerarLinha(No<T> no, int nivel, StringBuilder sb){
        if(no == null) return;
        if(nivel == 0){
            sb.append(no.getValor().toString()).append(", ");
        }else{
            gerarLinha(no.getEsquerda(), nivel - 1, sb);
            gerarLinha(no.getDireita(), nivel - 1, sb);
        }
    }
    @Override
    public String caminharEmOrdem(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        caminharEmOrdemRecursivo(this.raiz, sb);
        if (sb.length() > 1){
            sb.setLength(sb.length() -2);
        }

        sb.append("]");
        return sb.toString();

    }

    private void caminharEmOrdemRecursivo(No<T> no, StringBuilder sb){
        if (no == null) return;
        caminharEmOrdemRecursivo(no.getEsquerda(), sb);
        sb.append(no.getValor().toString()).append(", ");
        caminharEmOrdemRecursivo(no.getDireita(), sb);
        
    }
    // metodos de IColecao
    @Override
    public void adicionar(T novoValor){
        this.raiz = adicionarRecursivo(this.raiz, novoValor);
        
    }
    private No<T> adicionarRecursivo(No<T> atual, T valor){
        if(atual == null){
            this.tamNo++;
            return new No<T>(valor);
        }
        int comp = this.comparador.compare(valor, atual.getValor());
        if(comp < 0){
            atual.setEsquerda(adicionarRecursivo(atual.getEsquerda(), valor));
        } else if(comp > 0){
            atual.setDireita(adicionarRecursivo(atual.getDireita(), valor));
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
        }
        if(comp < 0){
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
        this.tamNo--;
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
            atual.setDireita(removerRecursivo(atual.getDireita(), valor));
        }else{
            if(atual.getEsquerda() == null) return atual.getDireita();
            if(atual.getDireita() == null) return atual.getEsquerda();

            No<T> sucessor = atual.getDireita();
            while(sucessor.getEsquerda() != null){
                sucessor = sucessor.getEsquerda();
            }

            T menor = sucessor.getValor();
            atual.setValor(menor);
            atual.setDireita(removerRecursivo(atual.getDireita(), menor));
        }
        return atual;
    }

    @Override
    public int quantidadeNos(){
        return this.tamNo;
    }
}    
