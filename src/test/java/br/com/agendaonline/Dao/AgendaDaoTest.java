package br.com.agendaonline.Dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.agendaonline.domain.Agendar;


public class AgendaDaoTest {
	
	@Test
	//@Ignore
	public void Salvar() {
		
		// instaciacao do objeto referente o fonercedor, para salvar no banco de dados
		Agendar agendar = new Agendar();
		
		//realizacao da inscricao no banco de dados
		AgendarDao agendarDao = new AgendarDao();
		
		//preenchimento do campo respectivo a tabela 'fornecedores
		agendar.setTarefa("Cozinhar o frango");
		agendar.setHorario("Duas Horas");
		
		agendarDao.salvar(agendar);
		
		//mensagem de sucesso
		System.out.println("Agendado com sucesso com sucesso");
		
	}
	
	@Test
	@Ignore
	public void Listar() {
		AgendarDao agendarDao = new AgendarDao();
		
		List<Agendar> resultado = agendarDao.listar();
		
						
		System.out.println("Total de Registro " + resultado.size());
		
		for (Agendar agendar : resultado){
			
			System.out.println(agendar.getTarefa());
			
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		AgendarDao agendarDao = new AgendarDao();
		
		Agendar agendar = agendarDao.buscar(codigo);
		
				
		if (agendar == null) {
			
			System.out.println("Nenhum registro encontrado. ");
			
		} else {
			System.out.println("Registro encontrado. ");
			System.out.println(agendar.getTarefa());
					
		}
		}
		public void excluir() {
			
			Long codigo = 20L;
			AgendarDao agendarDao = new AgendarDao();
			Agendar agendar = agendarDao.buscar(codigo);
			
			
	if (agendar == null) {
				
				System.out.println("Nenhum registro encontrado. ");
				
			} else {
				agendarDao.excluir(agendar);
				System.out.println("Registro encontrado. ");
				System.out.println(agendar.getTarefa());
				
			}
			
		}

	@Test
	@Ignore
	public void editar() {
			
			Long codigo = 1L;
			
		AgendarDao agendarDao = new AgendarDao();
		Agendar agendar = agendarDao.buscar(codigo);
		
				
		if (agendar == null) {
				
				System.out.println("Nenhum registro encontrado. ");
				
			} else {
				
				agendar.setTarefa("Tarefa Nova");
				agendarDao.editar(agendar);
				System.out.println("Registro encontrado. ");
				System.out.println(agendar.getTarefa());
				
			}

			
		}
}
