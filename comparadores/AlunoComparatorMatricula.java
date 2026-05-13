package comparadores;

import java.util.Comparator;
import dominio.Aluno;

public class AlunoComparatorMatricula implements Comparator<Aluno> {
    @Override
    public int compare(Aluno a1, Aluno a2) {
        return a1.getMat().compareTo(a2.getMat());
    }
}