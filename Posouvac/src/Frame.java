import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame implements ActionListener {
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JFrame frame = new JFrame();
	JButton right = new JButton("RIGHT");
	JButton left = new JButton("LEFT");
	JButton up = new JButton("UP");
	JButton down = new JButton("DOWN");
	private int x = 0;
	private int y = 0;

	public Frame() {
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		left.addActionListener(this);
		right.addActionListener(this);
		up.addActionListener(this);
		down.addActionListener(this);
		panel2.add(left);
		panel2.add(right);
		panel.add(up);
		panel3.add(down);
		frame.add(panel);
		frame.add(panel2);
		frame.add(panel3);
		frame.setLayout(new GridLayout(3, 1));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == left) {
			x = x - 10;
			frame.setLocation(x, y);
		}
		if (e.getSource() == right) {
			x = x + 10;
			frame.setLocation(x, y);
		}
		if (e.getSource() == up) {
			y = y - 10;
			frame.setLocation(x, y);
		}
		if (e.getSource() == down) {
			y = y + 10;
			frame.setLocation(x, y);
		}
	}

	public static void main(String[] args) {
		new Frame();
	}

}
