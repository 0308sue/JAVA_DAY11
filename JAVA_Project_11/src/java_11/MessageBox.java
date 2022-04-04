package java_11;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageBox  extends JFrame{
	public MessageBox(String title, String msg) {
		setTitle(title);
		setLayout(new FlowLayout());
		JButton closeBtn = new JButton("´Ý±â");
		add(new JLabel(msg));
		add(closeBtn);
		closeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		setSize(300, 100);
		setVisible(true);
	}

}

