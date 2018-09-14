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
		this.manufacturer = model.getManufacturer();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + grossWeight;
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + productionYear;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (grossWeight != other.grossWeight)
			return false;
		if (manufacturer != other.manufacturer)
			return false;
		if (model != other.model)
			return false;
		if (productionYear != other.productionYear)
			return false;
		return true;
	}
	
	

}
