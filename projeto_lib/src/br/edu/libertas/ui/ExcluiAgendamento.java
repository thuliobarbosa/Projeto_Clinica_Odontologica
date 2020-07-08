package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.edu.libertas.db.AgendamentoDao;
import br.edu.libertas.dto.Agendamento;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ExcluiAgendamento extends JFrame {

	private JPanel contentPane;
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
					ExcluiAgendamento frame = new ExcluiAgendamento();
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
	public ExcluiAgendamento() {
		setTitle("Exclui Agendamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 1332, 478);
		contentPane.add(scrollPane);
		
		table = new JTable(dados);
		scrollPane.setViewportView(table);
		
		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setBackground(new Color(220, 220, 220));
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 16));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		btnExcluir.setBounds(448, 646, 190, 40);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				
				ExcluiAgendamento.this.dispose();
			}
		});
		btnVoltar.setBounds(696, 646, 190, 40);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1352, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EXCLUS\u00C3O DE AGENDAMENTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 29, 1352, 40);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 97, 1352, 4);
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
	
	public void excluir() {
		int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse agendamento?",
					   "Exclusão", JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			AgendamentoDao aDao = new AgendamentoDao();
			Agendamento a = new Agendamento();
			a.setIdAgendamento(Integer.parseInt(dados.getValueAt(table.getSelectedRow(), 0).toString()));
			
			aDao.removeAgendamento(a);
			listar();
		}
	}
}
