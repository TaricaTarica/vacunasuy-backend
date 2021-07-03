package datos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import datatypes.DTVacunatorioGeom;
import entidades.Vacunatorio;


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
    //recibe las coordenadas de la siguiente manera(-34.865609 -54.985410)
    public void agregarCoordenadas(long idVacunatorio, String lat, String lon) {
    	if(vdl.obtenerVacunatorio(idVacunatorio) != null){
    		
    		String value = "POINT("+lon+" "+lat+")";
    		Query q = em.createNativeQuery("INSERT INTO vacunatoriogeom (geom, vacunatorio_id) VALUES (ST_GeomFromText( :value, 4326), :id)");
        	
        	q.setParameter("value", value).setParameter("id", idVacunatorio);
        	
        	q.executeUpdate();
    	}
    	
    	/*Insert into markers (name, the_geom) VALUES ('Zion National Park', ST_GeomFromText('POINT(-112.68142 37.22299)', 4326));*/
    }
    
    @Override
    public List<DTVacunatorioGeom> vacunatoriosCercanos(String lat, String lon){
    	
    	
    	
    	String value = "POINT("+lon+" "+lat+")";
    	
    	//List<String> vacunatorios = new ArrayList<String>();
    	
    	List<DTVacunatorioGeom> vacunatorios = new ArrayList<DTVacunatorioGeom>();
    	Gson gson = new Gson();
    	
    	List<Object[]> retornoQuery = (List<Object[]>) em.createNativeQuery("SELECT vacunatorio_id, ST_AsGeoJSON (v.geom) FROM  vacunatoriogeom v\n"
    			+ "WHERE ST_Intersects(v.geom , ST_BUFFER(ST_GeomFromText( :value , 4326), 0.05))")
    			.setParameter("value", value).getResultList();
    	
    	System.out.println(retornoQuery);
    	
    	
    	for(Object[] o: retornoQuery) {
    		BigInteger bigVacId = (BigInteger) o[0];
    		JsonObject jsonObject = gson.fromJson( (String) o[1], JsonObject.class);
    		Vacunatorio vacunatorio = vdl.obtenerVacunatorio( bigVacId.longValue());
    		vacunatorios.add(new DTVacunatorioGeom(
    				vacunatorio.getId(),
    				vacunatorio.getNombre(),
    				jsonObject.get("coordinates").toString()
    		));
    	}
    	
    	return vacunatorios;
    	
    	
    	
    }
    
    
    

}
