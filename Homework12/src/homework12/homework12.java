package homework12;

import javax.swing.*;
import javax.swing.border.Border;
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

	void sierpenski(Graphics graphics, int order, Point point1, Point point2, Point point3){
		if(order < 0)
			return;

		//setup midpoints
		Point midpointP12 = midpoint(point1, point2);
		Point midpointP23 = midpoint(point2, point3);
		Point midpointP31 = midpoint(point3, point1);

		//recursive calls
		sierpenski(graphics, --order, point1, midpointP12, midpointP31);
		sierpenski(graphics, --order, midpointP12, point2 , midpointP23);
		sierpenski(graphics, --order, midpointP31, midpointP23, point3);
	}

	//one-liner to calculate and return a midpoint Point
	Point midpoint(Point p1, Point p2){
		return new Point((p1.x + p2.x) / 2,(p1.y + p2.y) / 2);
	}

	//draw concurrent circles
	void drawCircles(int order, Graphics graphics, int size){
		if(order < 0)
			return;
		int x = getWidth() - size;
		int y = getHeight() - size;
		graphics.drawOval(x, y, size*2, size*2);
		drawCircles(--order, graphics, size+5);
	}
}
public class homework12  extends JFrame implements ActionListener{

	JPanel shapeButtonPanel;
	JButton shapeButtons[];

	JPanel orderPanel;
	JTextField orderText;
	JLabel label;

	DrawPanel drawPanel;

	int option;

	homework12(){
		option = 0;
		setLayout(new BorderLayout(0,0));

		//make the shape buttons
		shapeButtons = new JButton[2];
		shapeButtons[0] = new JButton("Co-centric circles");
		shapeButtons[1] = new JButton("Sierpenski Triangle");
		//make the shape button panel
		shapeButtonPanel = new JPanel();
		shapeButtonPanel.setLayout(new GridLayout(1, shapeButtons.length));
		add(shapeButtonPanel, BorderLayout.NORTH);
		//add the buttons and set up their listeners
		for(int i = 0; i < shapeButtons.length; i++){
			shapeButtonPanel.add(shapeButtons[i]);
			shapeButtons[i].addActionListener(this);
		}
		label = new JLabel("Enter an integer >= 0: ");
		orderText = new JTextField("0", 5);
		//make the order panel
		orderPanel = new JPanel();
		orderPanel.setLayout(new GridLayout(1,4));
		add(orderPanel, BorderLayout.SOUTH);
		orderPanel.add(label);
		orderPanel.add(orderText);
		orderText.addActionListener(this);
		//add the draw panel to the center
		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent event){
		//action logic goes here
		for(int i = 0; i < shapeButtons.length; i++){
			if(event.getSource() == shapeButtons[i]){
				drawPanel.option = i;
			}
		}

		if(event.getSource() == orderText){
			drawPanel.num = Integer.parseInt(orderText.getText());
		}

	}

	public static void main(String[] args){
		homework12 app = new homework12();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
		app.setTitle("Homework 12");
	}
}
