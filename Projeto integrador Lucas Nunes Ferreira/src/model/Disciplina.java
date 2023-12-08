package model;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private long idDisciplina;
	private String nome;
	private List<Agendamento> listaAgendamento;
	private Monitor Monitor;

	public Disciplina() {
		super();
		nome = "";
		listaAgendamento = new ArrayList<Agendamento>();
		monitor = Monitor();
	}

	public Disciplina(long idDisciplina, String nome, List<Agendamento> listaAgendamento, Monitor monitor) {
		super();
		this.idDisciplina = idDisciplina;
		this.nome = nome;
		this.listaAgendamento = listaAgendamento;
		this.Monitor = monitor;
	}
}
