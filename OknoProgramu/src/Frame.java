import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import accountgenerator.AccountGeneratorFrame;


public class Frame implements ActionListener {
	// PODLE PROGRAMATORSKEHO DENIKU MA MIT PROGRAM MNOHEM VICE RADKU,
	// TAKY JICH TOLIK MEL, ALE JA JSEM TO NAKONEC PREDELAL TAK ZE JENOM IMPORTUJU
	// PROJEKTY (JE TO EFEKTIVNEJSI)
	JFrame fr = new JFrame();
	JButton btnNahrazovac = new JButton("Nahrazovac");
	JButton btnKalkulacka = new JButton("Kalkulacka");
	JButton btnAccountGenerator = new JButton("Account Generator");
	JButton btnTriangle = new JButton("Triangle");
	JPanel panel = new JPanel();

	public Frame() {
		modify();
		adder();
	}

	private void adder() {
		panel.add(btnKalkulacka);
		panel.add(btnNahrazovac);
		panel.add(btnAccountGenerator);
		panel.add(btnTriangle);
		btnTriangle.addActionListener(this);
		btnAccountGenerator.addActionListener(this);
		btnKalkulacka.addActionListener(this);
		btnNahrazovac.addActionListener(this);
		fr.add(panel);
	}

	private void modify() {
		fr.setSize(300, 200);
		fr.setLayout(new GridLayout(1, 2));
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnKalkulacka) {
			new Kalkulacka();
		}
		if (e.getSource() == btnNahrazovac) {
			new Nahrazovac();
		}
		if(e.getSource() == btnAccountGenerator) {
			new AccountGeneratorFrame();
		}
		if(e.getSource() == btnTriangle) {
			new TrojuhelnikFrame();		}
	}

	public static void main(String[] args) {
		new Frame();
	}
}
