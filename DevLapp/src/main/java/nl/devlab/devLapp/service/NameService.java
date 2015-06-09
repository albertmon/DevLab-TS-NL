package nl.devlab.devLapp.service;

import java.util.List;

import nl.devlab.devLapp.dao.NameDAO;
import nl.devlab.devLapp.entity.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Service
public class NameService {

	@Autowired
	private NameDAO nameDAO;

	/**
	 * get project by userId, countryCode, projectName
	 * 
	 * @param userId
	 * @param countryCode
	 * @param projectName
	 * @return
	 */
	@Transactional
	public List<Name> getNameList() {
		List<Name> nameList = nameDAO.getNameList();
		return nameList;
	}
	
	/**
	 * get name by nameId
	 * 
	 * @param nameId
	 * @return
	 */
	@Transactional
	public Name getName(Long nameId) {
		Name name = nameDAO.getName(nameId);
		return name;
	}

	/**
	 * save name
	 * 
	 * @param name
	 * @return
	 */
	@Transactional
	public void saveName(Name name) {
		nameDAO.saveName(name);
	}

	/**
	 * delete name by nameId
	 * 
	 * @param nameId

	 * @return
	 */
	@Transactional
	public void deleteName(Long nameId) {
		nameDAO.deleteName(nameId);
	}

}
