import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Nahrazovac implements ActionListener {
	JFrame frame = new JFrame();
	JFrame fr;
	JLabel before, after, last, now;
	JPanel panel;
	JButton btn = new JButton("Change");
	JTextField tf = new JTextField();
	JTextField tf2 = new JTextField();
	JPanel p = new JPanel();
	JPanel p2 = new JPanel();

	public Nahrazovac() {
		modify();
		adder();
	}

	private void adder() {
		p.add(tf);
		p.add(tf2);
		p2.add(btn);
		frame.add(p);
		frame.add(p2);
		btn.addActionListener(this);
		panel.add(before);
		panel.add(after);
		panel.add(last);
		panel.add(now);
		fr.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			try {
				changer();
				timeWriter();
				fr.setVisible(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void timeWriter() throws FileNotFoundException, IOException {

		try {
			
			Date date = new Date();
			File f = new File("time.dat");

			ObjectInputStream timeinput = new ObjectInputStream(new FileInputStream(f));
			Object time = timeinput.readObject();
			ObjectOutputStream timeoutput = new ObjectOutputStream(new FileOutputStream(f));
			if (f.exists() == false) {
				f.createNewFile();
			}
			timeoutput.writeObject(date);
			timeoutput.writeObject(time);
			
			last.setText("Last start: " + time);
			now.setText("Now is: " + date);
		} catch (Exception e) {
			System.err.println("Chyba");
		}
	}

	private void changer() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("test.txt"));
		String x = in.readLine();
		x = x.replaceAll(tf.getText(), tf2.getText());
		BufferedWriter out = new BufferedWriter(new FileWriter("test.txt"));
		before.setText("Before: " + x);
		after.setText("After: " + x);
		out.write(x);
		in.close();
		out.close();
	}

	private void modify() {
		before = new JLabel();
		after = new JLabel();
		last = new JLabel();
		now = new JLabel();
		panel = new JPanel();
		fr = new JFrame("Output");
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(300, 300);
		panel.setLayout(new GridLayout(4, 1));
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(2, 1));
		tf.setColumns(15);
		tf2.setColumns(15);
		btn.setSize(5, 20);
	}

	public static void main(String[] args) {
		Nahrazovac f = new Nahrazovac();
	}
}