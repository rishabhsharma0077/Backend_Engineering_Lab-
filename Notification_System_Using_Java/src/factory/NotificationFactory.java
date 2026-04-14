package factory;

import notification.EmailNotification;
import notification.Notification;
import notification.PushNotification;
import notification.SMSNotification;

public class NotificationFactory {
	 public static Notification createNotification(String type) {
	        switch (type) {
	            case "EMAIL": return new EmailNotification();
	            case "SMS": return new SMSNotification();
	            case "PUSH": return new PushNotification();
	            default: throw new IllegalArgumentException("Unknown type");
	        }
	    }
}
