package observer;

public class ObserverPatternDemo {

    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        Observer aajTak = new NewsChannel("AajTak");
        Observer bbc = new NewsChannel("BBC");

        agency.attach(aajTak);
        agency.attach(bbc);

        agency.setNews("Elections 2025: Results announced");
        agency.setNews("Stock Market hits all-time high");
        
    }

}
