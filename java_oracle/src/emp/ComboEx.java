package emp;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;

public class ComboEx extends JFrame {
	
	private EmpDAO empDao;
	private DeptDAO deptDao;
	private ArrayList<DeptDTO> deptList;
	private ArrayList<EmpDTO> empList;
	private JList list;
	
	public ComboEx() {
		JComboBox combo = new JComboBox();
		combo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int idx = combo.getSelectedIndex();
					if (idx != -1) {
						refreshList(idx);
					}
				}
			}
		});
		add(combo, BorderLayout.NORTH);
		
		empDao = new EmpDAO();
		deptDao = new DeptDAO();
		deptList = deptDao.listDept();
		empList = empDao.listEmp(0);
		
		list = new JList();
		
		for (DeptDTO dto : deptList) {
			combo.addItem(dto.getDname());
		}
		refreshList(0);
		add(list, BorderLayout.CENTER);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void refreshList(int idx) {
		int deptno = deptList.get(idx).getDeptno();
		empList = empDao.listEmp(deptno);
		String[] names = new String[empList.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = empList.get(i).getEname();
		}
		DefaultListModel<String> model = new DefaultListModel<>();
		for (String val : names) {
			model.addElement(val);
		}
		list.setModel(model);
	}
	
	public static void main(String[] args) {
		new ComboEx();
	}
}