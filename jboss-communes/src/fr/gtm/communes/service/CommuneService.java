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

	public String decimalToSexagesimal(double value) {
		int degres = (int) value;
		double mn = (value - degres)*60;
		double sec = (mn - (int)mn)*60;
		return String.format("%2d° %2d\' %2.2f\"", degres,(int)mn,sec);
	}
}
