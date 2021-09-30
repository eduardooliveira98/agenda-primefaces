package br.com.agendaonline.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.agendaonline.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaSessoes().close();
	}
}
