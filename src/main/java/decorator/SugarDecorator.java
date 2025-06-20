package decorator;

public class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(Coffee coffee) {
        super(coffee);//TODO Auto-generated constructor stub
    }

    @Override
    public String getDescription() {
       return coffee.getDescription()+ ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost()+0.5;
    }

}
