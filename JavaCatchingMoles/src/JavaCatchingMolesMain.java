import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JavaCatchingMolesMain extends JFrame{
	static int score = 0;
	JLabel la = new JLabel("score:0");
	
	public JavaCatchingMolesMain()  {
		setTitle("자바버전 추억의 두더지 잡기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container c = getContentPane();
		c.setLayout(null);
		

		la.setSize(100, 50);
		la.setLocation(200, 0);
		c.add(la);
		
		JButton[] moless = new JButton[7]; 
		for(int i = 0; i < moless.length; i++) {
			ImageIcon img = new ImageIcon("images/moles.png");
			ImageIcon img1 = new ImageIcon("images/moles1.png");
			
			moless[i] = new JButton(img);
			moless[i].setSize(50, 80);
			moless[i].addMouseListener(new addScore());
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
				
		setSize(500, 300);
		setVisible(true);	
		setResizable(false);
		
		while(score < 100) {
			int rand = (int)(Math.random()*moless.length);
			moless[rand].setEnabled(true);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < moless.length; i++) {
				moless[i].setEnabled(false);
			}		
		}
		
		la = new JLabel("100점 축하합니다!!!");
		la.setSize(100, 50);
		la.setLocation(200, 0);
		c.add(la);
		
		for(int i = 0; i < moless.length; i++) {
			moless[i].setEnabled(true);
		}	
	}
	
	private class addScore extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			JButton b = (JButton)e.getSource();
			
			if(!b.isEnabled()) return;
			
			score+=10;
			la.setText("score: "+ score);
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
