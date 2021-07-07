package notificacionesFirebase;

import java.io.Serializable;

public class NotificationInfo implements Serializable {
	private static final long serialVersionUID = -8766113300378741799L;
	
	private String to;
	private NotificationInfoData notification;
	
	public NotificationInfo() {
		super();
	}

	public NotificationInfo(String to, NotificationInfoData data) {
		super();
		this.to = to;
		this.notification = data;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}


	

	public NotificationInfoData getNotification() {
		return notification;
	}

	public void setNotification(NotificationInfoData notification) {
		this.notification = notification;
	}

	@Override
	public String toString() {
		return "NotificationInfo [to=" + to + ", data=" + notification + "]";
	}

}
