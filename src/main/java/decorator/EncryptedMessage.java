package decorator;

public class EncryptedMessage extends MessageDecorator{

    public EncryptedMessage(Message message){
        super(message);
    }

    @Override
    public String getContent() {
        return new StringBuilder(message.getContent().reverse().toString());
    }

}
