package java_11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memo  extends JFrame{
	private JTextArea ta;
	private String filePath;
	public Memo(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenu mfile = new JMenu("파일");
		
		JMenuItem mOpen = new JMenuItem("열기");
		JMenuItem mNew = new JMenuItem("새파일");
		JMenuItem mSave = new JMenuItem("저장");
		JMenuItem mSaveAs = new JMenuItem("다른 이름으로 저장");
		JMenuItem mExit = new JMenuItem("끝내기");
		
		mfile.add(mOpen);
		mfile.add(mNew);
		mfile.add(mSave);
		mfile.add(mSaveAs);
		mfile.addSeparator(); // 선
		mfile.add(mExit);
		
		JMenuBar mb = new JMenuBar();
		mb.add(mfile);
		setJMenuBar(mb);//JFrame 에 mb 추가
		
		ta = new JTextArea();
		JScrollPane jsp = new JScrollPane(ta);
		add(jsp);
		//새파일
		mNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				setTitle("제목없음");
			}
		});
		
		//열기
		mOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if(fc.showOpenDialog(Memo.this) == JFileChooser.CANCEL_OPTION)
					return;
				File f = fc.getSelectedFile();
				filePath = f.getPath();
				setTitle(f.getName());
				fileRead(filePath);
			}
		});
		
		//저장
		mSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTitle().equals("제목없음")) {
//					JFileChooser fc = new JFileChooser();
//					if(fc.showSaveDialog(Memo.this)== JFileChooser.CANCEL_OPTION)
//						return;
//					File f = fc.getSelectedFile();
//					setTitle(f.getName());
//					filePath = f.getPath();
//					fileSave(filePath); //파일 저장 메소드
					mSaveAs.doClick();
				}else {
					fileSave(filePath); 
				}
			}
		});
		
		//다른 이름으로 저장
		mSaveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				if(fc.showSaveDialog(Memo.this)== JFileChooser.CANCEL_OPTION)
					return;
				File f = fc.getSelectedFile();
				fileSave(f.getPath()); //파일 저장 메소드
			}
		});
		
		//끝내기
		mExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			  System.exit(0);
			}
		});
		setSize(500, 400);
		setVisible(true);
	}
    private void fileSave(String fileName) { //파일저장
    	try {
			PrintStream ps =new PrintStream(fileName);
			ps.println(ta.getText());
			ps.close();
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		}
    }
	private void fileRead(String fileName) { //파일 읽기
		try {
			FileReader fr = new FileReader(fileName);
			StringWriter sw = new StringWriter();
			while(true) {
				int ch = fr.read(); //파일의 끝 -1
				if(ch == -1) break;
				sw.write(ch);
			}
			ta.setText(sw.toString());
			sw.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		  new Memo("제목없음");

	}

}