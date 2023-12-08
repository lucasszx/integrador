package model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	private long idProfessor;
	private String matricula;
	private String senha;
	private String nome;
	private Disciplina disciplina;
	
	public Professor() {
		super();
		matricula = "";
		senha = "";
		nome = "";
		disciplina = new Disciplina();
	}

	public Professor(long idProfessor, String matricula, String senha, String nome, Disciplina disciplina) {
		super();
		this.idProfessor = idProfessor;
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.Disciplina = disciplina;
	}

}
