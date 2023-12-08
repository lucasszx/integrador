package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private long idAluno;
	private String matricula;
	private String senha;
	private String nome;
	private List<Agendamento> listaAgendamento;

	public Aluno() {
		super();
		matricula = "";
		senha = "";
		nome = "";
		listaAgendamento = new ArrayList<Agendamento>();

	}

	public Aluno(long idAluno, String matricula, String senha, String nome, List<Agendamento> listaAgendamento) {
		super();
		this.idAluno = idAluno;
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.listaAgendamento = listaAgendamento;
	}

	public long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
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

	public List<Agendamento> getListaAgendamento() {
		return listaAgendamento;
	}

	public void setListaAgendamento(List<Agendamento> listaAgendamento) {
		this.listaAgendamento = listaAgendamento;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", matricula=" + matricula + ", senha=" + senha + ", nome=" + nome
				+ ", listaAgendamento=" + listaAgendamento + "]";
	}

}