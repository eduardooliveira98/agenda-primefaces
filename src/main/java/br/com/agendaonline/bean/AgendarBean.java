package br.com.agendaonline.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.agendaonline.Dao.AgendarDao;
import br.com.agendaonline.domain.Agendar;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AgendarBean implements Serializable{
	

	private List<Agendar> agendar;
	
	private Agendar agenda = new Agendar();
	
	private String acao;

	public List<Agendar> getAgendar() {
		return agendar;
	}

	public void setAgendar(List<Agendar> agendar) {
		this.agendar = agendar;
	}

	public Agendar getAgenda() {
		return agenda;
	}

	public void setAgenda(Agendar agenda) {
		this.agenda = agenda;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	@PostConstruct
	public void listar() {
		try {
			AgendarDao agendarDao = new AgendarDao();
			agendar = agendarDao.listar();

		} catch (Exception erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao Listar");

		}
	}

	public void salvar() {
		try {
			AgendarDao agendarDao = new AgendarDao();
			agendarDao.salvar(agenda);;
			Messages.addFlashGlobalError("Tarefa Salva");

		} catch (Exception erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao Salvar");

		}
	}
	
	public void editar() {
		try {
			AgendarDao agendarDao = new AgendarDao();
			agendarDao.editar(agenda);
			Messages.addFlashGlobalError("Tarefa atualizada com Sucesso");

		} catch (Exception erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao Editar");

		}
	}
	
	public void excluir() {
		try {
			AgendarDao agendarDao = new AgendarDao();
			agendarDao.excluir(agenda);
			Messages.addFlashGlobalError("Tarefa Removida");

		} catch (Exception erro) {

			Messages.addFlashGlobalError("Ocorreu um erro ao Excluir");

		}
	}



}
