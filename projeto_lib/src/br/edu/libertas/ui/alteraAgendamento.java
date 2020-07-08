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
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class alteraAgendamento extends JFrame {

	private JPanel contentPane;
	private JTable table;
	//private idAgendamento;
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
					alteraAgendamento frame = new alteraAgendamento();
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
	public alteraAgendamento() {
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
		
		JLabel lblNewLabel = new JLabel("ALTERA AGENDAMENTO");
		lblNewLabel.setBackground(new Color(32, 178, 170));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 28, 1352, 39);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 108, 1342, 500);
		contentPane.add(scrollPane);
		
		table = new JTable(dados);
		scrollPane.setViewportView(table);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.BOLD, 16));
		btnAlterar.setBackground(new Color(220, 220, 220));
		btnAlterar.setBounds(499, 638, 137, 41);
		contentPane.add(btnAlterar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				alteraAgendamento.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setBounds(676, 638, 137, 41);
		contentPane.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(-11, 97, 1911, 4);
		contentPane.add(panel_1);
		
		listar();
	}
	
	public void alterar() {
		
		int id = Integer.parseInt(dados.getValueAt(table.getSelectedRow(), 0).toString());
		
		 CadastraAgendamento cad = new CadastraAgendamento();
		 
		 cad.setIdAgendamento(id);
		 cad.setVisible(true);
		 alteraAgendamento.this.dispose();
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
