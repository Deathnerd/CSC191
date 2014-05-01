package Homework11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Project: Homework11
 * Package: Homework11
 * Class:   homework11
 * Created by George Gilleland at 8:05 PM on 4/25/14.
 */
class DrawPanel extends JPanel {
	Random rand;
	public int x;
	public int y;
	public int xVelocity;
	public int yVelocity;
	public int size;
	Color color;
	public long sleep;

	DrawPanel() {
		super();
		rand = new Random();
		size = 50;
		x = rand.nextInt(400) + 1;
		y = rand.nextInt(400) + 1;
		xVelocity = 10;
		yVelocity = 10;
		color = Color.BLUE;
		sleep = 100;
	}

	void randomColor() {
		color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
	}

	void changeVelocity(int step) {
		xVelocity += step;
		yVelocity += step;
	}

	void changeSpeed(int step) {
		sleep += step;
		if (sleep < 50)
			sleep = 50;
	}

	void changeSize(int step) {
		size += step;
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		int width = getWidth();
		int height = getHeight();

		graphics.setColor(color);

		//draw the ball
		graphics.fillOval(x, y, size, size);
	}

	public void move() {
		x += xVelocity;
		y += yVelocity;

		if (x > getWidth() - size) {
			x = getWidth() - size;
			xVelocity *= -1;
		}

		if (y > getHeight() - size) {
			y = getHeight() - size + 1;
			yVelocity *= -1;
		}

		if (x <= 0) {
			x = 0;
			xVelocity *= -1;
		}
		if (y <= 0) {
			y = 0;
			yVelocity *= -1;
		}
	}
}

public class homework11 extends JFrame implements ActionListener {
	//set up panels and buttons
	JPanel colorPanel = new JPanel();
	JButton colorButtons[] = new JButton[4];

	JPanel speedPanel = new JPanel();
	JButton speedButtons[] = new JButton[2];

	JPanel sizePanel = new JPanel();
	JButton sizeButtons[] = new JButton[2];

	public DrawPanel drawPanel = new DrawPanel();

	homework11() {
		setLayout(new BorderLayout(0, 0));

		//make buttons and their text and set the layout of their panel
		colorButtons[0] = new JButton("Red");
		colorButtons[1] = new JButton("Green");
		colorButtons[2] = new JButton("Blue");
		colorButtons[3] = new JButton("Random");
		colorPanel.setLayout(new GridLayout(colorButtons.length, 1));

		//add the buttons to the panel
		for (int i = 0; i < colorButtons.length; i++) {
			colorPanel.add(colorButtons[i]);
			colorButtons[i].addActionListener(this);
		}
		//add the panel to the window and set it to the west position
		add(colorPanel, BorderLayout.WEST);

		add(drawPanel, BorderLayout.CENTER);

		//make buttons and their text and set the layout of their panel
		speedButtons[0] = new JButton("Speed Up");
		speedButtons[1] = new JButton("Speed Down");
		speedPanel.setLayout(new GridLayout(1, speedButtons.length));

		//add the buttons to the panel
		for (int i = 0; i < speedButtons.length; i++) {
			speedPanel.add(speedButtons[i]);
			speedButtons[i].addActionListener(this);
		}
		//add the panel to the window and set it to the west position
		add(speedPanel, BorderLayout.NORTH);

		//make buttons and their text and set the layout of their panel
		sizeButtons[0] = new JButton("Increment Diameter");
		sizeButtons[1] = new JButton("Decrement Diameter");
		sizePanel.setLayout(new GridLayout(1, sizeButtons.length));

		//add the buttons to the panel
		for (int i = 0; i < sizeButtons.length; i++) {
			sizePanel.add(sizeButtons[i]);
			sizeButtons[i].addActionListener(this);
		}
		//add the panel to the window and set it to the west position
		add(sizePanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent event) {
		//handle button actions
		//size buttons
		for (int i = 0; i < sizeButtons.length; i++) {
			if (event.getSource() == sizeButtons[i]) {
				switch (i) {
					case 0:
						//increment
						drawPanel.changeSize(5);
						break;
					case 1:
						//decrement
						drawPanel.changeSize(-5);
						break;
				}
			}
		}
		//speed buttons
		for (int i = 0; i < speedButtons.length; i++) {
			if (event.getSource() == speedButtons[i]) {
				switch (i) {
					case 0:
						//speed up
//						drawPanel.changeVelocity(5);
						drawPanel.changeSpeed(-10);
						break;
					case 1:
						//slow down
//						drawPanel.changeVelocity(-5);
						drawPanel.changeSpeed(10);
						break;
				}
			}
		}
		//color buttons
		for (int i = 0; i < colorButtons.length; i++) {
			if (event.getSource() == colorButtons[i]) {
				switch (i) {
					case 0:
						//red
						drawPanel.color = Color.RED;
						break;
					case 1:
						//green
						drawPanel.color = Color.GREEN;
						break;
					case 2:
						//blue
						drawPanel.color = Color.BLUE;
						break;
					case 3:
						//random
						drawPanel.randomColor();
						break;
				}
			}
		}

	}

	public static void main(String args[]) {
		homework11 app = new homework11();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500, 500);
		app.setVisible(true);
		app.drawPanel.repaint();
		app.setTitle("Homework 11");

		while (true) {
			app.drawPanel.move();
			try {
				Thread.sleep(app.drawPanel.sleep);
			} catch (Exception e) {
				System.out.println("Process has insomnia");
			}

			app.repaint();
		}
	}
}