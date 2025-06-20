package decorator;

public class HtmlEncodedMessage extends MessageDecorator{

    public HtmlEncodedMessage(Message message){
        super(message);
    }

    @Override
    public String getContent() {
        return "<p>"+message.getContent()+"</p>";
    }

}
