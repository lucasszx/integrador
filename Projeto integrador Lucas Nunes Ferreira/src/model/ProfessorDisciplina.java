package model;

public class ProfessorDisciplina {

	private long idProfessorDisciplina;
	private Professor professor;
	private Disciplina disciplina;

	public ProfessorDisciplina() {
		super();
		professor = new Professor();
		disciplina = new Disciplina();
	}

	public ProfessorDisciplina(long idProfessorDisciplina, Professor professor, Disciplina disciplina) {
		super();
		this.idProfessorDisciplina = idProfessorDisciplina;
		this.professor = professor;
		this.disciplina = disciplina;
	}

	public long getIdProfessorDisciplina() {
		return idProfessorDisciplina;
	}

	public void setIdProfessorDisciplina(long idProfessorDisciplina) {
		this.idProfessorDisciplina = idProfessorDisciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Professor_Disciplina [idProfessorDisciplina=" + idProfessorDisciplina + ", professor=" + professor
				+ ", disciplina=" + disciplina + "]";
	}

}
