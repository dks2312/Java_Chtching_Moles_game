import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JavaCatchingMolesMain extends JFrame{
	static int score = 0;
	JLabel la;
	JButton[] moless;
	
	public JavaCatchingMolesMain()  {
		setTitle("자바버전 추억의 두더지 잡기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);

		gameInit(c);
				
		setSize(500, 300);
		setVisible(true);	
		setResizable(false);
		
		gameStart();
		
		gameEnd(c);	
	}

	private void gameEnd(Container c) {		
		la.setText("100점 축하드립니다!!");
		la.setSize(200, 50);
		la.setLocation(200, 0);
		c.add(la);
		
		for(int i = 0; i < moless.length; i++) {
			moless[i].setEnabled(true);
		}
	}

	private void gameStart() {
		while(score < 100) {
			int rand = (int)(Math.random()*moless.length);
			moless[rand].setEnabled(true);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			la.setText("score: "+ score);
			for(int i = 0; i < moless.length; i++) {
				moless[i].setEnabled(false);
			}		
		}
	}

	private void gameInit(Container c) {
		la = new JLabel("score: 0");
		la.setSize(100, 50);
		la.setLocation(200, 0);
		c.add(la);
		
		moless = new JButton[7]; 
		for(int i = 0; i < moless.length; i++) {
			ImageIcon img = new ImageIcon("images/moles.png");
			ImageIcon img1 = new ImageIcon("images/moles1.png");
			
			moless[i] = new JButton(img);
			moless[i].setSize(50, 80);
			moless[i].addMouseListener(new molesAction());
			moless[i].setPressedIcon(img1);
			c.add(moless[i]);
		}	
		
		moless[0].setLocation(50, 100);
		moless[1].setLocation(150, 100);
		moless[2].setLocation(250, 100);
		moless[3].setLocation(350, 100);
		moless[4].setLocation(100, 150);
		moless[5].setLocation(200, 150);
		moless[6].setLocation(300, 150);
	}
	
	private class molesAction extends MouseAdapter{
		public void mousePressed(MouseEvent e) {	
			JButton b = (JButton)e.getSource();
			if(b.isEnabled()) score+=10;
		}
		
		public void mouseReleased(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			b.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		new JavaCatchingMolesMain();
	}

}
