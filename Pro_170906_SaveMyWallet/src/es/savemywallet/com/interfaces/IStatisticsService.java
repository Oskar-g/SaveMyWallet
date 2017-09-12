package es.savemywallet.com.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import es.savemywallet.com.beans.Movement;

public interface IStatisticsService {

	public 	List<Object> ingresos(int walletId);

	public 	List<Object> gastos(int walletId);

	public Object versus(int wallet);

	public Object versusAll(int userId);
}
