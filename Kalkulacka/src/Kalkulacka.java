import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import junit.framework.Test;

public class Kalkulacka implements ActionListener {
	JFrame fr = new JFrame("Kalkulacka");
	JPanel textfields = new JPanel();
	JPanel buttons = new JPanel();
	JPanel vysledky = new JPanel();
	JLabel vysledek = new JLabel();
	JButton button1 = new JButton("+");
	JButton button2 = new JButton("-");
	JButton button3 = new JButton("*");
	JButton button4 = new JButton("/");
	JButton button7 = new JButton("/ se zbytkem");
	JButton button5 = new JButton("x^y");
	JButton button6 = new JButton("x^(1/y)");
	JTextField textfield1 = new JTextField();
	JTextField textfield2 = new JTextField();
	
	public Kalkulacka() {
		modify();

	}

	private void modify() {
		textfields.setLayout(new GridLayout(1, 2));
		buttons.setLayout(new GridLayout(2, 3));
		button1.setPreferredSize(new Dimension(10, 10));
		button2.setBounds(20, 9, 20, 9);
		fr.setLayout(new GridLayout(3, 1));
		vysledek .setSize(500, 15);
		fr.pack();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setSize(300, 190);
		textfields.add(textfield1);
		textfields.add(textfield2);
		fr.add(textfields);
		fr.add(buttons);
		buttons.add(button1);
		buttons.add(button2);
		buttons.add(button3);
		buttons.add(button4);
		buttons.add(button5);
		buttons.add(button6);
		textfield1.setColumns(15);
		textfield2.setColumns(15);
		textfield1.setSize(20, 9);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		fr.add(vysledky);
		fr.setVisible(true);
		vysledky.add(vysledek);
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		vysledek.setText("");
		if (e.getSource() == button1) {
			double x = Double.parseDouble(textfield1.getText());
			double y = Double.parseDouble(textfield2.getText());
			double vys = x + y;
			vysledek.setText(Double.toString(vys));

		}
		if (e.getSource() == button2) {
			double x = Double.parseDouble(textfield1.getText());
			double y = Double.parseDouble(textfield2.getText());
			double vys = x - y;
			vysledek.setText(Double.toString(vys));

		}
		if (e.getSource() == button3) {
			double x = Double.parseDouble(textfield1.getText());
			double y = Double.parseDouble(textfield2.getText());
			double vys = x * y;
			vysledek.setText(Double.toString(vys));

		}
		if (e.getSource() == button4) {
			double x = Double.parseDouble(textfield1.getText());
			double y = Double.parseDouble(textfield2.getText());
			if(y==0) {
				vysledek.setText("nelze delit nulou!!!");
			}else {
			double vys = x / y;
			vysledek.setText(Double.toString(vys));
			}
		}
		if (e.getSource() == button5) {
			double x = Double.parseDouble(textfield1.getText());
			double y = Double.parseDouble(textfield2.getText());
			double vys = Math.pow(x, y);
			vysledek.setText(Double.toString(vys));

		}
		if (e.getSource() == button6) {
			double x = Double.parseDouble(textfield1.getText());
			double y = Double.parseDouble(textfield2.getText());
			if((x<0)&&(y%2==0)) {
				vysledek.setText("Sude odmocnina ze zaporneho cisla neexistuje");
			}else {
			double vys = Math.pow(x, 1/y);
			vysledek.setText(Double.toString(vys));
			}
		}
	}

	public static void main(String[] args) {
		Kalkulacka cl = new Kalkulacka();
	}

}
