package model;

import java.util.ArrayList;
import java.util.List;

public class Monitor {

	private long idMonitor;
	private String matricula;
	private String senha;
	private String nome;
	private List<Agendamento> listaAgendamento;
	private Disciplina disciplina;

	public Monitor() {
		super();
		matricula = "";
		senha = "";
		nome = "";
		listaAgendamento = new ArrayList<Agendamento>();
		disciplina = new Disciplina();
	}

	public Monitor(long idMonitor, String matricula, String senha, String nome, List<Agendamento> listaAgendamento,
			Disciplina disciplina) {
		super();
		this.idMonitor = idMonitor;
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.listaAgendamento = listaAgendamento;
		this.disciplina = disciplina;
	}

	public long getIdMonitor() {
		return idMonitor;
	}

	public void setIdMonitor(long idMonitor) {
		this.idMonitor = idMonitor;
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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Monitor [idMonitor=" + idMonitor + ", matricula=" + matricula + ", senha=" + senha + ", nome=" + nome
				+ ", listaAgendamento=" + listaAgendamento + ", disciplina=" + disciplina + "]";
	}

}
