package example19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by deathnerd on 4/22/14.
 */
class DrawPanel extends JPanel{
	int option;
	int num;
	Color drawColor;

	DrawPanel(){
		super();
		option = 0;
		num = 0;
		drawColor = Color.BLACK;
	}

	public void paintComponent(Graphics graphics){
		super.paintComponent(graphics);

		int width = getWidth();
		int height = getHeight();

		graphics.setColor(drawColor);

		switch(option){
			case 1:
				graphics.drawString("Welcome to my GUI Application", width/4, height/4);
				break;
			case 2:
				for(int i = 1; i <= num; i++){
					graphics.fillRect(10+i*10, 10+i*10, 50+5*i, 50+5*i);
				}
				break;
			case 3:
				for(int i = 1; i <= num; i++){
					graphics.drawOval(10+i*10, 10+i*10, 50+8*i, 50+8*i);
				}
				break;
		}
	}

}
public class Example19 extends JFrame implements ActionListener{

	JPanel shapeButtonPanel;
	JButton shapeButtons[];

	DrawPanel drawPanel;

	JPanel colorButtonPanel;
	JButton colorButtons[];

	private int option;	//1: text, 2: rectangles, 3: ovals
	Example19(){
		setLayout(new BorderLayout(5, 10));

		shapeButtons = new JButton[3];
		shapeButtons[0] = new JButton("Welcome");
		shapeButtons[1] = new JButton("Rectangles");
		shapeButtons[2] = new JButton("Ovals");

		shapeButtonPanel = new JPanel();
		shapeButtonPanel.setLayout(new GridLayout(1, shapeButtons.length));

		for(int i = 0; i < shapeButtons.length; i++){
			shapeButtonPanel.add(shapeButtons[i]);
			shapeButtons[i].addActionListener(this);
		}

		add(shapeButtonPanel, BorderLayout.NORTH);

		drawPanel = new DrawPanel();
		add(drawPanel, BorderLayout.CENTER);

		colorButtons = new JButton[2];
		colorButtons[0] = new JButton("Red");
		colorButtons[1] = new JButton("Black");

		colorButtonPanel = new JPanel();
		colorButtonPanel.setLayout(new FlowLayout());

		for(int i = 0; i < colorButtons.length; i++){
			colorButtonPanel.add(colorButtons[i]);
			colorButtons[i].addActionListener(this);
		}

		add(colorButtonPanel, BorderLayout.SOUTH);

	}

	// actionPerformed is declared in interface ActionListener and needs to be implemented since ActionListener is an abstract
	public void actionPerformed(ActionEvent event){
		//shape buttons
		for(int i = 0; i < shapeButtons.length; i++){
			if(event.getSource() == shapeButtons[i]){
				option = i+1;
				drawPanel.option = option;
				if(option > 1){
					String input = JOptionPane.showInputDialog("Enter a positive integer: ");
					drawPanel.num = Integer.parseInt(input);
				}
				drawPanel.repaint();
				return;
			}
		}
		//color buttons
		for(int i = 0; i < colorButtons.length; i++){
			if(event.getSource() == colorButtons[i]){
				if(i == 0){
					drawPanel.drawColor = Color.RED;
				} else {
					drawPanel.drawColor = Color.BLACK;
				}
				drawPanel.repaint();
				return;
			}
		}
	}

	public static void main (String[] args){
		Example19 app = new Example19();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(450,450);
		app.setVisible(true);
		app.setTitle("My Graphics");
	}
}
