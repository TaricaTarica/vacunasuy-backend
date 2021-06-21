package datos;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * Session Bean implementation class VacunatorioGeomDato
 */
@Stateless
@LocalBean
public class VacunatorioGeomDato implements VacunatorioGeomDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
    @EJB
    VacunatorioDatoLocal vdl;
    
    
    public VacunatorioGeomDato() {
        // TODO Auto-generated constructor stub
    }
    
    public void agregarCoordenadas(long idVacunatorio, String lat, String lon) {
    	if(vdl.obtenerVacunatorio(idVacunatorio) != null){
    		Query q = em.createNativeQuery("INSERT INTO vacunatoriogeom (geom, vacunatorio_id) VALUES (ST_GeomFromText('POINT(? ?)', 4326)), ?;");
        	
        	q.setParameter(1, lat).setParameter(2, lon).setParameter(3, idVacunatorio);
    	}
    	
    	/*Insert into markers (name, the_geom) VALUES ('Zion National Park', ST_GeomFromText('POINT(-112.68142 37.22299)', 4326));*/
    }
    
    

}
