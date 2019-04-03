package testCoffee;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import coffee.CoffeeMachine;
import coffee.CoffeeMachine.State;

public class coffeeTest {
	@Test
	public void testBuild ()throws Exception{
		CoffeeMachine cofMa;
		cofMa=CoffeeMachine.getInstance();
		cofMa.start();
	}
	@Test
	public void testState() throws Exception{
		CoffeeMachine cofMa;
		cofMa=CoffeeMachine.getInstance();
		cofMa.start();
		assertEquals("欢迎使用咖啡自动售货机！",cofMa.getText());
	}
	@Test
	public void testShowMessage()throws Exception{
		State noCoffee = null;
		CoffeeMachine cofMa;
		cofMa=CoffeeMachine.getInstance();
		cofMa.start();
		cofMa.showMessage("咖啡已经售罄，请勿投币！");
		assertEquals("咖啡已经售罄，请勿投币！",cofMa.getText());
	}
}
