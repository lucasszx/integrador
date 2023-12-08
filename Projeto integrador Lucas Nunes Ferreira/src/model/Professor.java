package model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private long idProfessor;
	private String matricula;
	private String senha;
	private String nome;
	private List<Disciplina> listaDisciplina;

	public Professor() {
		super();
		matricula = "";
		senha = "";
		nome = "";
		listaDisciplina = new ArrayList<Disciplina>();
	}

	public Professor(long idProfessor, String matricula, String senha, String nome, List<Disciplina> listaDisciplina) {
		super();
		this.idProfessor = idProfessor;
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.listaDisciplina = listaDisciplina;
	}

	public long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getListaDisciplina() {
		return listaDisciplina;
	}

	public void setListaDisciplina(List<Disciplina> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	@Override
	public String toString() {
		return "Professor [idProfessor=" + idProfessor + ", matricula=" + matricula + ", senha=" + senha + ", nome="
				+ nome + ", listaDisciplina=" + listaDisciplina + "]";
	}

}
