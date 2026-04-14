package strategy;

public class ImmediateSendStrategy implements SendStrategy {

	@Override
	public void send(String content) {
		System.out.println("Sending immediately: " + content);

	}

}
