import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame implements ActionListener {
	JFrame fr = new JFrame();
	JTextField txt = new JTextField();
	JTextField txt2 = new JTextField();
	JButton btn = new JButton("Ohmuv zakon");
	JButton btn2 = new JButton("Prace");
	JPanel p = new JPanel();
	JPanel p2 = new JPanel();
	JFrame fr2 = new JFrame();
	JButton btn3 = new JButton("R=U/I");
	JButton btn4 = new JButton("U=R*I");
	JButton btn5 = new JButton("I=U/R");
	JLabel vysledek = new JLabel();

	public Frame() {
		fr.setSize(300, 300);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
		p2.add(btn);
		p2.add(btn2);
		fr.add(p2);
		fr.setLayout(new GridLayout(2, 1));
		p.setLayout(new GridLayout(1, 2));
		p2.setLayout(new GridLayout(1, 2));
		btn.addActionListener(this);
		btn2.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			fr2.setLocationRelativeTo(null);
			btn3.addActionListener(this);
			btn4.addActionListener(this);
			btn5.addActionListener(this);
			fr2.setSize(500, 500);
			fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr2.setVisible(true);
			p3.add(txt);
			p3.add(txt2);
			p4.add(btn3);
			p4.add(btn4);
			p4.add(btn5);
			p3.setLayout(new GridLayout(1, 2));
			p4.setLayout(new GridLayout(1, 3));
			fr2.setLayout(new GridLayout(3, 1));
			fr2.add(p3);
			fr2.add(p4);
			fr2.add(vysledek);
		}
		if (e.getSource() == btn3) {
			int U = Integer.parseInt(txt.getText());
			int I = Integer.parseInt(txt2.getText());
			int y = U / I;
			String x = "R = " + y;
			vysledek.setText(x);
		}
		if (e.getSource() == btn4) {
			int R = Integer.parseInt(txt.getText());
			int I = Integer.parseInt(txt2.getText());
			int y = R * I;
			String x = "U = " + y;
			vysledek.setText(x);
		}
		if (e.getSource() == btn5) {
			int U = Integer.parseInt(txt.getText());
			int R = Integer.parseInt(txt2.getText());
			int y = U / R;
			String x = "I = " + y;
			vysledek.setText(x);
		}

		if (e.getSource() == btn2) {
			JPanel p3 = new JPanel();
			JPanel p4 = new JPanel();
			fr2.setLocationRelativeTo(null);
			btn3.addActionListener(this);
			btn4.addActionListener(this);
			btn5.addActionListener(this);
			fr2.setSize(500, 500);
			fr2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fr2.setVisible(true);
			p3.add(txt);
			p3.add(txt2);
			p4.add(btn3);
			p4.add(btn4);
			p4.add(btn5);
			p3.setLayout(new GridLayout(1, 2));
			p4.setLayout(new GridLayout(1, 3));
			fr2.setLayout(new GridLayout(3, 1));
			fr2.add(p3);
			fr2.add(p4);
			fr2.add(vysledek);
		}
	}

	public static void main(String args[]) {
		new Frame();
	}
}
