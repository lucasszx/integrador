package model;

import java.time.LocalDateTime;

public class Agendamento {

	private long idAgendamento;
	private LocalDateTime horarioInicio;
	private LocalDateTime horarioFim;
	private String descricaoFinal;
	private Aluno aluno;
	private Monitor monitor;
	private Disciplina disciplina;

	public Agendamento() {
		super();
		horarioInicio = LocalDateTime.now();
		horarioFim = LocalDateTime.now();
		descricaoFinal = "";
		aluno = new Aluno();
		monitor = new Monitor();
		disciplina = new Disciplina();
	}

	public Agendamento(long idAgendamento, String status, LocalDateTime horarioInicio, LocalDateTime horarioFim,
			String descricaoFinal, Aluno aluno, Monitor monitor, Disciplina disciplina) {
		super();
		this.idAgendamento = idAgendamento;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.descricaoFinal = descricaoFinal;
		this.aluno = aluno;
		this.monitor = monitor;
		this.disciplina = disciplina;
	}

	public long getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(long idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public LocalDateTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalDateTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalDateTime getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(LocalDateTime horarioFim) {
		this.horarioFim = horarioFim;
	}

	public String getDescricaoFinal() {
		return descricaoFinal;
	}

	public void setDescricaoFinal(String descricaoFinal) {
		this.descricaoFinal = descricaoFinal;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Agendamento [idAgendamento=" + idAgendamento + ", horarioInicio=" + horarioInicio + ", horarioFim="
				+ horarioFim + ", descricaoFinal=" + descricaoFinal + ", aluno=" + aluno + ", monitor=" + monitor
				+ ", disciplina=" + disciplina + "]";
	}

}
