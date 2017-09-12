package es.savemywallet.com.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.savemywallet.com.beans.Movement;
import es.savemywallet.com.daos.MovementDAO;
import es.savemywallet.com.daos.StatisticsDAO;
import es.savemywallet.com.interfaces.IMovementService;
import es.savemywallet.com.interfaces.IStatisticsService;

public class StatisticsService implements IStatisticsService {

	/**
	 * Properties
	 */
	private StatisticsDAO statisticsDAO;
	
	/**
	 * Constructor
	 */
	public StatisticsService(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		statisticsDAO = (StatisticsDAO) context.getBean("statisticsDAO");
	}
	
	/**
	 * Method list concept
	 */
	@Override
	public List<Object> ingresos(int walletId) {
		
		List<Object> list = statisticsDAO.ingresos(walletId);
		
		return list;
	}

	@Override
	public List<Object> gastos(int walletId) {
		List<Object> list = statisticsDAO.gastos(walletId);
		
		return list;
	}

	@Override
	public Object versus(int walletId) {
		Object versus = statisticsDAO.versus(walletId);
		return versus;
	}

	@Override
	public Object versusAll(int userId) {
		Object versus = statisticsDAO.versusAll(userId);
		return versus;
	}

}
