package hu.uni.miskolc.iit.swtest.car.core.model;



import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
	
	private static final String SWIFT_COLOR = "green";
	
	private Car car;
	
	@Before
	public void setUp() {
		try {
			this.car = new Car(CarModel.SWIFT, SWIFT_COLOR, 2000, 750);
		} catch (InvalidProductionYearException e) {
			Assume.assumeNoException(e);
		}
	}
	
	@Test
	public void testManfucturerWithSuzukiSwift() {
		Manufacturer expected = Manufacturer.Suzuki;
		Manufacturer actual = car.getManufacturer();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testModelWithSuzukiSwift(){
		CarModel expected = CarModel.SWIFT;
		CarModel actual = car.getModel();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testColorWithSuzukiSwift() {
		String expected = SWIFT_COLOR;
		String actual = car.getColor();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testProductionYearWithSuzukiSwift() {
		int expected = 2000;
		int actual = car.getProductionYear();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testGrossWeigthWithSuzukiSwift() {
		int expected = 750;
		int actual = car.getGrossWeight();
		Assert.assertEquals(expected, actual);
	}
	
	@Test(expected=InvalidProductionYearException.class)
	public void testInvalidProductionYear() throws InvalidProductionYearException {
		Car car = new Car(CarModel.SWIFT, "green", 0, 750);
	}

}
