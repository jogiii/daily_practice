package decorator;

public abstract class CoffeeDecorator implements Coffee{

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee=coffee;
    }

    public abstract String getDescription();
    public abstract double getCost();

}
