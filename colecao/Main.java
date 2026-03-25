package colecao;

import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args ){
        Scanner s = new Scanner(System.in).useLocale(Locale.US);
        IColecao<Aluno> lstA = new ListaEncadeada<>();
        int op = 0;

        while (op != 5){
            System.out.println("GERENCIAMENTO DE ALUNOS\n");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Pesquisar aluno");
            System.out.println("3. Remover aluno");
            System.out.println("4. Lista completa de alunos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            op = s.nextInt();
            s.nextLine();

            switch(op){
                case 1:
                    System.out.println("Matricula: ");
                    String mat = s.nextLine();
                    s.nextLine();
                    System.out.println("Nome: ");
                    String nome = s.nextLine();
                    System.out.println("Nota: ");
                    double nota  = s.nextDouble();

                    lstA.adicionar(new Aluno(nome, mat, nota));
                    System.out.println("Aluno adicionado com sucesso.");
                    break;

                case 2:
                    System.out.println("Matricula: ");
                    String Pmat = s.nextLine();
                    Aluno result = lstA.pesquisar(new Aluno("", Pmat, 0.0));

                    if(result != null){
                        System.out.println("Dados do aluno: " + result);
                    }else{
                        System.out.println("Matricula nao encontrada.");
                    }
                    break;   


                case 3:
                    System.out.println("Entre com a matricula a ser deletada: ");
                    String Dmat = s.nextLine();
                    if (lstA.remover(new Aluno("", Dmat, 0.0))){
                        System.out.println("Matricula deletada.");

                    }else{
                        System.out.println("A matricula nao foi encontrada.");
                    }
                    break;  
                    
                case 4:
                    System.out.println("***LISTA COMPLETA DE ALUNOS***");
                    int qtdA = lstA.quantidadeNos();

                    for(int i = 1; i < qtdA; i++){
                        System.out.println(i  + ". " + lstA.toString());
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;


                default:
                    System.out.println("Opcao inexistente.");    


            }

        }
        s.close();
    }
    
}
