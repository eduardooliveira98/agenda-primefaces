package br.com.agendaonline.Dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.agendaonline.util.HibernateUtil;

public class GenericDao<Entidade>{

	private Class<Entidade> classe;
	private Entidade entidade; // captura quem faz a solicitacao

	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salvar(Entidade entidade) {

		this.entidade = entidade;
		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		Transaction transacao = null; // garante q as solicitacao de operacoes sejam efetuadas

		try {
			transacao = sessao.beginTransaction(); // inicia a transação

			sessao.save(entidade); // definiu a tabela

			transacao.commit(); // commit é salvar

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback(); // garante salvar as operacoes inteiras seja executada

			}
			throw erro;

		} finally {

			sessao.close();

		}

	}

	public List<Entidade> listar() {

		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		try {

			Criteria consulta = sessao.createCriteria(classe);

			List<Entidade> resultado = consulta.list();

			return resultado;

		} catch (RuntimeException erro) {

			throw erro;

		} finally {

			sessao.close();

		}
	}

	public Entidade buscar (long codigo) {
			
			Session sessao = HibernateUtil.getFabricaSessoes().openSession();
			
			try {
				
				Criteria consulta = sessao.createCriteria(classe);
				
				consulta.add(Restrictions.idEq(codigo)); //restricao igual ao codigo a cima
				
				Entidade resultado = (Entidade) consulta.uniqueResult();
				
				return resultado;
				
			}catch (RuntimeException erro) {


				throw erro;

			} finally {

				sessao.close();

			}			
		
		
	}
	
	public void excluir(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		Transaction transacao = null; 

		try {
			transacao = sessao.beginTransaction(); // inicia a transação

			sessao.delete(entidade); // definiu a tabela

			transacao.commit(); 

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();

			}
			throw erro;

		} finally {

			sessao.close();

		}

	}
	
	public void editar(Entidade entidade) {

		Session sessao = HibernateUtil.getFabricaSessoes().openSession();

		Transaction transacao = null; // garante q as solicitacao de operacoes sejam efetuadas

		try {
			transacao = sessao.beginTransaction(); // inicia a transação

			sessao.update(entidade); // definiu a tabela

			transacao.commit(); 

		} catch (RuntimeException erro) {

			if (transacao != null) {

				transacao.rollback();

			}
			throw erro;

		} finally {

			sessao.close();

		}

	}
}
