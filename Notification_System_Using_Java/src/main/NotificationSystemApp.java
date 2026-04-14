package main;

import factory.NotificationFactory;
import notification.Notification;
import strategy.ImmediateSendStrategy;
import strategy.DelayedSendStrategy;
import singleton.NotificationManager;
import observer.*;

public class NotificationSystemApp {
	public static void main(String[] args) {
		NotificationManager manager = NotificationManager.getInstance();
		manager.registerObserver(new LoggerObserver());
		manager.registerObserver(new AnalyticsObserver());

		Notification email = NotificationFactory.createNotification("EMAIL");
		email.setSendStrategy(new ImmediateSendStrategy());
		email.send("Hello via Email!");

		Notification sms = NotificationFactory.createNotification("SMS");
		sms.setSendStrategy(new DelayedSendStrategy());
		sms.send("Hello via SMS!");

		manager.notifyObservers("Notification sent successfully.");
	}
}