package factory;

public class CoffeeMachine {

    public static void main(String[] args) {
        var coffee = CoffeeFactory.getCoffee("espresso");
        System.out.println(coffee.getName());
    }

}
