package singleton;

import java.util.ArrayList;
import java.util.List;
import observer.NotificationObserver;

public class NotificationManager {
	 private static NotificationManager instance;
	    private List<NotificationObserver> observers = new ArrayList();

	    private NotificationManager() {}

	    public static NotificationManager getInstance() {
	        if (instance == null) instance = new NotificationManager();
	        return instance;
	    }

	    public void registerObserver(NotificationObserver observer) {
	        observers.add(observer);
	    }

	    public void notifyObservers(String msg) {
	        for (NotificationObserver obs : observers) {
	            obs.update(msg);
	        }
	    }

}
