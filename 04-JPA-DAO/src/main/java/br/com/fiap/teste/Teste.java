package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.FarmaciaDAO;
import br.com.fiap.dao.impl.FarmaciaDAOImpl;
import br.com.fiap.entity.Farmacia;
import br.com.fiap.entity.TipoFarmacia;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

public class Teste {

	public static void main(String[] args) {

		//Instanciar a galera
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		EntityManager em = fabrica.createEntityManager();
		
		FarmaciaDAO dao = new FarmaciaDAOImpl(em);
		
		//cadastrar uma farmacia 
		Farmacia fm = new Farmacia("uashaus", new GregorianCalendar(2019, Calendar.FEBRUARY, 12), TipoFarmacia.POPULAR, true);
		
		try {
			dao.cadastrar(fm);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		//Atualizar dados
		fm.setNome("DROGASIL222");
		
		try {
			dao.atualizar(fm);
			dao.commit();			
		} catch (Exception e) {
			e.printStackTrace();
		};
		
		//Pesquisar farmacia de codigo 1
		Farmacia busca = dao.buscar(1);
		System.out.println(busca.getNome());
		
		//Remover
		try {
			dao.deletar(1);
			dao.commit();
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}catch(CommitException e) {
			e.printStackTrace();
		}
		
		
		em.close();
		fabrica.close();
		
	}

}
