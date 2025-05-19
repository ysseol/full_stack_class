package bank;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BankAccountAdd extends JFrame {
	
	private BankAccountDAO dao = new BankAccountDAO();
	private BankAccountDTO dto;
	private JTextField tfBank;
	private JTextField tfName;
	private JTextField tfNum;
	private JTextField tfMoney;
	private BankAccountList frm;
	
	public BankAccountAdd(BankAccountList frm) {
		this();
		this.frm = frm;
	}

	public BankAccountAdd() {
		setTitle("계좌정보 추가");
		
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
		
		JButton btnSave = new JButton("저장");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bank = tfBank.getText();
				String name = tfName.getText();
				String num = tfNum.getText();
				int money = Integer.parseInt(tfMoney.getText());
				dto = new BankAccountDTO(bank, name, num, money);
				int result = dao.insertAccount(dto);
				if (result == 1) {
					JOptionPane.showMessageDialog(BankAccountAdd.this, "추가되었습니다.");
					frm.refreshTable();
					dispose();
				}
			}
		});
		btnSave.setBounds(78, 160, 97, 23);
		add(btnSave);
		
		setSize(280, 240);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
