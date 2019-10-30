package fr.gtm.communes.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import fr.gtm.communes.CommunesDAO;
import fr.gtm.communes.entities.Commune;

@Singleton
public class CommuneService {
	@EJB private CommunesDAO dao;
	
	public List<Commune> getCommunesByCodePostalLike(String cp) {
		return dao.getCommunesByCp(cp);
	}
}
