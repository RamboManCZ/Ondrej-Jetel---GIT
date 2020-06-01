import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton registerBtn = new JButton("Registration");
	JButton addNewItemBtn = new JButton("Add new item");
	MainMenu() {
		frame.setSize(500,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		panel.add(registerBtn);
		panel.add(addNewItemBtn);
		panel.setLayout(new GridLayout(1,2));
		registerBtn.addActionListener(this);
		frame.add(panel);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registerBtn) {
			new Registration();
		}
		if(e.getSource()==addNewItemBtn) {
			
		}
	}
}