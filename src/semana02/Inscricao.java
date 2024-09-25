package semana02;

public class Inscricao {
    public static final int NA =-1;

    private int nota = NA;
    private Aluno aluno;

    public Inscricao ( Aluno aluno){
        this.aluno =aluno;
    }

    public Aluno getAluno(){
        return aluno;
    }
    public int getNota(){
        return nota;
    }

    public boolean temNota(){
        return nota !=NA;
    }
    public void setNota(int nota){
        this.nota = nota;
    }

    @Override
    public String toString(){
        if(temNota())
            return aluno + " - " + nota + " valores";
        return aluno + " ainda nao tem nota atribuida";
    }




}
