package test03;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class windowStrat extends JFrame{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	//设置导航栏
	JMenuBar menuBar;
	JMenu menu1,menu2,menu3;
	
	//设置textfiled
	JTextField showAreaField;
	
	//设置按钮
	JButton button[][];//很多个按钮
	
	//三个jpanel,1for showArea,2for forButton
	JPanel panel1,panel2;
	
	//监听Actiom
	ButtonLIster buttonLIster;
	
	public windowStrat() {
		init();
		this.setTitle("计算器");
		this.setLocationRelativeTo(null);
		setSize(500,500);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void init() {
		//监听初始化
		buttonLIster=new ButtonLIster();
		
		//设置全布局
		this.setLayout(new GridLayout(3,1));
		//对导航栏设置
		menu1=new JMenu("查看(v)");
		menu2=new JMenu("编辑(E)");
		menu3=new JMenu("帮助(H)");
		menuBar=new JMenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		
		//对textshow处理
		showAreaField=new JTextField(20);
		showAreaField.setSize(20,20);
		buttonLIster.setShowAreaField(showAreaField);//监听text
		panel1=new JPanel(new FlowLayout());
		panel1.add(showAreaField);
		
		//对按钮处理
		panel2=new JPanel(new GridLayout(6,5,6,6));
			//创建按钮+对按钮进行监听
		button=new JButton[6][5];
		for(int i=0;i<6;i++) {
			for(int j=0;j<5;j++) {
				button[i][j]=new JButton("空");
				button[i][j].addActionListener(buttonLIster);
			}
		}
			//为按钮命名
			button[0][0].setText("C");button[0][0].setActionCommand("C");
			button[0][1].setText("CE");button[0][0].setActionCommand("CE");
			button[0][2].setText("MS");button[0][0].setActionCommand("MS");
			button[0][3].setText("MC");button[0][0].setActionCommand("MC");
			button[0][4].setText("MR");button[0][0].setActionCommand("MR");
			
			//+-*/
			button[1][0].setText("+");button[0][0].setActionCommand("+");
			button[1][1].setText("-");button[0][0].setActionCommand("-");
			button[1][2].setText("*");button[0][0].setActionCommand("*");
			button[1][3].setText("/");button[0][0].setActionCommand("/");
			button[1][4].setText("=");button[0][0].setActionCommand("=");
			
			//1-9
			for(int i=0;i<5;i++) {
				button[2][i].setText((i)+"");
				button[2][i].setActionCommand((i)+"");
			}
			for(int i=0;i<5;i++) {
				button[3][i].setText((i+5)+"");
				button[3][i].setActionCommand((i+5)+"");
			}
			
		//把按钮加入到panel表格中
		for(int i=0;i<6;i++) {
			for(int j=0;j<5;j++) {
				panel2.add( button[i][j]);
			}
		}
		
		//把panel加入到jframe
		this.setJMenuBar(menuBar);//导航栏
		this.add(panel1);
		this.add(panel2);
		
	}
}
