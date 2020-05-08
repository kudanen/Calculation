package test03;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JTextField;
import javax.xml.namespace.QName;

public class ButtonLIster implements ActionListener{

	JTextField showAreaField;
	String front,back,fuhao;//前一个数字，后一个数字，符号;
	double LastValue;
	String everywhereString,everywhereSureString;
	LinkedList<String> fuhaoSum = new LinkedList<String>();//符号集
	LinkedList<String> NumberSum = new LinkedList<String>();//数字集
	
	public ButtonLIster() {
		front="";back="";fuhao="";everywhereString="";everywhereSureString="";LastValue=0;
		fuhaoSum.add("+");fuhaoSum.add("-");fuhaoSum.add("*");fuhaoSum.add("/");
		for(int i=0;i<=9;i++) {
			NumberSum.add(i+"");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("=")) {
			if(front.isEmpty()||back.isEmpty()) {
				showAreaField.setText("error");
				return;
			}
			Calculating(fuhao);
			everywhereString=LastValue+"";
			showAreaField.setText(LastValue+"");
			front="";back="";fuhao="";
		}
		else if(fuhao.isEmpty() && NumberSum.contains(e.getActionCommand())) {
				front=front+e.getActionCommand();
				everywhereString=front;
				showAreaField.setText(front);
		}else if( fuhaoSum.contains(e.getActionCommand())) {
			if(!back.isEmpty()) {
				Calculating(fuhao);
				front=LastValue+"";
				back="";
			}
			fuhao=e.getActionCommand();
			showAreaField.setText(fuhao);
			
		}else if(NumberSum.contains(e.getActionCommand())&& !fuhao.isEmpty()) {
			back=back+e.getActionCommand();
			everywhereString=back;
			showAreaField.setText(back);
		}else {
			showAreaField.setText("error");
			return;
		}
	}
	public void Calculating(String s) {//计算ing
		if(s.equals("+")) {
			LastValue=Double.parseDouble(front)+Double.parseDouble(back);
		}else if(s.equals("-")) {
			LastValue=Double.parseDouble(front)-Double.parseDouble(back);
		}else if(s.equals("*")) {
			LastValue=Double.parseDouble(front)*Double.parseDouble(back);
		}else if(s.equals("/")) {
			LastValue=Double.parseDouble(front)/Double.parseDouble(back);
		}
	}
	public void setShowAreaField(JTextField showAreaField2) {
		// TODO Auto-generated method stub
		this.showAreaField=showAreaField2;
	}
	

}
