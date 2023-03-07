package src.GUI;

import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gui {
	public static void addComponentsToPane(Container pane) {
		pane.setLayout(null);

		String s1[] = { "Linked List", "Doubly Linked List" };
		JComboBox selectbox = new JComboBox(s1);
		JLabel selectbox_text = new JLabel("select your datastructure");
		JLabel result = new JLabel();
		JButton select = new JButton("Select");

		pane.add(selectbox);
		pane.add(selectbox_text);
		pane.add(result);
		pane.add(select);

		Insets insets = pane.getInsets();
		Dimension size = selectbox.getPreferredSize();
		selectbox.setBounds(25 + insets.left, 5 + insets.top,
				size.width, size.height);
		size = selectbox_text.getPreferredSize();
		selectbox_text.setBounds(55 + insets.left, 40 + insets.top,
				size.width, size.height);
		size = result.getPreferredSize();
		result.setBounds(150 + insets.left, 15 + insets.top,
				size.width + 50, size.height + 20);
		size = select.getPreferredSize();
		select.setBounds(250 + insets.left, 15 + insets.top,
				size.width + 50, size.height + 20);
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("GUI Algortimes en datastructuren");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set up the content pane.
		addComponentsToPane(frame.getContentPane());

		// Size and display the window.
		Insets insets = frame.getInsets();
		frame.setSize(500 + insets.left + insets.right,
				300 + insets.top + insets.bottom);
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
}