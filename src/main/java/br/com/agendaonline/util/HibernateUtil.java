package br.com.agendaonline.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory fabricaSessoes = CriarFabricaSessoes();
	
	public static SessionFactory getFabricaSessoes() {
		
		
		return fabricaSessoes;
	
	}

		private static SessionFactory CriarFabricaSessoes() {
			try  {
				Configuration configuracao = new Configuration().configure(); //Captura cofiguração do Hibernate				
				ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build(); // Registra os serviços e aplica propriedas de Configuração
			
				SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			
			return fabrica;
			} catch (Throwable ex) {
				System.err.println("A fábrica de sessões não pode ser criada." + ex);
				throw new ExceptionInInitializerError(ex);
				
			}
		}

}
