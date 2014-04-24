package Lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by deathnerd on 4/23/14.
 */
class DrawPanel extends JPanel {
	int option;
	int num;
	Color drawColor;

	DrawPanel() {
		super();
		option = 5;
		num = 0;
		drawColor = Color.BLACK;
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		int width = getWidth();
		int height = getHeight();

		graphics.setColor(drawColor);

		switch (option) {
			case 0:
				int stepVertical;
				int stepHorizontal;
				for (int i = 1; i <= num; i++) {
						stepVertical = (height / num);
						stepHorizontal = (width / num);
						graphics.drawLine(0, stepVertical * (i-1), stepHorizontal*i, height);
						graphics.drawLine(stepHorizontal * (i-1), height, width, height - stepVertical*i);
						graphics.drawLine(width, height - (stepVertical*i), width - (stepHorizontal*i), 0);
						graphics.drawLine(width - (stepHorizontal*i), 0, 0, stepVertical*i);
				}
				break;
			case 1:
				int circleWidth = 10;
				int step = 0;
				for (int i = 1; i <= num; i++) {
					step += circleWidth;
					graphics.drawOval(width / 2 - step, height / 2 - step, circleWidth * (i * 2), circleWidth * (i * 2));
				}
		}
	}
}

public class lab14 extends JFrame implements ActionListener {

	JPanel colorButtonPanel;
	JButton colorButtons[];

	JPanel selectionButtonPanel;
	JButton selectionButtons[];

	DrawPanel drawPanel;

	private int option;

	lab14() {
		setLayout(new BorderLayout(30, 0));

		//make selection buttons and set their text
		selectionButtons = new JButton[2];
		selectionButtons[0] = new JButton("Lines");
		selectionButtons[1] = new JButton("Cocentric Circles");

		//make the selection button panel to hold the selection buttons
		selectionButtonPanel = new JPanel();
		selectionButtonPanel.setLayout(new GridLayout(1, selectionButtons.length));

		//add selectionButtons to the selection button panel and add their event listeners
		for (int i = 0; i < selectionButtons.length; i++) {
			selectionButtonPanel.add(selectionButtons[i]);
			selectionButtons[i].addActionListener(this);
		}

		//add the selection button panel to the window and set it to the north position
		add(selectionButtonPanel, BorderLayout.NORTH);

		//add the draw panel to the center of the window
		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER);

		//make new color buttons and set their text
		colorButtons = new JButton[3];
		colorButtons[0] = new JButton("Black");
		colorButtons[1] = new JButton("Red");
		colorButtons[2] = new JButton("Blue");

		//make the color button panel to hold the color buttons
		colorButtonPanel = new JPanel();
		colorButtonPanel.setLayout(new FlowLayout());

		//add color buttons to the color button panel and add event listeners to them
		for (int i = 0; i < colorButtons.length; i++) {
			colorButtonPanel.add(colorButtons[i]);
			colorButtons[i].addActionListener(this);
		}

		//add the color button panel to the window and set it to the south position
		add(colorButtonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent event) {
		//selection buttons
		for (int i = 0; i < selectionButtons.length; i++) {
			if (event.getSource() == selectionButtons[i]) {
				option = i;
				drawPanel.option = option;
				if (option >= 0) {
					String input = JOptionPane.showInputDialog("Enter a positive integer");
					drawPanel.num = Integer.parseInt(input);
				}
				drawPanel.repaint();
				return;
			}
		}
		//color buttons
		for (int i = 0; i < colorButtons.length; i++) {
			if (event.getSource() == colorButtons[i]) {
				switch (i) {
					case 0:
						drawPanel.drawColor = Color.BLACK;
						break;
					case 1:
						drawPanel.drawColor = Color.RED;
						break;
					case 2:
						drawPanel.drawColor = Color.BLUE;
						break;
				}
				drawPanel.repaint();
				return;
			}
		}
	}

	public static void main(String[] args) {
		lab14 app = new lab14();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500, 500);
		app.setVisible(true);
		app.setTitle("Lab 14");
	}
}
