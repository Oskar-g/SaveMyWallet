package es.savemywallet.com.interfaces;

import java.util.List;

import es.savemywallet.com.beans.Concept;

public interface IStatisticsDAO {

	public List<Object> ingresos(int walletId);

	public List<Object> gastos(int walletId);

	public Object versusAll(int userId);

	public Object versus(int walletId);

}
