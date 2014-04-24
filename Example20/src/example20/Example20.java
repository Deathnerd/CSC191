package example20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Created by deathnerd on 4/24/14.
 */
class DrawPanel extends JPanel implements MouseListener, MouseMotionListener{
	Color backColor = Color.WHITE;
	Color drawColor = Color.BLUE;

	Point points[] = new Point[5000];
	int pointCount = 0;
	Point previousPoint;

	DrawPanel(){
		super();

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);

		setBackground(backColor);
		for(int i = 0; i < pointCount; i++){
			graphics.fillOval(points[i].x, points[i].y, 10,10);
		}
	}
	public void mousePressed(MouseEvent event){

	}

	public void mouseDragged(MouseEvent event){
		if(pointCount < points.length){
			points[pointCount] = event.getPoint();
			pointCount++;
			repaint();
		}
	}

	public void mouseReleased(MouseEvent event){

	}

	public void mouseClicked(MouseEvent event){

	}

	public void mouseEntered(MouseEvent event){
		Random rand = new Random();
		backColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

		repaint();
	}

	public void mouseExited(MouseEvent event){

	}

	public void mouseMoved(MouseEvent event){

	}
}
public class Example20 extends JFrame implements ActionListener{
	JPanel colorButtonPanel;
	JButton colorButtons[];

	DrawPanel drawPanel;
	Example20() {
		setLayout(new BorderLayout(30, 0));

		//add the draw panel to the center of the window
		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER);

		//make new color buttons and set their text
		colorButtons = new JButton[3];
		colorButtons[0] = new JButton("Red");
		colorButtons[1] = new JButton("Green");
		colorButtons[2] = new JButton("Blue");

		//make the color button panel to hold the color buttons
		colorButtonPanel = new JPanel();
		colorButtonPanel.setLayout(new GridLayout(1,3));

		//add color buttons to the color button panel and add event listeners to them
		for (int i = 0; i < colorButtons.length; i++) {
			colorButtonPanel.add(colorButtons[i]);
			colorButtons[i].addActionListener(this);
		}

		//add the color button panel to the window and set it to the south position
		add(colorButtonPanel, BorderLayout.NORTH);
	}

	public void actionPerformed(ActionEvent event){
	}

	public static void main(String[] args) {
		Example20 app = new Example20();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500, 500);
		app.setVisible(true);
		app.setTitle("Lab 14");
	}
}
