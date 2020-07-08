package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.libertas.db.AgendamentoDao;
import br.edu.libertas.dto.Agendamento;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ConsultaAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTable table;

	private DefaultTableModel dados = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaAgendamento frame = new ConsultaAgendamento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaAgendamento() {
		setTitle("Consulta Agendamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1352, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTA DE AGENDAMENTO");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 24, 1354, 45);
		panel.add(lblNewLabel);
		
		JLabel lblIdAgendamento = new JLabel("ID ");
		lblIdAgendamento.setFont(new Font("Arial", Font.BOLD, 20));
		lblIdAgendamento.setBounds(470, 135, 46, 36);
		contentPane.add(lblIdAgendamento);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Arial", Font.PLAIN, 16));
		txtId.setBounds(526, 137, 153, 36);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta();
			}
		});
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(715, 137, 153, 35);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 197, 1332, 421);
		contentPane.add(scrollPane);
		
		table = new JTable(dados);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				ConsultaAgendamento.this.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(220, 220, 220));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setBounds(1151, 670, 168, 36);
		contentPane.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(-12, 97, 1915, 4);
		contentPane.add(panel_1);
		
	}
	
	public void consulta() {
		int id = Integer.parseInt(txtId.getText());
		AgendamentoDao aDao = new AgendamentoDao();
		
		dados.setColumnCount(0);
		dados.setRowCount(0);
		
		dados.addColumn("Codigo");
		dados.addColumn("Data agendamento");
		dados.addColumn("Horario");
		dados.addColumn("Duração");
		dados.addColumn("CPF");
		dados.addColumn("Paciente");
		dados.addColumn("Telefone");
		dados.addColumn("Data nascimento");
		dados.addColumn("Nome Profissional");
		dados.addColumn("Tipo");
		dados.addColumn("Valor consulta");
		dados.addColumn("Percentual Desc");
		dados.addColumn("Convenio");
		
		Agendamento lista = aDao.consultaAgendamento(id);
		dados.addRow(lista.getVetor());
	}
}
