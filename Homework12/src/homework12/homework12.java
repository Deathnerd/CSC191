package homework12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project: Homework12
 * Package: homework12
 * Class:
 * Created by George Gilleland at 8:24 AM on 5/2/14.
 */

class DrawPanel extends JPanel {
	Color color;
	int option;  //which pane we're drawing
	int num; //number if iterations of the object to draw

	DrawPanel(){
		super();
		color = Color.BLACK;
		option = 0;
		num = 0;
	}

	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);

		int width = getWidth();
		int height = getHeight();

		//handle drawing the different options
		switch(option){
			case 0:
				//draw circles
				drawCircles(num, graphics, 10);
				break;
			case 1:
				//draw triangles
				break;
		}
	}

	void drawCircles(int order, Graphics graphics, int size){
		if(order < 0)
			return;
		int x = getWidth() - size;
		int y = getHeight() - size;
		graphics.drawOval(x, y, size, size);
		drawCircles(--order, graphics, size+5);
	}
}
public class homework12  extends JFrame implements ActionListener{

	JPanel shapeButtonPanel;
	JButton shapeButtons[];

	JPanel orderPanel;
	JTextField orderText;

	DrawPanel drawPanel;

	int option;

	homework12(){
		setLayout(new BorderLayout(0,0));

		//make the shape buttons
		shapeButtons = new JButton[2];
		shapeButtons[0] = new JButton("Co-centric circles");
		shapeButtons[1] = new JButton("Sierpenski Triangle");

		//make the
	}

	public void actionPerformed(ActionEvent event){

	}

	public static void main(String[] args){

	}
}
