package GUI;

import java.awt.Container;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gui implements ActionListener {
	private static TextField t1;

	public static void addComponentsToPane(Container pane) {
		pane.setLayout(null);

		String s1[] = { "Linked List", "Doubly Linked List" };
		JComboBox selectbox = new JComboBox(s1);
		JLabel selectbox_text = new JLabel("select your datastructure");
		JLabel result = new JLabel();
		JButton selectButton = new JButton("Select");

		t1 = new TextField("Welcome to Javatpoint.");

		pane.add(selectbox);
		pane.add(selectbox_text);
		pane.add(result);
		pane.add(selectButton);
		pane.add(t1);

		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(selectbox.getSelectedItem());
				result.setText(x);
			}
		});

		Insets insets = pane.getInsets();
		// selectbox
		Dimension size = selectbox.getPreferredSize();
		selectbox.setBounds(25 + insets.left, 25 + insets.top,
				size.width, size.height);
		// selectbox text
		size = selectbox_text.getPreferredSize();
		selectbox_text.setBounds(25 + insets.left, 5 + insets.top,
				size.width, size.height);
		size = result.getPreferredSize();

		// button
		size = selectButton.getPreferredSize();
		selectButton.setBounds(25 + insets.left, 75 + insets.top,
				size.width + 25, size.height + 25);
		// result
		result.setBounds(25 + insets.left, 110 + insets.top,
				size.width + 100, size.height + 50);

		// textfield
		result.setBounds(25 + insets.left, 130 + insets.top,
				size.width + 100, size.height + 50);
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("GUI Algortimes en datastructuren");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Size and display the window.
		Insets insets = frame.getInsets();
		frame.setSize(1000 + insets.left + insets.right,
				600 + insets.top + insets.bottom);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
	}
}