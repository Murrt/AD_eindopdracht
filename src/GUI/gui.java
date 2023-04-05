package GUI;

import java.awt.Button;
import java.awt.Container;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.LinkedList;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import BT.Binary_Tree;
import BT.Node;
import LL.Linked_List;
import DLL.Doubly_Linked_List;

public class gui implements ActionListener {
	private static TextField addValueTextField, searchValueTextField;

	String s1[] = { "Linked List", "Doubly Linked List" };

	private static Doubly_Linked_List dlinkedlist = new Doubly_Linked_List();
	static Linked_List linkedlist = new Linked_List();
	private static Binary_Tree binary_Tree = new Binary_Tree();

	private static JButton selectDatastructuurButton = new JButton("Selecteer Datastructuur");
	private static ButtonGroup datastructureGroup = new ButtonGroup();

	private static JRadioButton rblinkedList = new JRadioButton("Linked List");
	private static JRadioButton rbdoublyLinkedList = new JRadioButton("Doubly Linked List");
	private static JRadioButton rbbinaryTree = new JRadioButton("Binary Tree");

	private static JLabel selectbox_text = new JLabel("select your datastructure");
	private static JLabel result = new JLabel();
	private static JButton addValue = new JButton("Add");
	private static JButton searchValue = new JButton("Search");
	private static JButton sort_1 = new JButton("sort 1");
	private static JButton sort_2 = new JButton("sort 2");
	private static JLabel datastructure_result = new JLabel();

	// BT Tree Traversel Buttons
	private static JRadioButton preOT = new JRadioButton("Pre Order Traversel");
	private static JRadioButton inOT = new JRadioButton("In Order Traversel");
	private static JRadioButton postOT = new JRadioButton("Post Order Traversel");
	private static ButtonGroup traverselGroup = new ButtonGroup();
	private static JButton btSortButton = new JButton("bt Sort");

	// BT Search Field & Button
	private JTextField btSearchField = new JTextField(25);
	private Container btSearchFieldContainer = new Container();
	private JLabel btSearchFieldLabel = new JLabel();

	private static JButton btSearchButton = new JButton("Search");

	// LL Buttons
	private static JRadioButton simpleSortLL = new JRadioButton("Simple sort");
	private static JRadioButton insertionSortLL = new JRadioButton("Insertion sort");
	private static JRadioButton fastSearchLL = new JRadioButton("Fast search");
	private static JRadioButton simpleSearchLL = new JRadioButton("Simple search");
	private static JButton llSortButton = new JButton("ll Sort");
	private static ButtonGroup llGroup = new ButtonGroup();

	// DLL Buttons
	private static JRadioButton simpleSortDLL = new JRadioButton("Simple sort");
	private static JRadioButton insertionSortDLL = new JRadioButton("Insertion sort");
	private static JRadioButton fastSearchDLL = new JRadioButton("Fast search");
	private static JRadioButton simpleSearchDLL = new JRadioButton("Simple search");
	private static JButton dllSortButton = new JButton("dll Sort");
	private static ButtonGroup dllGroup = new ButtonGroup();

	private static Linked_List sorted;
	private static Doubly_Linked_List sorted_2;

	public static void addComponentsToPane(Container pane) {

		pane.setLayout(null);

		// Datastructure radio button group
		pane.add(rblinkedList);
		pane.add(rbdoublyLinkedList);
		pane.add(rbbinaryTree);

		datastructureGroup.add(rblinkedList);
		datastructureGroup.add(rbdoublyLinkedList);
		datastructureGroup.add(rbbinaryTree);

		pane.add(selectDatastructuurButton);

		rblinkedList.setBounds(25, 25, 150, 20);
		rbdoublyLinkedList.setBounds(25, 50, 150, 20);
		rbbinaryTree.setBounds(25, 75, 150, 20);

		selectDatastructuurButton.setBounds(25, 100, 200, 20);

		// Linkedlist radio button group
		pane.add(simpleSortLL);
		pane.add(insertionSortLL);
		pane.add(fastSearchLL);
		pane.add(simpleSearchLL);

		llGroup.add(simpleSortLL);
		llGroup.add(insertionSortLL);
		llGroup.add(fastSearchLL);
		llGroup.add(simpleSearchLL);

		simpleSortLL.setVisible(false);
		insertionSortLL.setVisible(false);
		fastSearchLL.setVisible(false);
		simpleSearchLL.setVisible(false);

		// Doubly Linkedlist radio button group
		pane.add(simpleSortDLL);
		pane.add(insertionSortDLL);
		pane.add(fastSearchDLL);
		pane.add(simpleSearchDLL);

		dllGroup.add(simpleSortDLL);
		dllGroup.add(insertionSortDLL);
		dllGroup.add(fastSearchDLL);
		dllGroup.add(simpleSearchDLL);

		simpleSortDLL.setVisible(false);
		insertionSortDLL.setVisible(false);
		fastSearchDLL.setVisible(false);
		simpleSearchDLL.setVisible(false);

		addValueTextField = new TextField("enter value");
		searchValueTextField = new TextField("enter search value");

		pane.add(btSortButton);
		pane.add(llSortButton);
		pane.add(dllSortButton);

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
		pane.add(preOT);
		pane.add(inOT);
		pane.add(postOT);

		traverselGroup.add(preOT);
		traverselGroup.add(inOT);
		traverselGroup.add(postOT);

		preOT.setBounds(500, 25, 200, 20);
		inOT.setBounds(500, 50, 200, 20);
		postOT.setBounds(500, 75, 200, 20);

		// Binary Tree search field & button

		// Linked list sort buttons
		simpleSortLL.setBounds(500, 25, 200, 20);
		insertionSortLL.setBounds(500, 50, 200, 20);

		// Doubly Linked list sort buttons
		simpleSortDLL.setBounds(500, 25, 200, 20);
		insertionSortDLL.setBounds(500, 50, 200, 20);

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

		// Linked list Sort button
		llSortButton.setBounds(500, 125, 100, 20);

		// Doubly Linked List Sort button
		dllSortButton.setBounds(500, 125, 100, 20);

		selectDatastructuurButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rblinkedList.isSelected()) {
					setInvis();
					simpleSortLL.setVisible(true);
					insertionSortLL.setVisible(true);
					llSortButton.setVisible(true);

					llSortButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (simpleSortLL.isSelected()) {
								linkedlist.simpleSort();
								String res = linkedlist.print_nodes();
								datastructure_result.setText(res);
							} else if (insertionSortLL.isSelected()) {
								Linked_List sorted = linkedlist.insertionSort();
								linkedlist = sorted;
								String print = linkedlist.print_nodes();
								System.out.println(print);
							}
						}
					});

				} else if (rbdoublyLinkedList.isSelected()) {
					setInvis();
					simpleSortDLL.setVisible(true);
					insertionSortDLL.setVisible(true);
					dllSortButton.setVisible(true);

					dllSortButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (simpleSortDLL.isSelected()) {
								dlinkedlist.simpleSort();
								String res = dlinkedlist.print_nodes();
								datastructure_result.setText(res);
							} else if (insertionSortDLL.isSelected()) {
								sorted_2 = dlinkedlist.insertionSort();
								dlinkedlist = sorted_2;
								String print = dlinkedlist.print_nodes();
								datastructure_result.setText(print);
							}
						}
					});
				} else if (rbbinaryTree.isSelected()) {
					setInvis();
					preOT.setVisible(true);
					inOT.setVisible(true);
					postOT.setVisible(true);
					btSortButton.setVisible(true);

					btSortButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (preOT.isSelected()) {

								binary_Tree.preOrderTraversal(binary_Tree.root);

							} else if (inOT.isSelected()) {

								binary_Tree.inOrderTraversal(binary_Tree.root);

							} else if (postOT.isSelected()) {

								binary_Tree.postOrderTraversal(binary_Tree.root);

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
				dlinkedlist.add(value_int);
				binary_Tree.addNode(value_int);

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
		simpleSortLL.setVisible(false);
		insertionSortLL.setVisible(false);
		preOT.setVisible(false);
		inOT.setVisible(false);
		postOT.setVisible(false);
		btSortButton.setVisible(false);
		llSortButton.setVisible(false);
		dllSortButton.setVisible(false);
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