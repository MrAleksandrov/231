package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars;

    public CarServiceImpl() {

        cars = new ArrayList<Car>();
        cars.add(new Car("Car1", "Blue", 2005));
        cars.add(new Car("Car2", "Red", 1999));
        cars.add(new Car("Car3", "Yellow", 2021));
        cars.add(new Car("Car4", "Green", 2010));
        cars.add(new Car("Car5", "White", 1960));

    }

    @Override
    public List<Car> getCars(int count) {
        if (count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
