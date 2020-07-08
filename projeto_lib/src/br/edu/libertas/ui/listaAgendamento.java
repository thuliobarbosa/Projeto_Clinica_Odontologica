package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.libertas.db.AgendamentoDao;
import br.edu.libertas.dto.Agendamento;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class listaAgendamento extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dados = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaAgendamento frame = new listaAgendamento();
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
	public listaAgendamento() {
		setTitle("Lista agendamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 1332, 489);
		contentPane.add(scrollPane);
		
		table = new JTable(dados);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1352, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("LISTA DE AGENDAMENTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 34, 1352, 30);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("VOLTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				listaAgendamento.this.dispose();
			}
		});
		btnNewButton.setBackground(new Color(220, 220, 220));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(1183, 659, 131, 39);
		contentPane.add(btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 97, 1921, 4);
		contentPane.add(panel_1);
		
		listar();
	}
	
	public void listar() {
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
		
		AgendamentoDao aDao = new AgendamentoDao();
		List<Agendamento> lista = aDao.listaAgendamento();
		for (Agendamento ag : lista) {
			dados.addRow(ag.getVetor());
		}
		
	}
}
