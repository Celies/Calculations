import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculationsTest {

	@Test
	void test() {
		Calculations cal = new Calculations();
		assertEquals((float) cal.CalculateInterception(196, -45, 100, 139, -312, 75, (float) 0.1815142422), 
			     (float) -1.0152637958526611);
		assertEquals((float) cal.CalculateInterception(369, -235, (float) 37.5, 139, -376, 75, (float) 0.1815142422), 
				-1.787370204925537);
	}

}
