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
	private static TextField addValueTextField, searchValueTextField;

	String s1[] = { "Linked List", "Doubly Linked List" };

	private static Doubly_Linked_List dLinked_List = new Doubly_Linked_List();
	static Linked_List linkedlist = new Linked_List();
	private static Binary_Tree binary_Tree = new Binary_Tree();

	private static JButton datastructuurButton = new JButton("Selecteer Datastructuur");
	private static ButtonGroup datastructureGroup = new ButtonGroup();

	private static JRadioButton linkedList = new JRadioButton("Linked List");
	private static JRadioButton doublyLinkedList = new JRadioButton("Doubly Linked List");
	private static JRadioButton binaryTree = new JRadioButton("Binary Tree");

	private static JLabel selectbox_text = new JLabel("select your datastructure");
	private static JLabel result = new JLabel();
	private static JButton addValue = new JButton("Add");
	private static JButton searchValue = new JButton("Search");
	private static JButton sort_1 = new JButton("sort 1");
	private static JButton sort_2 = new JButton("sort 2");
	private static JLabel datastructure_result = new JLabel();

	// BT Buttons
	private static JRadioButton preOT = new JRadioButton("Pre Order Traversel");
	private static JRadioButton inOT = new JRadioButton("In Order Traversel");
	private static JRadioButton postOT = new JRadioButton("Post Order Traversel");

	private static JButton btSortButton = new JButton("Sort");
	private static JButton llSortButton = new JButton("Sort");

	private static ButtonGroup traverselGroup = new ButtonGroup();

	// LL Buttons
	private static JRadioButton simpleSort = new JRadioButton("Simple sort");
	private static JRadioButton insertionSort = new JRadioButton("Insertion sort");
	private static JRadioButton fastSearch = new JRadioButton("Fast search");
	private static JRadioButton simpleSearch = new JRadioButton("Simple search");
	private static JButton llButton = new JButton("Sort");

	private static ButtonGroup llGroup = new ButtonGroup();

	public static void addComponentsToPane(Container pane) {

		pane.setLayout(null);

		// Datastructure radio button group
		pane.add(linkedList);
		pane.add(doublyLinkedList);
		pane.add(binaryTree);

		datastructureGroup.add(linkedList);
		datastructureGroup.add(doublyLinkedList);
		datastructureGroup.add(binaryTree);

		pane.add(datastructuurButton);

		// Linkedlist radio button group

		pane.add(simpleSort);
		pane.add(insertionSort);
		pane.add(fastSearch);
		pane.add(simpleSearch);

		llGroup.add(simpleSort);
		llGroup.add(insertionSort);
		llGroup.add(fastSearch);
		llGroup.add(simpleSearch);

		pane.add(llButton);

		simpleSort.setVisible(false);
		insertionSort.setVisible(false);
		fastSearch.setVisible(false);
		simpleSearch.setVisible(false);

		//

		addValueTextField = new TextField("enter value");
		searchValueTextField = new TextField("enter search value");

		pane.add(preOT);
		pane.add(inOT);
		pane.add(postOT);

		traverselGroup.add(preOT);
		traverselGroup.add(inOT);
		traverselGroup.add(postOT);

		pane.add(btSortButton);
		pane.add(llSortButton);

		pane.add(selectbox_text);
		pane.add(result);
		pane.add(addValueTextField);
		pane.add(searchValueTextField);

		pane.add(addValue);
		pane.add(searchValue);
		pane.add(sort_1);
		pane.add(sort_2);
		pane.add(datastructure_result);

		// Tree Traversel Radio Buttons
		preOT.setBounds(500, 25, 200, 20);
		inOT.setBounds(500, 50, 200, 20);
		postOT.setBounds(500, 75, 200, 20);

		simpleSort.setBounds(500, 25, 200, 20);
		insertionSort.setBounds(500, 50, 200, 20);

		// Linked list sort buttons

		// Datastructure Radio Buttons
		linkedList.setBounds(25, 25, 150, 20);
		doublyLinkedList.setBounds(25, 50, 150, 20);
		binaryTree.setBounds(25, 75, 150, 20);

		datastructuurButton.setBounds(25, 125, 200, 20);

		// textfield
		addValueTextField.setBounds(25, 225, 150, 20);
		// add value button
		addValue.setBounds(25, 245, 120, 20);

		// textfield
		searchValueTextField.setBounds(25, 325, 150, 20);

		// add value button
		searchValue.setBounds(25, 345, 120, 20);

		// datastructure result
		datastructure_result.setBounds(300, 300, 400, 400);

		// Binary Tree Sort button
		btSortButton.setBounds(500, 125, 100, 20);

		// Binary Tree Sort button
		llSortButton.setBounds(500, 125, 100, 20);

		datastructuurButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (linkedList.isSelected()) {

					setInvis();
					simpleSort.setVisible(true);
					insertionSort.setVisible(true);
					llSortButton.setVisible(true);

					llSortButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (simpleSort.isSelected()) {
								linkedlist.simpleSort();
								String res = linkedlist.print_nodes();
								datastructure_result.setText(res);
							} else if (insertionSort.isSelected()) {
								dLinked_List.simpleSort();
								String res = dLinked_List.print_nodes();
								datastructure_result.setText(res);
							}
						}
					});

				} else if (doublyLinkedList.isSelected()) {

				} else if (binaryTree.isSelected()) {

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

				}
			}
		});

		addValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = addValueTextField.getText();
				int value_int = Integer.parseInt(value);

				// add to all datastructures
				linkedlist.add(value_int);
				dLinked_List.add(value_int);

				// print
				String res = linkedlist.print_nodes();
				datastructure_result.setText(res);
			}
		});

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
		setInvis();
		frame.setVisible(true);
	}

	private static void setInvis() {
		simpleSort.setVisible(false);
		insertionSort.setVisible(false);
		llSortButton.setVisible(true);
		preOT.setVisible(false);
		inOT.setVisible(false);
		postOT.setVisible(false);
		btSortButton.setVisible(false);
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