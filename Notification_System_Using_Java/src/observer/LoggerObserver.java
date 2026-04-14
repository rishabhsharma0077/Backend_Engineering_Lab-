package observer;

public class LoggerObserver implements NotificationObserver {

	@Override
	public void update(String msg) {
		 System.out.println("Logger: " + msg);

	}

}
