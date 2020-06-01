import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registration implements ActionListener {
	JFrame frame = new JFrame("Registration");
	JTextField txtUser = new JTextField();
	JPasswordField txtPass = new JPasswordField();;
	JButton btnRegistr = new JButton("Register");
	JLabel labelErr = new JLabel();
	JLabel password = new JLabel("password");
	JLabel username = new JLabel("username");
	JPanel panelTxtFields = new JPanel();
	JPanel panelButtons = new JPanel();
	JPanel panelLabel = new JPanel();

	public Registration() {
		modify();
		adder();
	}

	public void modify() {
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		txtPass.setColumns(15);
		txtUser.setColumns(15);

	}

	public void adder() {
		panelTxtFields.add(username);
		panelTxtFields.add(txtUser);
		panelTxtFields.add(password);
		panelTxtFields.add(txtPass);
		panelButtons.add(btnRegistr);
		panelLabel.add(labelErr);
		btnRegistr.addActionListener(this);
		frame.add(panelTxtFields);
		frame.add(panelButtons);
		frame.add(panelLabel);
		frame.setLayout(new GridLayout(3, 1));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistr) {
			registr();
		}
	}

	public void registr() {
		try {
			File f = new File("users\\" + txtUser.getText() + ".txt");
			if (f.exists() == true) {
				labelErr.setForeground(Color.RED);
				labelErr.setText("USERNAME ALREADY EXIST");
			} else {

				f.createNewFile();
				labelErr.setForeground(Color.GREEN);
				labelErr.setText("SUCCESFULL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new Registration();
	}

}