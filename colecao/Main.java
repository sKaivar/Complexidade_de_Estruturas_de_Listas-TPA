package colecao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args ){
        Scanner s = new Scanner(System.in).useLocale(Locale.US);
        IColecao<Aluno> lstA = new ListaEncadeadaLinkedList<>();
        int op = 0;

        while (op != 5){
            System.out.println("GERENCIAMENTO DE ALUNOS\n");
            System.out.println("1. Adicionar aluno");
            System.out.println("2. Pesquisar aluno");
            System.out.println("3. Remover aluno");
            System.out.println("4. Lista completa de alunos");
            System.out.println("5. Injetar lista de alunos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            op = s.nextInt();
            s.nextLine();

            switch(op){
                case 1:{
                    System.out.print("Matricula: ");
                    String mat = s.nextLine();                    
                    System.out.print("Nome: ");
                    String nome = s.nextLine();
                    System.out.print("Nota: ");
                    double nota  = s.nextDouble();

                    lstA.adicionar(new Aluno(nome, mat, nota));
                    System.out.println("Aluno adicionado com sucesso.");
                    break;
                }    
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
                    System.out.println("******************************");
                    System.out.println("***LISTA COMPLETA DE ALUNOS***");
                    if (lstA.quantidadeNos() == 0){
                        System.out.println("Nenhum aluno matriculado.");
                    }else{                        
                        System.out.println(lstA.toString());
                    }                    
                    System.out.println("******************************");
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;



                case 5:
                    System.out.println("Digite o caminho do arquivo: ");
                    String arq = s.nextLine();

                    // guardar o ultimo aluno lido
                    Aluno ultimo = null;

                    // 1. injeção de dados e medição do tempo 
                    long inicio = System.currentTimeMillis();                   

                    try (BufferedReader br = new BufferedReader(new FileReader(arq))){
                        String linha; 

                        while ((linha = br.readLine()) != null){
                            String[] dados = linha.split(";");

                            if (dados.length == 3){
                                String mat = dados[0].trim();
                                String nome = dados[1].trim();
                                double nota = Double.parseDouble(dados[2].trim());
                                ultimo = new Aluno(mat, nome, nota);
                                lstA.adicionar(ultimo);
                            }
                        }
                        long fim = System.currentTimeMillis();
                        long total = fim - inicio;
    
                        System.out.println("Arquivo carregado.");
                        System.out.println("Total de alunos: " + lstA.quantidadeNos());
                        System.out.println("Tempo total de leitura: " + total + " ms");
                    } catch (IOException e){
                        System.out.println("Erro ao ler arquivo." + e.getMessage());
                        break;
                    } catch (NumberFormatException e){
                        System.out.println("Erro: Formato de nota invalido no arquivo.");
                        
                    }
                    
                    if (ultimo != null){
                        // 2. buscar ultimo elemento
                        long IBuscaUlt = System.nanoTime();
                        lstA.pesquisar(ultimo);
                        long FBuscaUlt = System.nanoTime();
                        System.out.println("Tempo para buscar o ultimo elemento: " +(FBuscaUlt - IBuscaUlt) + " ns");

                        // 3. buscar inexistente
                        Aluno nexist = new Aluno("lalala", "doidin doidilson", 0);
                        long IBuscaInex = System.currentTimeMillis();
                        lstA.pesquisar(nexist);
                        long FBuscaInex = System.currentTimeMillis();
                        System.out.println("Tempo para buscar elemento inexistente: " + (FBuscaInex - IBuscaInex) + " ms");
                        
                        // 4. remover ultimo elemento
                        long IRemoverUlt = System.nanoTime();
                        lstA.remover(ultimo);
                        long FRemoverUlt = System.nanoTime();
                        System.out.println("Tempo para remover o ultimo elemento: " + (FRemoverUlt - IRemoverUlt) + " ns");
                        
                        long IQuant = System.nanoTime();
                        int qtd = lstA.quantidadeNos();
                        long FQuant = System.nanoTime();
                        System.out.println("Quantidade de nos: " + qtd);
                        System.out.println("Tempo para exibir quantidade de nos: " + (FQuant - IQuant) + " ns");
                    }
                    System.out.println("********************************************");                
                    break;

                 

                default:
                    System.out.println("Opcao inexistente.");    


            }

        }
        s.close();
    }
    
}
