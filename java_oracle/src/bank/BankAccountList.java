package bank;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BankAccountList extends JFrame {

	private JTable table;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private BankAccountDAO dao;
	private Vector cols;
	private int idx = -1;
	
	public BankAccountList() {
		setTitle("계좌관리");
		
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 560, 194);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idx = table.getSelectedRow();
			}
		});
		scrollPane.setViewportView(table);
		
		dao = new BankAccountDAO();
		cols = new Vector();
		cols.add("은행명");
		cols.add("예금주");
		cols.add("계좌번호");
		cols.add("잔액");
		refreshTable();
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankAccountAdd Addform = new BankAccountAdd(BankAccountList.this);
				Addform.setVisible(true);
				Addform.setLocation(BankAccountList.this.getX(), BankAccountList.this.getY() + 400);
			}
		});
		btnAdd.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnAdd.setBounds(90, 214, 97, 23);
		add(btnAdd);
		
		btnEdit = new JButton("수정");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idx == -1) {
					JOptionPane.showMessageDialog(BankAccountList.this, "수정할 자료를 선택하세요.");
				} else {
					String bank = table.getValueAt(idx, 0) + "";
					String name = table.getValueAt(idx, 1) + "";
					String num = table.getValueAt(idx, 2) + "";
					int money = Integer.parseInt(table.getValueAt(idx, 3) + "");
					
					BankAccountEdit Editform = new BankAccountEdit(BankAccountList.this, bank, name, num, money);
					Editform.setVisible(true);
					Editform.setLocation(BankAccountList.this.getX(), BankAccountList.this.getY() + 400);
					idx = -1;
				}
			}
		});
		btnEdit.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnEdit.setBounds(243, 214, 97, 23);
		add(btnEdit);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idx == -1) {
					JOptionPane.showMessageDialog(BankAccountList.this, "삭제할 데이터를 선택하세요.");
				} else {
					String num = String.valueOf(table.getValueAt(idx, 2));
					int response = JOptionPane.showConfirmDialog(BankAccountList.this, "삭제하시겠습니까?");
					if (response == JOptionPane.YES_OPTION) {
						int result = dao.deleteAccount(num);
						if (result == 1) {
							JOptionPane.showMessageDialog(BankAccountList.this, "삭제되었습니다.");
							refreshTable();
						}
					}
					idx = -1;
				}
			}
		});
		btnDelete.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnDelete.setBounds(400, 214, 97, 23);
		add(btnDelete);
		
		setSize(600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void refreshTable() {
		DefaultTableModel model = new DefaultTableModel(dao.listAccount(), cols);
		table.setModel(model);
	}
	
	public static void main(String[] args) {
		new BankAccountList();
	}
}
