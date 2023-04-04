package GUI;

import java.awt.Button;
import java.awt.Container;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import BT.Binary_Tree;
import BT.Node;
import LL.Linked_List;
import DLL.Doubly_Linked_List;

public class gui implements ActionListener {
	private static TextField t1;

	public static void addComponentsToPane(Container pane) {
		pane.setLayout(null);

		Doubly_Linked_List dLinked_List = new Doubly_Linked_List();
		Linked_List linkedlist = new Linked_List();
		Binary_Tree binary_Tree = new Binary_Tree();

		String s1[] = { "Linked List", "Doubly Linked List", "Binary Tree"};
		JComboBox selectbox = new JComboBox(s1);
		JLabel selectbox_text = new JLabel("select your datastructure");
		JLabel result = new JLabel();
		// JButton selectButton = new JButton("Select");
		JButton addValue = new JButton("Add");
		JLabel datastructure_result = new JLabel();
		JButton pButton = new JButton("Print");

		JRadioButton preOT = new JRadioButton("Pre Order Traversel");
		JRadioButton inOT = new JRadioButton("In Order Traversel");
		JRadioButton postOT = new JRadioButton("Post Order Traversel");

		JButton btSortButton = new JButton("Sort");


		t1 = new TextField("enter value");

		ButtonGroup traverselGroup = new ButtonGroup();

		pane.add(preOT);
		pane.add(inOT);
		pane.add(postOT);

		traverselGroup.add(preOT);
		traverselGroup.add(inOT);
		traverselGroup.add(postOT);

		pane.add(btSortButton);

		pane.add(selectbox);
		pane.add(selectbox_text);
		pane.add(result);
		pane.add(t1);
		pane.add(addValue);
		pane.add(pButton);
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
				} else if (x == "Binary Tree") {
					binary_Tree.addNode(value_int);
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
					// String res = dLinked_List.print_nodes();
					// datastructure_result.setText(res);
				} else if (x == "Binary Tree") {

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

		// Tree Traversel Radio Buttons
		preOT.setBounds(500,25,200,20);
		inOT.setBounds(500,50,200,20);
		postOT.setBounds(500,75,200,20);

		// Binary Tree Sort button
		btSortButton.setBounds(500,125,100,20);

		btSortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (preOT.isSelected()) {

					binary_Tree.preOrderTraversal(null);
					
				} else if (inOT.isSelected()) {

					binary_Tree.inOrderTraversal(null);

				} else if (postOT.isSelected()) {

					binary_Tree.postOrderTraversal(null);

				}
			}
		});

		// button
		// size = selectButton.getPreferredSize();
		// selectButton.setBounds(25 + insets.left, 75 + insets.top,
		// size.width + 25, size.height + 25);
		// result
		result.setBounds(25 + insets.left, 110 + insets.top,
				size.width + 100, size.height + 50);
		// textfield
		t1.setBounds(25 + insets.left, 175 + insets.top,
				size.width + 150, size.height + 25);
		// add value button
		size = addValue.getPreferredSize();
		addValue.setBounds(25 + insets.left, 75 + insets.top,
				size.width + 50, size.height + 25);

		// print result
		size = pButton.getPreferredSize();
		pButton.setBounds(250 + insets.left, 25 + insets.top,
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