package notificacionesFirebase;

import javax.ejb.Local;



@Local
public interface ServiceAgentFirebaseLocal {
	public void sendPushNotification(NotificationInfo notificacion);

}
