import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TrojuhelnikFrame implements ActionListener {
	JFrame frame = new JFrame();
	JButton btn = new JButton("Trojuhelnik");
	JTextField fa, fb, fc;
	JPanel panel1, panel2;
	JLabel faLabel, fbLabel, fcLabel;

	public TrojuhelnikFrame() {
		faLabel = new JLabel("Strana a");
		fbLabel = new JLabel("Strana b");
		fcLabel = new JLabel("Strana c");
		panel1 = new JPanel();
		panel2 = new JPanel();
		btn.addActionListener(this);
		fa = new JTextField(10);
		fb = new JTextField(10);
		fc = new JTextField(10);
		panel2.add(btn);
		panel1.add(faLabel);
		panel1.add(fa);
		panel1.add(fbLabel);
		panel1.add(fb);
		panel1.add(fcLabel);
		panel1.add(fc);
		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2, 1));
		frame.pack();
		frame.setVisible(true);
		frame.setSize(300, 300);
		panel1.setLayout(new GridLayout(3, 2));
		frame.add(panel1);
		frame.add(panel2);

	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btn) {
			try {
				String strA = fa.getText();
				String strB = fb.getText();
				String strC = fc.getText();
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);
				int c = Integer.parseInt(strC);
				Trojuhelnik t1 = Trojuhelnik.factoryTrojuhelnik(a, b, c);
				JOptionPane vypis = new JOptionPane();
				vypis.showMessageDialog(vypis, t1, "Hodnoty", JOptionPane.PLAIN_MESSAGE);
				vypis.setVisible(true);
				vypis.setSize(400, 100);
			} catch (StranaJeNulaException e1) {
				JOptionPane ErrWindow = new JOptionPane();
				ErrWindow.setVisible(true);
				ErrWindow.showMessageDialog(ErrWindow, "Jedna ze stran se rovna nule", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				ErrWindow.setSize(400, 100);
			} catch (NejdeSestrojitException e1) {
				JOptionPane ErrWindow = new JOptionPane();
				ErrWindow.setVisible(true);
				ErrWindow.showMessageDialog(ErrWindow, "Trojuhelnik nejde sestrojit", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				ErrWindow.setSize(400, 100);
			} catch (NevyhovujiciTrojuhelnikException e1) {
				JOptionPane ErrWindow = new JOptionPane();
				ErrWindow.setVisible(true);
				ErrWindow.showMessageDialog(ErrWindow, "Trojuhelnik neni ani rovnostranny ani rovnoramenny", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				ErrWindow.setSize(400, 100);
			}
		}

	}
}
