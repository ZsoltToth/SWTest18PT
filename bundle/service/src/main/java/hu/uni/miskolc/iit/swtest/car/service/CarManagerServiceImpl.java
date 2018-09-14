package hu.uni.miskolc.iit.swtest.car.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import hu.uni.miskolc.iit.swtest.car.core.model.Car;
import hu.uni.miskolc.iit.swtest.car.core.model.Manufacturer;
import hu.uni.miskolc.iit.swtest.car.core.service.CarDoesNotExisitsException;
import hu.uni.miskolc.iit.swtest.car.core.service.CarManagerService;
import hu.uni.miskolc.iit.swtest.car.core.service.exceptions.CarAlreadyExistsException;
import hu.uni.miskolc.iit.swtest.car.dao.CarDAO;
import hu.uni.miskolc.iit.swtest.car.dao.exception.DuplicatedCarEntryException;
import hu.uni.miskolc.iit.swtest.car.dao.exception.EntryNotFoundExpcetion;

public class CarManagerServiceImpl implements CarManagerService {
	
	private CarDAO carDAO;

	public CarManagerServiceImpl(CarDAO carDAO) {
		super();
		this.carDAO = carDAO;
	}

	public void recordCar(Car car) throws CarAlreadyExistsException {
		try {
			carDAO.createCar(car);
		} catch (DuplicatedCarEntryException e) {
			throw new CarAlreadyExistsException(e);
		}
	}

	public void updateCar(Car car) throws CarDoesNotExisitsException {
		try {
			carDAO.updateCar(car);
		} catch (EntryNotFoundExpcetion e) {
			throw new CarDoesNotExisitsException(e);
		}
	}

	public Collection<Car> listCars() {
		return carDAO.readCars();
	}

	public Collection<Car> listCarsByManufacturer(Manufacturer manufacturer) {
		Set<Car> result = new HashSet<Car>();
		for(Car car : listCars()) {
			if(car.getManufacturer() == manufacturer) {
				result.add(car);
			}
		}
		return result;
	}

}
