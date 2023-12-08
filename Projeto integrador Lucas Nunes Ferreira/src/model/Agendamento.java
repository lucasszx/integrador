package model;

import java.time.LocalDateTime;

public class Agendamento {

	private long idAgendamento;
	private LocalDateTime dia;
	private StausAtendimento statusAtendimento;
	private String descricaoFinal;
	private Aluno aluno;
	private Monitor monitor;
	private Disciplina disciplina;

	public Agendamento() {
		super();
		dia = LocalDateTime.now();
		statusAtendimento - new StausAtendimento();
		descricaoFinal = "";
		aluno = new Aluno();
		monitor = new Monitor();
		disciplina = new Disciplina();
	}

	public Agendamento(long idAgendamento, LocalDateTime dia, StausAtendimento statusAtendimento,
			String descricaoFinal, Aluno aluno, Monitor monitor, Disciplina disciplina) {
		super();
		this.idAgendamento = idAgendamento;
		this.dia = dia;
		this.statusAtendimento = statusAtendimento;
		this.descricaoFinal = descricaoFinal;
		this.aluno = aluno;
		this.monitor = monitor;
		this.disciplina = disciplina;
	}
}
