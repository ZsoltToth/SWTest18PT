package hu.uni.miskolc.iit.swtest.car.core.model;

public class Car {

	private Manufacturer manufacturer;
	private CarModel model;
	private String color;
	private int productionYear;
	private int grossWeight;

	public Car(CarModel model, String color, int productionYear, int grossWeight) throws InvalidProductionYearException{
		super();
		if(productionYear < 1900) {
			throw new InvalidProductionYearException();
		}
		this.model = model;
		this.color = color;
		this.productionYear = productionYear;
		this.grossWeight = grossWeight;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public CarModel getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public int getGrossWeight() {
		return grossWeight;
	}

}
