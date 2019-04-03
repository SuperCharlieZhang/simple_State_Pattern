package coffee;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class CoffeeMachine extends JFrame{
	private static final long serialVersionUID = 1L;
	private static CoffeeMachine coffeeMachine;
	private   State  noCoin=new NoCoin();
	private   State  coinin=new Coinin();
	private   State  noCoffee=new NoCoffee();
	private static State currentState;
	private JButton button;
	private JTextField information;
	public  int coffeeNum=3;
	public static CoffeeMachine getInstance(){
		if (coffeeMachine==null){
			coffeeMachine=new CoffeeMachine();
		}
		return coffeeMachine;
	}
	private CoffeeMachine(){
		this.setSize(230, 150);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("咖啡机");
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		button=new JButton();
		button.addActionListener(new ButtonListener());
		add(button);
		String title = "投币insert coins";
		setButtonTitles(title);
		information = new JTextField("欢迎使用咖啡自动售货机！");
		information.setEnabled(false);
		information.setDisabledTextColor(Color.red);
		add(information);
		this.setVisible(true);
	}
	public void setButtonTitles(String title){
			button.setVisible(false);
	        button.setText(title);
			button.setVisible(true);
	}
	public void showMessage(String msg){
		information.setText(msg);
	}
	public String  getText(){
		return information.getText();
	}
	public void clearMessage(){
		information.setText("");
	}
	public int getCoffeeNum(){
		return coffeeNum;
	}
	public void setCoffeeNum(int coffeeNum){
		this.coffeeNum=coffeeNum;
	}
	public void onClick(){
		currentState.onClick();
	}
	public static void gotoState(State state){
		currentState=state;
		currentState.response();
	}
	public interface State{
		public void onClick();
		public void response();
	}
	class NoCoin implements State{
		@Override
		public void onClick() {
			// TODO Auto-generated method stub
			gotoState(coinin);
		}
		@Override
		public void response() {
			// TODO Auto-generated method stub
			String title = "投币insert coins";
			setButtonTitles(title);
			clearMessage();
			showMessage("欢迎使用咖啡自动售货机");
		}
	}
	class Coinin implements State{
		@Override
		public void onClick() {
			// TODO Auto-generated method stub
			int coffeeNum=getCoffeeNum();
			if(coffeeNum==0){
				gotoState(noCoffee);
			}else{
				gotoState(noCoin);
			}
		}
		@Override
		public void response() {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null,"咖啡正在烹制，请勿投币！");
			int coffeeNum=getCoffeeNum()-1;
			setCoffeeNum(coffeeNum);
			sleep();
			String title = "取走take it";
			setButtonTitles(title);
			clearMessage();
			showMessage("请取走咖啡，欢迎下次使用！");}
		}
		public void  sleep(){
			try{
				Thread.sleep(500);	
				}catch(Exception e){
					
				}
	}
	class NoCoffee implements State{

		@Override
		public void onClick() {
			// TODO Auto-generated method stub
			int n =JOptionPane.showConfirmDialog(null,"是否加料","加料确认",JOptionPane.YES_NO_OPTION);
			if(n== JOptionPane.YES_OPTION) {
				int coffeeNum=3;
				setCoffeeNum(coffeeNum);
				gotoState(noCoin);
			}else if(n== JOptionPane.NO_OPTION) {}
		       
		}
		@Override
		public void response() {
			// TODO Auto-generated method stub
			String title = "投币insert coins";
			setButtonTitles(title);
			clearMessage();
			showMessage("咖啡已经售罄，请勿投币！");
		}
	}
	public static void main(String args[]){
		CoffeeMachine cofMa;
		cofMa=CoffeeMachine.getInstance();
		cofMa.start();
	}
	public  void start(){
		CoffeeMachine cofMa;
		cofMa=CoffeeMachine.getInstance();
		gotoState(noCoin);
	}
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			onClick();			
		}
	}
}
