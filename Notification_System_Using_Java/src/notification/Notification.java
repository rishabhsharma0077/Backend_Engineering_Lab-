package notification;

import strategy.SendStrategy;

public abstract class Notification {
	protected SendStrategy strategy;

    public void setSendStrategy(SendStrategy strategy) {
        this.strategy = strategy;
    }

    public void send(String message) {
        if (strategy != null) strategy.send(message);
        else System.out.println("No strategy defined!");
    }
}



