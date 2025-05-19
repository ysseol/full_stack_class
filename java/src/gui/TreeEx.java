package gui;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class TreeEx extends JFrame {

	private Object[] obj = {"프로그램", "시스템", "디자인"};
	private Vector<Vector> node1 = new Vector<Vector>() {
		public String toString() {
			return "Lesson";
		}
	};
	private Vector<String> node2 = new Vector<String>() {
		public String toString() {
			return "Java";
		}
	};
	private Vector<String> node3 = new Vector<String>() {
		public String toString() {
			return "XML";
		}
	};
	
	public TreeEx() {
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		node1.add(node2);
		node1.add(node3);
		node2.add("C++");
		node2.add("Java");
		node2.add("JSP");
		node3.add("XSLT");
		node3.add("DOM");
		obj[0] = node1;
		JTree tree = new JTree(obj);
		tree.setRootVisible(true);
		
		scrollPane.setViewportView(tree);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new TreeEx();
	}
}
