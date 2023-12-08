package model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private long idDisciplina;
	private String nome;
	private List<Agendamento> listaAgendamento;
	private List<Monitor> listaMonitor;

	public Disciplina() {
		super();
		nome = "";
		listaAgendamento = new ArrayList<Agendamento>();
		listaMonitor = new ArrayList<Monitor>();
	}

	public Disciplina(long idDisciplina, String nome, List<Agendamento> listaAgendamento, List<Monitor> listaMonitor) {
		super();
		this.idDisciplina = idDisciplina;
		this.nome = nome;
		this.listaAgendamento = listaAgendamento;
		this.listaMonitor = listaMonitor;
	}

	public long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(long idDisciplina) {
		this.idDisciplina = idDisciplina;
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

	public List<Monitor> getListaMonitor() {
		return listaMonitor;
	}

	public void setListaMonitor(List<Monitor> listaMonitor) {
		this.listaMonitor = listaMonitor;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nome=" + nome + ", listaAgendamento=" + listaAgendamento
				+ ", listaMonitor=" + listaMonitor + "]";
	}

}
