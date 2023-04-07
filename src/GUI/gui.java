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
	private static TextField addValueTextField;

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
	private static JLabel datastructure_time = new JLabel();

	// Sorting time completion label
	private static JLabel sortingTime_result = new JLabel();

	// BT Tree Traversel Buttons
	private static JRadioButton preOT = new JRadioButton("Pre Order Traversel");
	private static JRadioButton inOT = new JRadioButton("In Order Traversel");
	private static JRadioButton postOT = new JRadioButton("Post Order Traversel");
	private static ButtonGroup traverselGroup = new ButtonGroup();
	private static JButton btSortButton = new JButton("bt Sort");

	// BT Search Field & Button
	private static JTextField btSearchField = new JTextField(25);
	private static JLabel btSearchFieldLabel = new JLabel("Search Node:");

	private static JButton btSearchButton = new JButton("Search");
	private static JButton btSearchButton2 = new JButton("Search2");

	// BT Delete Field & Button
	private static JTextField btDeleteField = new JTextField(25);
	private static JLabel btDeleteFieldLabel = new JLabel("Delete number:");
	private static JButton btDeleteButton = new JButton("Delete");

	// LL Buttons
	private static JRadioButton simpleSortLL = new JRadioButton("Simple sort");
	private static JRadioButton insertionSortLL = new JRadioButton("Insertion sort");
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

		llGroup.add(simpleSortLL);
		llGroup.add(insertionSortLL);

		simpleSortLL.setVisible(false);
		insertionSortLL.setVisible(false);

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

		addValueTextField = new TextField("Number");

		pane.add(btSortButton);
		pane.add(llSortButton);
		pane.add(dllSortButton);

		pane.add(selectbox_text);
		pane.add(result);
		pane.add(addValueTextField);

		pane.add(addValue);
		pane.add(searchValue);
		pane.add(sort_1);
		pane.add(sort_2);
		pane.add(datastructure_result);
		pane.add(datastructure_time);

		pane.add(sortingTime_result);

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
		pane.add(btSearchField);
		pane.add(btSearchFieldLabel);
		pane.add(btSearchButton);
		pane.add(btSearchButton2);

		btSearchField.setBounds(825, 25, 100, 20);
		btSearchFieldLabel.setBounds(725, 25, 200, 20);
		btSearchButton.setBounds(825, 50, 100, 20);
		btSearchButton2.setBounds(825, 75, 100, 20);

		// Binary Tree search field & button
		pane.add(btDeleteField);
		pane.add(btDeleteFieldLabel);
		pane.add(btDeleteButton);

		btDeleteField.setBounds(825, 100, 100, 20);
		btDeleteFieldLabel.setBounds(725, 100, 200, 20);
		btDeleteButton.setBounds(825, 125, 100, 20);

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

		// datastructure result
		datastructure_result.setBounds(300, 200, 200, 50);
		datastructure_time.setBounds(300, 300, 200, 50);

		sortingTime_result.setBounds(350, 300, 400, 400);

		// Binary Tree Sort button
		btSortButton.setBounds(500, 125, 100, 20);

		// Linked list Sort button
		llSortButton.setBounds(500, 125, 100, 20);

		// Doubly Linked List Sort button
		dllSortButton.setBounds(500, 125, 100, 20);

		selectDatastructuurButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInvis();

				// search
				btSearchField.setVisible(true);
				btSearchButton.setVisible(true);
				btSearchFieldLabel.setVisible(true);
				// delete
				btDeleteField.setVisible(true);
				btDeleteButton.setVisible(true);
				btDeleteFieldLabel.setVisible(true);

				// add value
				addValue.setVisible(true);
				addValueTextField.setVisible(true);

				if (rblinkedList.isSelected()) {
					simpleSortLL.setVisible(true);
					insertionSortLL.setVisible(true);
					llSortButton.setVisible(true);
					btSearchButton2.setVisible(true);

					llSortButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (simpleSortLL.isSelected()) {
								linkedlist.simpleSort();
								String res = linkedlist.print_nodes();
								datastructure_result.setText(res);
							} else if (insertionSortLL.isSelected()) {
								sorted = linkedlist.insertionSort();
								linkedlist = sorted;
								String res = linkedlist.print_nodes();
								datastructure_result.setText(res);
							}
						}
					});

					btSearchButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = btSearchField.getText();
							int value_int = Integer.parseInt(value);
							Boolean res;
							try {
								res = linkedlist.simpleSearch(value_int);
								if (res) {
									datastructure_result.setText("Gevonden!");
								} else {
									datastructure_result.setText("Niet Gevonden");
									System.out.println("niet gevonden");
								}
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println();
							}
						}
					});

					btSearchButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = btSearchField.getText();
							int value_int = Integer.parseInt(value);
							Boolean res;
							try {
								res = linkedlist.fastSearch(value_int);
								if (res) {
									datastructure_result.setText("Gevonden!");
								} else {
									datastructure_result.setText("Niet Gevonden");
									System.out.println("niet gevonden");
								}
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println();
							}
						}
					});

					btDeleteButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = btDeleteField.getText();
							int value_int = Integer.parseInt(value);
							try {
								linkedlist.remove(value_int);
								linkedlist.print_nodes();
								String res = linkedlist.print_nodes();
								datastructure_result.setText(res);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});

				} else if (rbdoublyLinkedList.isSelected()) {
					simpleSortDLL.setVisible(true);
					insertionSortDLL.setVisible(true);
					dllSortButton.setVisible(true);
					btSearchButton2.setVisible(true);

					dllSortButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (simpleSortDLL.isSelected()) {
								dlinkedlist.simpleSort();
								String res = dlinkedlist.print_nodes();
								datastructure_result.setText(res);
							} else if (insertionSortDLL.isSelected()) {
								sorted_2 = dlinkedlist.insertionSort();
								dlinkedlist = sorted_2;
								String res = dlinkedlist.print_nodes();
								datastructure_result.setText(res);
							}
						}
					});

					btSearchButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = btSearchField.getText();
							int value_int = Integer.parseInt(value);
							Boolean res;
							long time;
							try {
								Object[] ret = dlinkedlist.simpleSearch(value_int);
								res = (Boolean) ret[0];
								time = (long) ret[1];
								if (res) {
									datastructure_result.setText("Gevonden!");
									datastructure_time.setText("Time: " + time);
								} else {
									datastructure_result.setText("Niet Gevonden");
									datastructure_time.setText("Time: " + time);
									System.out.println("niet gevonden");
								}
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println();
							}
						}
					});

					btSearchButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = btSearchField.getText();
							int value_int = Integer.parseInt(value);
							Boolean res;
							Integer time;
							try {
								Object[] ret = dlinkedlist.simpleSearch(value_int);
								res = (Boolean) ret[0];
								time = (Integer) ret[1];
								if (res) {
									datastructure_result.setText("Gevonden!");
								} else {
									datastructure_result.setText("Niet Gevonden");
									System.out.println("niet gevonden");
								}
							} catch (Exception e1) {
								e1.printStackTrace();
								System.out.println();
							}
						}
					});

					btDeleteButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = btDeleteField.getText();
							int value_int = Integer.parseInt(value);
							try {
								dlinkedlist.remove(value_int);
								dlinkedlist.print_nodes();
								String res = dlinkedlist.print_nodes();
								datastructure_result.setText(res);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
				} else if (rbbinaryTree.isSelected()) {
					preOT.setVisible(true);
					inOT.setVisible(true);
					postOT.setVisible(true);
					btSortButton.setVisible(true);

					btSortButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if (preOT.isSelected()) {

								binary_Tree.preOrderTraversal(binary_Tree.root);
								datastructure_result.setText(binary_Tree.toStringPreorder(binary_Tree.root));

							} else if (inOT.isSelected()) {

								binary_Tree.inOrderTraversal(binary_Tree.root);
								datastructure_result.setText(binary_Tree.toStringInorder(binary_Tree.root));

							} else if (postOT.isSelected()) {

								binary_Tree.postOrderTraversal(binary_Tree.root);
								datastructure_result.setText(binary_Tree.toStringPostOrder(binary_Tree.root));

							}
						}
					});
					btSearchButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = btSearchField.getText();
							int value_int = Integer.parseInt(value);

							datastructure_result.setText(binary_Tree.findNode(value_int));
						}
					});

					btDeleteButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String value = btDeleteField.getText();
							int value_int = Integer.parseInt(value);

							binary_Tree.removeNode(value_int);
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
		// Add field
		addValue.setVisible(false);
		addValueTextField.setVisible(false);

		// LL
		simpleSortLL.setVisible(false);
		insertionSortLL.setVisible(false);
		llSortButton.setVisible(false);
		// BT
		preOT.setVisible(false);
		inOT.setVisible(false);
		postOT.setVisible(false);
		btSortButton.setVisible(false);

		// DLL
		dllSortButton.setVisible(false);
		simpleSortDLL.setVisible(false);
		insertionSortDLL.setVisible(false);

		// Search/Delete field and buttons to the right
		btSearchField.setVisible(false);
		btSearchButton.setVisible(false);
		btSearchButton2.setVisible(false);
		btSearchFieldLabel.setVisible(false);
		btDeleteField.setVisible(false);
		btDeleteButton.setVisible(false);
		btDeleteFieldLabel.setVisible(false);
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