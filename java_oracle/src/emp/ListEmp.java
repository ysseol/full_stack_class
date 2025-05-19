package emp;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListEmp extends JFrame {

	private JTable table;
	private Vector data, cols;
	private EmpDAO empDao;
	private DeptDAO deptDao;
	
	public ListEmp() {
		setLayout(null);
		
		JComboBox cboDept = new JComboBox();
		cboDept.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String dname = cboDept.getSelectedItem().toString();
					DefaultTableModel model = new DefaultTableModel(empDao.listEmp(dname), cols);
					table.setModel(model);
				}
			}
		});
		cboDept.setBounds(12, 10, 100, 23);
		add(cboDept);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 55, 389, 256);
		add(scrollPane);
		
		cols = new Vector();
		cols.add("사원번호");
		cols.add("사원이름");
		cols.add("직급");
		cols.add("입사일자");
		cols.add("급여");
		cols.add("소속부서");
		empDao = new EmpDAO();
		DefaultTableModel model = new DefaultTableModel(empDao.listEmp("%"),cols);
		
		table = new JTable(model);
		
		scrollPane.setViewportView(table);
		
		deptDao = new DeptDAO();
		ArrayList<DeptDTO> deptList = deptDao.listDept();
		cboDept.addItem("전체부서");
		for (DeptDTO dto : deptList) {
			cboDept.addItem(dto.getDname());
		}
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ListEmp();
	}
}
