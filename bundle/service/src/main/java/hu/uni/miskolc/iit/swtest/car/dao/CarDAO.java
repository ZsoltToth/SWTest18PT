package hu.uni.miskolc.iit.swtest.car.dao;

import java.util.Collection;

import hu.uni.miskolc.iit.swtest.car.core.model.Car;
import hu.uni.miskolc.iit.swtest.car.dao.exception.DuplicatedCarEntryException;
import hu.uni.miskolc.iit.swtest.car.dao.exception.EntryNotFoundExpcetion;

/**
 * Data Access Object 
 * CREATE
 * READ
 * UPDATE
 * DELETE
 */
public interface CarDAO {

	void createCar(Car car) throws DuplicatedCarEntryException;
	
	Collection<Car> readCars();
	
	void updateCar(Car car) throws EntryNotFoundExpcetion;
	void deleteCar(Car car) throws EntryNotFoundExpcetion;
	
}
