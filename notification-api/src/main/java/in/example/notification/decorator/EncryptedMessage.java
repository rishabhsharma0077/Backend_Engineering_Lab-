package in.example.notification.decorator;

import in.example.notification.model.Message;

public class EncryptedMessage extends NotificationDecorator {
	  public EncryptedMessage(Message message) { super(message); }
	  @Override public String getContent() { return "ENC(" + message.getContent() + ")"; }
	}