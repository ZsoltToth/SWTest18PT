package hu.uni.miskolc.iit.swtest.car.core.model;

public enum CarModel {
	SWIFT(Manufacturer.Suzuki),
	NIVA(Manufacturer.Lada);
	
	
	private final Manufacturer manufacturer;
	
	private CarModel(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	
}
