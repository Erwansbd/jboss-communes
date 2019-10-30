package fr.gtm.communes;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.communes.entities.Commune;

@Singleton
public class CommunesDAO {
	@PersistenceContext(name="communes") private EntityManager em; 
	
	public List<Commune> getCommunesByCp(String cp) {
		return em.createNamedQuery("Commune.byCodePostal", Commune.class)
					.setParameter("codePostal", cp+"%")
					.getResultList();
	}

}
