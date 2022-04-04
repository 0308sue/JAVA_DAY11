package java_11;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class ThreadFinishFlagEx3 extends JFrame {
	private RandomThread th;
	public ThreadFinishFlagEx3() {
		setTitle("ThreadFinishFlagEx 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c =  getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			    th.finish();
			}
		});
			
		setSize(300, 200);
		setVisible(true);
		
		 th = new RandomThread(); //스레드 생성
		th.start();
		
	}

	public static void main(String[] args) {
		new ThreadFinishFlagEx3();

	}
	//내부클래스
	class RandomThread extends Thread{
		private boolean flag = false;
				
		public void finish() { //스레드 종료 시킬 메소드
			flag = true;
		}
		@Override
		public void run() {
			while(true) {
				int x =(int)(Math.random()*getContentPane().getWidth());
			    int y = (int)(Math.random()*getContentPane().getHeight());
			    JLabel label = new JLabel("java3");
			    label.setSize(80, 30);
			    label.setLocation(x, y);
			    getContentPane().add(label);
			    getContentPane().repaint();
			    try {
					Thread.sleep(300);
					if(flag == true) {
						getContentPane().removeAll();
						  label = new JLabel("finish3");
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
			}
		}
	}

}