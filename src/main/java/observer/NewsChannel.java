package observer;

public class NewsChannel implements Observer{

    private String channelName;

    public NewsChannel(String name){
        this.channelName = name;
    }

    @Override
    public void update(String message) {
       System.out.println(channelName+ "received news "+ message);
    }

}
