package IrisRodriguez;

import org.testng.annotations.Test;

public class GroupingTestMethods {
	@Test(groups = { "Car" })
	public void sentra() {
		System.out.println("CAR 1: Sentra");
	}

	@Test(groups = { "Truck" })
	public void ford() {
		System.out.println("Ford Lobo");
	}

	@Test(groups = { "Car" })
	public void Jetta() {
		System.out.println("CAR 2: Jetta");
	}

}