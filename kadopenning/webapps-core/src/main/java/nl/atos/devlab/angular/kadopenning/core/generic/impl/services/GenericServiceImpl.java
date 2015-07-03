package nl.atos.devlab.angular.kadopenning.core.generic.impl.services;

import java.util.List;

import nl.atos.devlab.angular.kadopenning.core.generic.interfaces.dao.GenericDAO;
import nl.atos.devlab.angular.kadopenning.core.generic.interfaces.services.GenericService;

import org.springframework.stereotype.Service;
@Service
public class GenericServiceImpl<T, DAO extends GenericDAO<T>> implements GenericService<T> {
	
	private DAO dao;
	
	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	public DAO getDao() {
		return dao;
	}

	public void saveOrUpdate(T entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void delete(T entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public T getById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
