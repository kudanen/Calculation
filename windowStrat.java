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
	//���õ�����
	JMenuBar menuBar;
	JMenu menu1,menu2,menu3;
	
	//����textfiled
	JTextField showAreaField;
	
	//���ð�ť
	JButton button[][];//�ܶ����ť
	
	//����jpanel,1for showArea,2for forButton
	JPanel panel1,panel2;
	
	//����Actiom
	ButtonLIster buttonLIster;
	
	public windowStrat() {
		init();
		this.setTitle("������");
		this.setLocationRelativeTo(null);
		setSize(500,500);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void init() {
		//������ʼ��
		buttonLIster=new ButtonLIster();
		
		//����ȫ����
		this.setLayout(new GridLayout(3,1));
		//�Ե���������
		menu1=new JMenu("�鿴(v)");
		menu2=new JMenu("�༭(E)");
		menu3=new JMenu("����(H)");
		menuBar=new JMenuBar();
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);
		
		//��textshow����
		showAreaField=new JTextField(20);
		showAreaField.setSize(20,20);
		buttonLIster.setShowAreaField(showAreaField);//����text
		panel1=new JPanel(new FlowLayout());
		panel1.add(showAreaField);
		
		//�԰�ť����
		panel2=new JPanel(new GridLayout(6,5,6,6));
			//������ť+�԰�ť���м���
		button=new JButton[6][5];
		for(int i=0;i<6;i++) {
			for(int j=0;j<5;j++) {
				button[i][j]=new JButton("��");
				button[i][j].addActionListener(buttonLIster);
			}
		}
			//Ϊ��ť����
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
			
		//�Ѱ�ť���뵽panel�����
		for(int i=0;i<6;i++) {
			for(int j=0;j<5;j++) {
				panel2.add( button[i][j]);
			}
		}
		
		//��panel���뵽jframe
		this.setJMenuBar(menuBar);//������
		this.add(panel1);
		this.add(panel2);
		
	}
}
