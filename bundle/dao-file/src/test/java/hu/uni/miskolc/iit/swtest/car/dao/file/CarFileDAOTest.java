package hu.uni.miskolc.iit.swtest.car.dao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.plaf.FileChooserUI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.uni.miskolc.iit.swtest.car.core.model.Car;
import hu.uni.miskolc.iit.swtest.car.core.model.CarModel;
import hu.uni.miskolc.iit.swtest.car.core.model.InvalidProductionYearException;
import hu.uni.miskolc.iit.swtest.car.dao.CarDAO;

public class CarFileDAOTest {

	private static File DEFAULT_DB_STATE;
	
	private File temporalDB;
	private CarDAO dao;

	@BeforeClass
	public static void beforeClass() {
		DEFAULT_DB_STATE = new File("src/resources/carDB.csv");
	}

	@Before
	public void setUp() throws IOException {
		temporalDB = File.createTempFile("carDB", "csv");
		InputStream is = null;
		OutputStream os = null;
		try {

			is = new FileInputStream(DEFAULT_DB_STATE);
			os = new FileOutputStream(temporalDB);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
		this.dao = new CarFileDAO(temporalDB);
	}

	@Test
	public void testReadCarsFromDefaultDB() throws InvalidProductionYearException {
		List<Car> expected = Arrays.asList(
				new Car(CarModel.SWIFT, "green", 2000, 750),
				new Car(CarModel.NIVA, "white", 1980, 1150)); 
		Collection<Car> actual = dao.readCars();
		Assert.assertEquals(expected.size(), actual.size());
		for(Car car : expected) {
			Assert.assertTrue(actual.contains(car));
		}
	}

}
