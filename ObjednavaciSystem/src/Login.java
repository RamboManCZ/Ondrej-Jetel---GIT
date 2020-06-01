import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
	JFrame frame = new JFrame("Login");
	JTextField usernameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JLabel userL = new JLabel("username");
	JLabel passL = new JLabel("password");
	JLabel error = new JLabel();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JButton login = new JButton("LOGIN");

	public Login() {
		frame.setLocationRelativeTo(null);
		frame.setSize(300, 150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		usernameField.setColumns(15);
		usernameField.setToolTipText("username");
		passwordField.setColumns(15);
		passwordField.setToolTipText("password");
		panel.add(userL);
		panel2.add(passL);
		panel.add(usernameField);
		panel2.add(passwordField);
		panel3.add(login);
		panel4.add(error);
		error.setHorizontalTextPosition(JLabel.CENTER);
		error.setForeground(Color.RED);
		login.setBackground(Color.GREEN);
		login.addActionListener(this);
		frame.add(panel);
		frame.add(panel2);
		frame.add(panel3);
		frame.setLayout(new GridLayout(3, 1));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login) {

			try {
				int x = 0;
				String user = usernameField.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				File f = new File("users\\" + user + ".txt");
				if (f.exists() == true) {
					@SuppressWarnings("resource")
					BufferedReader bfr = new BufferedReader(new FileReader(f));
					String password = bfr.readLine();
					if (pass.contentEquals(password)) {
						if (x != 1) {
							x = 1;
							frame.add(panel4);
							frame.setSize(300, 190);
							frame.setLayout(new GridLayout(4, 1));
						}
						error.setText("PRIHLASENI BYLO USPESNE");
						error.setForeground(Color.GREEN);
						new MainMenu();
					} else {
						if (x != 1) {
							frame.add(panel4);
							frame.setSize(300, 190);
							frame.setLayout(new GridLayout(4, 1));
							error.setText("NEPLATNE HESLO");
						}
						usernameField.setText("");
						passwordField.setText("");

					}
				} else {
					if (x != 1) {
						x = 1;
						frame.add(panel4);
						frame.setSize(300, 190);
						frame.setLayout(new GridLayout(4, 1));
					}
					error.setText("NEPLATNE UZIVATELSKE JMENO");
					usernameField.setText("");
					passwordField.setText("");
				}
			} catch (FileNotFoundException e1) {
			} catch (IOException e1) {
			} 
			}

		}
}
