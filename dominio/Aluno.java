package dominio;

import java.util.Objects;

public class Aluno {
    private String nome;
    private String matricula;
    private double nota;

    public Aluno(String nome, String matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    //Getters 
    public String getNome(){
        return nome;
    }
    public String getMat(){
        return matricula;
    }
    public double getNota(){
        return nota;
    }

    @Override
    public boolean equals(Object a){
        if (this == a) return true;
        if (a == null || this.getClass() != a.getClass()) return false;
        Aluno aluno = (Aluno) a;

        return matricula.equals(aluno.matricula);
    }

    @Override
    public int hashCode(){
        return Objects.hash(matricula);
    }

    @Override
    public String toString(){
        return "Matricula: " + matricula + " / Nome: " + nome + " / Nota: " + nota;
    }
}