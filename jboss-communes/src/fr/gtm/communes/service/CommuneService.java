package fr.gtm.communes.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.gtm.communes.CommunesDAO;
import fr.gtm.communes.entities.Commune;
import fr.gtm.communes.entities.Region;

@Stateless
@WebService

public class CommuneService implements CommuneServiceRemote, CommuneServiceLocal, CommuneServiceInterface {
	@EJB private CommunesDAO dao;
	
	@Override
	public List<Commune> getCommunesByCodePostalLike(String cp) {
		return dao.getCommunesByCp(cp);
	}

	@Override
	public List<Region> getRegions() {
		return dao.getRegions();
	}
}
