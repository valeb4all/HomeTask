package prog06;

import javax.imageio.*;
import java.io.*;
import java.security.PublicKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class class06 {

	public static void main(String[] args) {

		myFrame okno = new myFrame();
	}
}

class myFrame extends JFrame {
	public myFrame() {
		myPanel np = new myPanel();

		Container cont = getContentPane();
		cont.add(np);

		this.setBounds(10, 10, 600, 600);
		this.setVisible(true);

	}
}

class myPanel extends JPanel {

	private int x = 0, y = 0;
	private int napr = 2;
	private Image img;

	private class myKey implements KeyListener {

		public void keyPressed(KeyEvent e) {

			int key_ = e.getKeyCode();
			if (key_ == 37)
				napr = 0;
			if (key_ == 39)
				napr = 2;
			if (key_ == 38)
				napr = 1;
			if (key_ == 40)
				napr = 3;

		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	public myPanel() {

		addKeyListener(new myKey());
		setFocusable(true);

		Timer nt = new Timer(25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (napr == 0)
					x--;
				if (napr == 1)
					y--;
				if (napr == 2)
					x++;
				if (napr == 3)
					y++;

				repaint();
			}
		});

		nt.start();

		try {
			img = ImageIO.read(new File("C:\\1.png"));
		} catch (IOException exp) {
			JOptionPane.showMessageDialog(null, "Image not found!");
			System.exit(0);
		}
	}
	public void paintComponent(Graphics gr)
	{
		gr.setColor(Color.WHITE);
		gr.fillRect(0, 0, 1, 1);
		gr.clearRect(x -1, y -1, img.getWidth(null)+1, img.getHeight(null)+1);
		gr.drawImage(img, x, y, null);
	}
}