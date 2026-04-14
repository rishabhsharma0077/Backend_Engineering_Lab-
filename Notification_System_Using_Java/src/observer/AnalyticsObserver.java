package observer;

public class AnalyticsObserver implements NotificationObserver {

	@Override
	public void update(String msg) {
		System.out.println("Analytics: Tracking -> " + msg);

	}

}
