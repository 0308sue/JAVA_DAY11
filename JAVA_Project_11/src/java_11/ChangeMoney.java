package java_11;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java_11.MessageBox;

public class ChangeMoney extends JFrame {
	private int[] unit = {50000,10000,1000,500,100,50,10,1};
	private String[] text= {"오만원","만원","천원","오백원","백원","50원","10원","1원"};
	private JTextField[] tf = new JTextField[8];
	private JCheckBox[] cb = new JCheckBox[7];
	
	public ChangeMoney() {
		setTitle("CHANGE MONEY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setBackground(Color.PINK);
		
		//금액
		JLabel la = new JLabel("금액");
		la.setSize(50, 20);
		la.setLocation(20, 20);
		add(la);
		//입력부분
		JTextField won = new JTextField(30);
		won.setSize(100, 20);
		won.setLocation(80, 20);
		add(won);
		//버튼
		JButton btn = new JButton("계산");
	    btn.setSize(70, 20);
	    btn.setLocation(200, 20);
	    btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int money =Integer.parseInt(won.getText()); //입력 돈
					for(int i = 0; i <text.length-1;i++) {
						if(cb[i].isSelected() ==false) { //체크박스 체크 안됨
							tf[i].setText("0");
							continue;
						}//if
						int result = money/unit[i];
						tf[i].setText(result+"");
						money= money % unit[i];
					} //for
					tf[text.length-1].setText(money+"");
				}catch (NumberFormatException n) {
					 new MessageBox("오류!!!", "숫자를 입력하세요");
				}
			}
		});
	    add(btn);
	    
	    //액수별  for
	    for(int i=0; i<text.length;i++) {
	    	//text 배열
	    	la = new JLabel(text[i]);
	    	la.setHorizontalAlignment(JLabel.RIGHT);
	    	la.setSize(50, 20);
	    	la.setLocation(50, 50+i*20);
	    	add(la);
	    	
	    	//JTextField
	    	 tf[i] = new JTextField();
	    	 tf[i].setEditable(false);
	    	 tf[i].setHorizontalAlignment(JTextField.RIGHT);
	    	tf[i].setSize(70, 20);
	    	tf[i].setLocation(120, 50+i*20);
	    	add(tf[i]);
	    	
	    	//체크박스
	    	if(i==text.length-1) break;
	    	cb[i] = new JCheckBox();
	    	cb[i].setBackground(Color.PINK);
	    	cb[i].setSelected(true);
	    	cb[i].setSize(30, 20);
	    	cb[i].setLocation(200, 50+i*20);
	    	cb[i].addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					 btn.setBackground(Color.CYAN);
					
				}
			});
	    	add(cb[i]);
	    	
	    }
	    
		setSize(300, 300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		 new ChangeMoney();
	}

}