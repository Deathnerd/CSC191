package example18;

import javax.swing.*;

/**
 * Created by Deathnerd on 4/17/2014.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

class DrawPanel extends JPanel{
	int num;

	DrawPanel(int n){
		super();
		num = n;
	}

	/*
	 * paintComponent is called when a DrawPanel object
	 * 1) is first displayed on the screen, or
	 * 2) is covered then uncovered by a window
	 * 3) the window in which it appears is resized
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();

		g.setColor(Color.RED);

//		g.drawLine(0, 0, width, height);
//		g.drawLine(0, height, width, 0);

		int numSegs = num;
		int stepW = width/numSegs;
		int stepH = height/numSegs;

		for(int i = 1; i< numSegs; i++){
			g.drawLine(0,0, stepW * i, height - stepH * i);
			g.drawLine(stepW * i, height - stepH * i, width, height);
		}

		for(int i = 1; i < numSegs; i++){
			g.drawLine(0, height, stepW*i, stepH * i);
			g.drawLine(stepW * i, stepH * i, width, 0);
		}

		g.setColor(Color.BLUE);
		g.drawString("Thanks!", width/2, height/2);
	}
}
public class example18 {
	public static void main(String[] args){
		JFrame application = new JFrame();

		//exit when closed
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		application.setSize(250,250);

		application.setVisible(true);

		application.setTitle("My graphics");

		DrawPanel panel = new DrawPanel(20);

		application.add(panel);
	}
}
