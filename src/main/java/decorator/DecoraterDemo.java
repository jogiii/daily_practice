package decorator;

public class DecoraterDemo {

    public static void main(String[] args) {

        //apply decoraters

        Message encrypted = new HtmlEncodedMessage(new EncryptedMessage(new TextMessage("Hello Joginder")));

    }

}
