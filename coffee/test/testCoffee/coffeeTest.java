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
		assertEquals("��ӭʹ�ÿ����Զ��ۻ�����",cofMa.getText());
	}
	@Test
	public void testShowMessage()throws Exception{
		State noCoffee = null;
		CoffeeMachine cofMa;
		cofMa=CoffeeMachine.getInstance();
		cofMa.start();
		cofMa.showMessage("�����Ѿ�����������Ͷ�ң�");
		assertEquals("�����Ѿ�����������Ͷ�ң�",cofMa.getText());
	}
}
