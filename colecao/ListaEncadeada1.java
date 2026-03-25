// package colecao;

// public class ListaEncadeada<T> implements IColecao<T>{
//     private No<T> inicio;
//     private int tamanho;

//     public ListaEncadeada() {
//         this.inicio = null;
//         this.tamanho = 0;
//     }

//     public void adicionar(T novoValor) {
//         No<T> novoNo = new No<>(novoValor);
//         if (inicio == null) {
//             inicio = novoNo;
//         } else {
//             No<T> atual = inicio;
//             while (atual.proximo != null) {
//                 atual = atual.proximo;
//             }
//             atual.proximo = novoNo;
//         }
//         tamanho++;
//     }

//     public T pesquisar(T valor){
//         No<T> atual = inicio;
//         while (atual != null){
//             if (atual.valor.equals(valor)){
//                 return atual.valor;            
//             }
//             atual = atual.proximo;
//         }
//         return null;
//     }   


//     public boolean remover(T valor){
//         if (inicio == null) return false;


//         //Caso seja o primeiro a ser removido
//         if (inicio.valor.equals(valor)){
//             inicio = inicio.proximo;
//             tamanho--;
//             return true;
//         }

//         No<T> atual = inicio;
//         while (atual.proximo != null && !atual.proximo.valor.equals(valor)){
//             atual = atual.proximo;
//         }

//         //Caso seja no meio ou final da lista
//         if (atual.proximo != null){
//             atual.proximo = atual.proximo.proximo;
//             tamanho--;
//             return true;
//         }

//         return false;
//     }

//     public int quantidadeNos(){
//         return tamanho;
//     }

//     public String toString() {
//         StringBuilder sb = new StringBuilder();
//         No<T> atual = inicio;
//         while (atual != null){
//             sb.append(atual.valor.toString());
//             if (atual.proximo != null){
//                 sb.append(",");
//             }
//             atual = atual.proximo;
//         }
//         return sb.toString();
//     }

// }