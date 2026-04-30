package arvorebinaria;

import java.util.Comparator;

public class ArvoreAVL extends ArvoreBinariaBase {
    protected No<T> raiz;
    
    public ArvoreAVL(Comparator<T> comparador){
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

        int alturaAnt = calcularAltura(no.getAnterior());
        int alturaProx = calcularAltura(no.getProximo());

        return Math.max(alturaAnt, alturaProx) + 1;
    }

    @Override
    public String caminharEmNivel(){
        if(this.raiz == null){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
    }
}    
