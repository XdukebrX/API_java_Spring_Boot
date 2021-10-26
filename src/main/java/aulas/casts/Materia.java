package aulas.casts;

public class Materia {
    private int id_materia, workload, id_professor;
    private String name;

    public String getName() {
        return name;
    }

    public int getId_materia() {
        return id_materia;
    }

    public int getId_professor() {
        return id_professor;
    }


    public int getWorkload() {
        return workload;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }


    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }


    public void setWorkload(int workload) {
        this.workload = workload;
    }


    public  Materia(int id_materia_, int workload_, int id_professor_, String name_) {
        
        setId_materia(id_materia_);
        setWorkload(workload_);
        setId_professor(id_professor_);
        setName(name_);
    }








}
