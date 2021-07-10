package datos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.NotificacionToken;
import entidades.Usuario;

/**
 * Session Bean implementation class NotificacionToken
 */
@Stateless
@LocalBean
public class NotificacionTokenDato implements NotificacionTokenDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
    public NotificacionTokenDato() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void saveUserToken(NotificacionToken notificacionToken) {
		// TODO Auto-generated method stub
		em.persist(notificacionToken);
	}

	@Override
	public List<NotificacionToken> getUserTokens(Usuario usuario) {
		return em.createQuery("Select n from NotificacionToken n where n.usuario.id = :id", NotificacionToken.class)
				.setParameter("id", usuario.getCi())
				.getResultList();
	}
	
	@Override
	public Boolean existeNoficacionToken(NotificacionToken notificacionToken) {
		return em.createQuery("Select n from NotificacionToken n where n.usuario.id = :id and n.token = :token", NotificacionToken.class)
				.setParameter("id", notificacionToken.getUsuario().getCi())
				.setParameter("token", notificacionToken.getToken())
				.getResultList().size()>0;
		
	}

}
