package aulas.casts;

public class Matricula {
    private int id_matricula;
    private int id_aluno;
    private int id_materia;

    public int getId_aluno() {
        return id_aluno;
    }

    public int getId_materia() {
        return id_materia;
    }

    public int getId_matricula() {
        return id_matricula;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public void setId_matricula(int id_matricula) {
        this.id_matricula = id_matricula;
    }

    public Matricula (int id_matricula_, int id_aluno_, int id_materia_ ){
       
        setId_matricula(id_matricula_);
        setId_aluno(id_aluno_);
        setId_materia(id_materia_);
       
     }
 

	


    



    
}