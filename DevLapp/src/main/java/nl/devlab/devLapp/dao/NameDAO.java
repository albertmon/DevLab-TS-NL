package nl.devlab.devLapp.dao;

import java.util.List;

import nl.devlab.common.Utils;
import nl.devlab.devLapp.entity.Name;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Repository
public class NameDAO {

	@Autowired
	private SessionFactory sessionFactory;
		

	/**
	 * @return
	 */
	public List<Name> getNameList() {
		
		String queryStr =
				" from Name n";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		
		List<Name> nameList = Utils.castList(Name.class, query.list());
	    
	    return nameList;
	}

	/**
	 * @param nameId
	 * @return
	 */
	public Name getName(Long nameId) {
		
		String queryStr =
				" from Name n " +
				" where n.nameId = :nameId";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setLong("nameId", nameId);
		
		Name name = (Name) query.uniqueResult();
	    
	    return name;
	}

	/**
	 * save name
	 * 
	 * @param Name
	 * @return
	 */
	public void saveName(Name name) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(name);		
	}

	/**
	 * delete name
	 * 
	 * @param nameId
	 * @return
	 */
	public void deleteName(Long nameId) {
		Name name = getName(nameId);
		if (name != null) {
			sessionFactory.getCurrentSession().delete(name);
		}
	}

}
