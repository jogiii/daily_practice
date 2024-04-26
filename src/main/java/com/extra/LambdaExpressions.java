package com.extra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressions {

    public static List<Car> findCars(List<Car> cars){
        ArrayList<Car> filteredCars = new ArrayList<Car>();

        return cars.stream()
                .filter(car -> car.kilometers > 5000)
                .collect(Collectors.toList());
    }


}
