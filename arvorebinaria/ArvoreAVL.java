package arvorebinaria;

import lstencadeada.No;
import java.util.Comparator;

public class ArvoreAVL<T> extends ArvoreBinaria<T>{

	public ArvoreAVL(Comparator<T> comparador){
		super(comparador);

	}
	
	@Override
	public void adicionar(T novoValor){
		this.raiz = adicionarAVL(this.raiz, novoValor);
	}

	private No<T> adicionarAVL(No<T> atual, T valor){
		if(atual == null){
			this.tamNo++;
			return new No<T>(valor);
		}
		int comp = this.comparador.compare(valor, atual.getValor());	
		
		if(comp < 0){
			atual.setEsquerda(adicionarAVL(atual.getEsquerda(), valor));

		} else if(comp > 0){
			atual.setDireita(adicionarAVL(atual.getDireita(), valor));
		
		}else{
			return atual;
			
		}

		return balancear(atual);


	}

	private int balanceamento(No<T> no){
		if(no == null) return 0;
		int alturaEsq = calcularAltura(no.getEsquerda());
		int alturaDir = calcularAltura(no.getDireita());
		
		return alturaEsq - alturaDir;


	}

	private No<T> balancear(No<T> no){

		int fator = balanceamento(no);

		if(fator > 1){
			// se o filho da esquerda tem peso para a direita
			if(balanceamento(no.getEsquerda()) < 0){
				no.setEsquerda(rotEsq(no.getEsquerda()));
				}
			return rotDir(no);
		}

		if(fator <-1){
			// se o filho da direita tem peso para a esquerda
			if(balanceamento(no.getDireita()) > 0){
				no.setDireita(rotDir(no.getDireita()));
			}
			return rotEsq(no);
		}
	
		return no;

	}



	private No<T> rotDir(No<T> a){
		No<T> b = a.getEsquerda();
		No<T> aux = b.getDireita();

		b.setDireita(a);
		a.setEsquerda(aux);

		return b;

	}

	private No<T> rotEsq(No<T> a){
		No<T> b = a.getDireita();
		No<T> aux = b.getEsquerda();

		b.setEsquerda(a);
		a.setDireita(aux);

		return b;		

		
	}




}

