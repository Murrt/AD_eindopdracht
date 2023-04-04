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

import LL.Linked_List;
import DLL.Doubly_Linked_List;

public class gui implements ActionListener {
	private static TextField t1, t2;

	public static void addComponentsToPane(Container pane) {
		pane.setLayout(null);

		Doubly_Linked_List dLinked_List = new Doubly_Linked_List();
		Linked_List linkedlist = new Linked_List();

		String s1[] = { "Linked List", "Doubly Linked List" };
		JComboBox selectbox = new JComboBox(s1);
		JLabel selectbox_text = new JLabel("select your datastructure");
		JLabel result = new JLabel();
		JButton addValue = new JButton("Add");
		JButton searchValue = new JButton("Search");
		JButton sort_1 = new JButton("sort 1");
		JButton sort_2 = new JButton("sort 2");
		JLabel datastructure_result = new JLabel();
		JButton pButton = new JButton("Print");
		t1 = new TextField("enter value");
		t2 = new TextField("enter search value");

		pane.add(selectbox);
		pane.add(selectbox_text);
		pane.add(result);
		pane.add(t1);
		pane.add(t2);

		pane.add(addValue);
		pane.add(searchValue);
		pane.add(pButton);
		pane.add(sort_1);
		pane.add(sort_2);
		pane.add(datastructure_result);

		addValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(selectbox.getSelectedItem());
				String value = t1.getText();
				int value_int = Integer.parseInt(value);
				if (x == "Linked List") {
					linkedlist.add(value_int);
				} else if (x == "Doubly Linked List") {
					dLinked_List.add(value_int);
				}
			}
		});

		pButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(selectbox.getSelectedItem());
				if (x == "Linked List") {
					String res = linkedlist.print_nodes();
					datastructure_result.setText(res);
				} else if (x == "Doubly Linked List") {
					String res = dLinked_List.print_nodes();
					datastructure_result.setText(res);
				}
			}
		});

		sort_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(selectbox.getSelectedItem());
				if (x == "Linked List") {
					Linked_List sorted = linkedlist.insertionSort();
					String print = sorted.print_nodes();
					datastructure_result.setText(print);
				} else if (x == "Doubly Linked List") {
					Doubly_Linked_List sorted = dLinked_List.insertionSort();
					String print = sorted.print_nodes();
					datastructure_result.setText(print);
				}
			}
		});

		sort_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(selectbox.getSelectedItem());
				if (x == "Linked List") {
					linkedlist.simpleSort();
					String res = linkedlist.print_nodes();
					datastructure_result.setText(res);
				} else if (x == "Doubly Linked List") {
					dLinked_List.simpleSort();
					String res = dLinked_List.print_nodes();
					datastructure_result.setText(res);
				}
			}
		});

		searchValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(selectbox.getSelectedItem());
				String value = t2.getText();
				int value_int = Integer.parseInt(value);
				if (x == "Linked List") {
					try {
						Boolean res = linkedlist.simpleSearch(value_int);
						if (res) {
							datastructure_result.setText(value_int + " Gevonden!");
						} else {
							datastructure_result.setText(value_int + " Niet Gevonden!");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (x == "Doubly Linked List") {
					dLinked_List.simpleSort();
					String res = dLinked_List.print_nodes();
					datastructure_result.setText(res);
				}
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
		// size = selectButton.getPreferredSize();
		// selectButton.setBounds(25 + insets.left, 75 + insets.top,
		// size.width + 25, size.height + 25);
		// result

		// textfield
		t1.setBounds(25 + insets.left, 105 + insets.top,
				size.width + 150, size.height + 25);

		// textfield
		t2.setBounds(25 + insets.left, 205 + insets.top,
				size.width + 150, size.height + 25);
		// add value button

		addValue.setBounds(25 + insets.left, 75 + insets.top,
				size.width + 75, size.height + 25);

		// add value button
		searchValue.setBounds(25 + insets.left, 178 + insets.top,
				size.width + 75, size.height + 25);
		// print result
		size = pButton.getPreferredSize();
		pButton.setBounds(250 + insets.left, 25 + insets.top,
				size.width + 50, size.height + 25);
		// print result
		size = sort_1.getPreferredSize();
		sort_1.setBounds(450 + insets.left, 25 + insets.top,
				size.width + 50, size.height + 25);
		// print result
		size = sort_2.getPreferredSize();
		sort_2.setBounds(650 + insets.left, 25 + insets.top,
				size.width + 50, size.height + 25);

		// datastructure result
		datastructure_result.setBounds(250 + insets.left, 50 + insets.top,
				size.width + 200, size.height + 200);
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