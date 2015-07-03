package nl.atos.devlab.angular.kadopenning.core.generic.impl.dao;

import nl.atos.devlab.angular.kadopenning.core.generic.interfaces.dao.GenericDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public abstract class GenericHibernateDAO<T> implements GenericDAO<T> {

	private Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionFactory;
	
	//override code here
	

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public GenericHibernateDAO(Class<T> persistenClass) {
		super();
		this.persistentClass = persistenClass;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	};

}