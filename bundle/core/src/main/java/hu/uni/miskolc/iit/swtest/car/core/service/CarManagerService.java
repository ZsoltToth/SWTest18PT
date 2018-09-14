package hu.uni.miskolc.iit.swtest.car.core.service;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.car.core.model.Car;
import hu.uni.miskolc.iit.swtest.car.core.service.exceptions.CarAlreadyExistsException;

public interface CarManagerService {
	
	void recordCar(Car car) throws CarAlreadyExistsException;
	void updateCar(Car car) throws CarDoesNotExisitsException;
	
	Collection<Car> listCars();
	Collection<Car> listCarsByManufacturer();

}
