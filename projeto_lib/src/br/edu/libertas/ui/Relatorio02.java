package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.libertas.dto.Agendamento;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Relatorio02 extends JFrame {

	Hashtable<String, LinkedList<Agendamento>> listaAgendamento;
	private JPanel contentPane;
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JLabel lblArea;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio02 frame = new Relatorio02();
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
	public Relatorio02() {
		setTitle("Relatorios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1352, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CONSULTA AGENDAMENTOS DE UMA DETERMINADA DATA");
		lblTitulo.setBounds(0, 32, 1352, 37);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitulo);
		
		lblArea = new JLabel("");
		lblArea.setFont(new Font("Arial", Font.BOLD, 12));
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setBounds(10, 210, 1342, 413);
		contentPane.add(lblArea);
		
		JLabel lblDataInicial = new JLabel("DE");
		lblDataInicial.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataInicial.setBounds(333, 138, 46, 61);
		contentPane.add(lblDataInicial);
		
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(389, 148, 170, 45);
		contentPane.add(txtDataInicial);
		txtDataInicial.setColumns(10);
		
		JLabel lblDataFinal = new JLabel("AT\u00C9");
		lblDataFinal.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataFinal.setBounds(625, 153, 46, 31);
		contentPane.add(lblDataFinal);
		
		txtDataFinal = new JTextField();
		txtDataFinal.setColumns(10);
		txtDataFinal.setBounds(681, 146, 170, 47);
		contentPane.add(txtDataFinal);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBackground(new Color(220, 220, 220));
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraRelatorio2();
			}
		});
		btnConsultar.setBounds(934, 147, 134, 45);
		contentPane.add(btnConsultar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 98, 1352, 3);
		contentPane.add(panel_1);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios rel = new Relatorios();
				rel.setVisible(true);
				Relatorio02.this.dispose();
			}
		});
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setBounds(592, 656, 134, 45);
		contentPane.add(btnVoltar);
		this.setLocationRelativeTo(null);
	}
	
	public void geraRelatorio2() {
		Agendamento a = new Agendamento();
		
		Date dataInicial = converter(txtDataInicial.getText());
		Date dataFinal = converter(txtDataFinal.getText());
		
		LinkedList<Agendamento> dados = (LinkedList<Agendamento>) Agendamento.getDao().consulta02(dataInicial, dataFinal);
		
		
		if (dados.size() > 0) {
			String valor = "<html> PERIODO:  " + dataInicial + "  A  " + dataFinal + "<br><br>";
			for (Agendamento ag: dados) {
			   valor += ag.imprimeRelatorio2() + "<br>";
			}
			valor += "</html>";
			lblArea.setText(valor);
		}
		else {
			lblArea.setText("Não há dados a ser exibidos");
		}
	
	}
	
	public java.sql.Date converter(String data) {
		
		java.sql.Date sql = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date parsed = format.parse(data);
			sql = new java.sql.Date(parsed.getTime());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sql;
	}
	
	public JLabel getLblArea() {
		return lblArea;
	}
}
