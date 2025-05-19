package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BankAccountEdit extends JFrame {

	private BankAccountDAO dao = new BankAccountDAO();
	private BankAccountDTO dto;
	private JTextField tfBank;
	private JTextField tfName;
	private JTextField tfNum;
	private JTextField tfMoney;
	private BankAccountList frm;
	private String bankName = "", name = "", AccNumber = "";
	private int money = 0;
	private JButton btnDelete;
	
	public BankAccountEdit(BankAccountList frm, String bankName, String name, String AccNumber, int money) {
		this();
		this.frm = frm;
		this.bankName = bankName;
		this.name = name;
		this.AccNumber = AccNumber;
		this.money = money;
		input();
	}
	
	public BankAccountEdit() {
		
		setTitle("계좌정보 편집");
		
		setLayout(null);
		
		JLabel lblBank = new JLabel("은행명");
		lblBank.setBounds(40, 20, 57, 15);
		add(lblBank);
		
		JLabel lblName = new JLabel("예금주");
		lblName.setBounds(40, 55, 57, 15);
		add(lblName);
		
		JLabel lblNo = new JLabel("계좌번호");
		lblNo.setBounds(40, 90, 57, 15);
		add(lblNo);
		
		JLabel lblMoney = new JLabel("잔액");
		lblMoney.setBounds(40, 125, 57, 15);
		add(lblMoney);
		
		tfBank = new JTextField();
		tfBank.setBounds(109, 17, 116, 21);
		add(tfBank);
		tfBank.setColumns(10);
		
		tfName = new JTextField();
		tfName.setBounds(109, 52, 116, 21);
		add(tfName);
		tfName.setColumns(10);
		
		tfNum = new JTextField();
		tfNum.setBounds(109, 87, 116, 21);
		add(tfNum);
		tfNum.setColumns(10);
		
		tfMoney = new JTextField();
		tfMoney.setBounds(109, 122, 116, 21);
		add(tfMoney);
		tfMoney.setColumns(10);
		
		JButton btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bank = tfBank.getText();
				String name = tfName.getText();
				String num = tfNum.getText();
				int money = Integer.valueOf(tfMoney.getText());
				dto = new BankAccountDTO(bank, num, name, money);
				int result = dao.updateAccount(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(BankAccountEdit.this, "수정되었습니다.");
					frm.refreshTable();
				}
				dispose();
			}
		});
		btnUpdate.setBounds(38, 157, 97, 23);
		add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(BankAccountEdit.this, "삭제하시겠습니까?");
				if (response == JOptionPane.YES_OPTION) {
					String num = tfNum.getText();
					int result = dao.deleteAccount(num);
					if (result == 1) {
						JOptionPane.showMessageDialog(BankAccountEdit.this, "삭제되었습니다");
					}
				}
			}
		});
		btnDelete.setBounds(142, 157, 97, 23);
		add(btnDelete);
		
		setSize(280, 240);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void input() {
		tfBank.setText(bankName);
		tfName.setText(name);
		tfNum.setText(AccNumber);
		tfMoney.setText(String.valueOf(money));
		tfNum.setEditable(false);
	}
	
}
