package factory;

public class CoffeeFactory {


public static Coffee getCoffee(String type){

    if ("cappuccino".equalsIgnoreCase(type)) {
        return new Cappuccino();
    } else if ("espresso".equalsIgnoreCase(type)) {
        return new Espresso();
    }
    throw new IllegalArgumentException("Unknown coffee type: " + type);

}
}
