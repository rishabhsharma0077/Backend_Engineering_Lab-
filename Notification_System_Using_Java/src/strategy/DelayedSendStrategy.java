package strategy;

public class DelayedSendStrategy implements SendStrategy {

	@Override
	public void send(String content) {
		System.out.println("Sending after delay: " + content);
	}

}
