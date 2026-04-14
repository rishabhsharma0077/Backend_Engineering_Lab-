package decorator;

import model.Message;

public class EncryptedMessage extends NotificationDecorator {
    public EncryptedMessage(Message message) {
        super(message);
    }
    @Override
    public String getContent() {
        return "Encrypted: " + message.getContent();
    }
}