package exampl;

import javax.swing.*;
import java.awt.*;

public class prog5 
{

	public static void main(String[] args) 
	{
	
		myFrame okno = new myFrame();
	}
}

class myFrame extends JFrame
{
	public myFrame()
	{
		myPanel np = new myPanel();
		
		Container cont = getContentPane();
		cont.add(np);
		setBounds(10, 10, 800, 600);
		setVisible(true);
	}
}

class myPanel extends JPanel
{
	public void paintComponent(Graphics gr)
	{
		for (int i=1; i<=10; i++)
		{
			gr.setColor(Color.CYAN);
			gr.fillRoundRect(i*60, i*60, 50, 50, i*10, i*10);
		}
	}
}