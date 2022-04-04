package java_11;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class ThreadFinishFlagEx2 extends JFrame  implements Runnable{
	private boolean flag = false;
	
	public ThreadFinishFlagEx2() {
		setTitle("ThreadFinishFlagEx2 ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c =  getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			   finish();
			}
		});
			
		setSize(300, 200);
		setVisible(true);
		
	  new Thread(this).start();
		
	}
		public void finish() {
			flag = true;
		}
		@Override
	public void run() {
			while(true) {
				int x =(int)(Math.random()*getContentPane().getWidth());
			    int y = (int)(Math.random()*getContentPane().getHeight());
			    JLabel label = new JLabel("thread");
			    label.setSize(80, 30);
			    label.setLocation(x, y);
			    add(label);
			    getContentPane().repaint();
			    try {
					Thread.sleep(300);
					if(flag == true) {
						getContentPane().removeAll();
						  label = new JLabel("threadfinish");
						  label.setSize(80, 30);
						  label.setLocation(100, 100);
						  label.setForeground(Color.RED);
						  getContentPane().add(label);
						  getContentPane().repaint();
						  return;
				   }
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//while
			
		}
		
		
	public static void main(String[] args) {
		new ThreadFinishFlagEx2();
	}
}



