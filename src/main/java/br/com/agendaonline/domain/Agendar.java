package br.com.agendaonline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Agendar {

	@Id
	@Column(nullable = false)
	private String Tarefa;
	
	@Column(nullable = false)
	private String Horario;

	public String getTarefa() {
		return Tarefa;
	}

	public void setTarefa(String tarefa) {
		Tarefa = tarefa;
	}

	public String getHorario() {
		return Horario;
	}

	public void setHorario(String horario) {
		Horario = horario;
	}
}
	

