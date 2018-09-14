package hu.uni.miskolc.iit.swtest.car.dao.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import hu.uni.miskolc.iit.swtest.car.core.model.Car;
import hu.uni.miskolc.iit.swtest.car.core.model.CarModel;
import hu.uni.miskolc.iit.swtest.car.core.model.InvalidProductionYearException;
import hu.uni.miskolc.iit.swtest.car.core.model.Manufacturer;
import hu.uni.miskolc.iit.swtest.car.dao.CarDAO;
import hu.uni.miskolc.iit.swtest.car.dao.exception.DuplicatedCarEntryException;
import hu.uni.miskolc.iit.swtest.car.dao.exception.EntryNotFoundExpcetion;

public class CarFileDAO implements CarDAO {

	private File database;

	private static final String FIELD_SEPARATOR = ";";
	
	
	public CarFileDAO(String databasePath) {
		super();
		this.database = new File(databasePath);
	}

	public CarFileDAO(File database) {
		super();
		this.database = database;
	}

	public void createCar(Car car) throws DuplicatedCarEntryException {
		Collection<Car> cars = readCars();
		if(cars.contains(car)) {
			throw new DuplicatedCarEntryException(car.toString());
		}
		cars.add(car);
		overrideDatabase(cars);
	}

	public Collection<Car> readCars() {
		Collection<Car> result = new ArrayList<Car>();
		String line = null;
		try {
		BufferedReader br = new BufferedReader(new FileReader(database));
		while((line = br.readLine()) != null) {
			String[] fields = line.split(FIELD_SEPARATOR);
			if(fields.length!= 5) {
				continue;
			}
			Manufacturer manufacturer = Manufacturer.valueOf(fields[0]);
			CarModel model = CarModel.valueOf(fields[1]);
			String color = fields[2];
			int productionYear = Integer.parseInt(fields[3]);
			int grossWeight = Integer.parseInt(fields[4]);;
			result.add(new Car(model, color, productionYear, grossWeight));
		}
		}
		catch(IOException e) {
			System.out.println(e);
		} catch (InvalidProductionYearException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void updateCar(Car car) throws EntryNotFoundExpcetion {
		// TODO Auto-generated method stub

	}

	public void deleteCar(Car car) throws EntryNotFoundExpcetion {
		Collection<Car> cars = readCars();
		if(cars.contains(car) == false) {
			throw new EntryNotFoundExpcetion(car.toString());
		}
		cars.remove(car);
		overrideDatabase(cars);
	}
	
	private String marshal2record(Car car) {
		return ""+
				car.getManufacturer().toString()+FIELD_SEPARATOR+
				car.getModel().toString()+FIELD_SEPARATOR+
				car.getColor()+FIELD_SEPARATOR+
				car.getProductionYear()+FIELD_SEPARATOR+
				car.getGrossWeight()+FIELD_SEPARATOR;
	}
	
	private void overrideDatabase(Collection<Car> cars) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileWriter(database, false));
			for(Car car : cars) {
				writer.println(marshal2record(car)+"\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
