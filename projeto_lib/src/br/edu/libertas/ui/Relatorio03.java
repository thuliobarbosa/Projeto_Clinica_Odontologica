package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.libertas.dto.Agendamento;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorio03 extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataInicial;
	private JTextField txtDataFinal;
	private JTextField txtTipo;
	private JLabel lblArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio03 frame = new Relatorio03();
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
	public Relatorio03() {
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
		
		JLabel lblNewLabel = new JLabel("CONSULTA AGENDAMENTO DE UM PROFISSIONAL DE UM DETERMINADO TIPO E PER\u00CDODO");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 24, 1352, 49);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 97, 1352, 4);
		contentPane.add(panel_1);
		
		JLabel lblDataInicial = new JLabel("DE");
		lblDataInicial.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataInicial.setBounds(193, 136, 37, 61);
		contentPane.add(lblDataInicial);
		
		txtDataInicial = new JTextField();
		txtDataInicial.setColumns(10);
		txtDataInicial.setBounds(240, 145, 170, 45);
		contentPane.add(txtDataInicial);
		
		JLabel lblDataFinal = new JLabel("AT\u00C9");
		lblDataFinal.setFont(new Font("Arial", Font.BOLD, 15));
		lblDataFinal.setBounds(508, 151, 45, 31);
		contentPane.add(lblDataFinal);
		
		txtDataFinal = new JTextField();
		txtDataFinal.setColumns(10);
		txtDataFinal.setBounds(576, 144, 170, 47);
		contentPane.add(txtDataFinal);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraRelatorio3();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultar.setBackground(new Color(220, 220, 220));
		btnConsultar.setBounds(1097, 144, 134, 45);
		contentPane.add(btnConsultar);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTipo.setBounds(790, 139, 45, 54);
		contentPane.add(lblTipo);
		
		txtTipo = new JTextField();
		txtTipo.setBounds(859, 145, 189, 45);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios rel = new Relatorios();
				rel.setVisible(true);
				Relatorio03.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setBounds(602, 657, 134, 45);
		contentPane.add(btnVoltar);
		
		lblArea = new JLabel("");
		lblArea.setFont(new Font("Arial", Font.BOLD, 16));
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setBounds(10, 216, 1332, 398);
		contentPane.add(lblArea);
		this.setLocationRelativeTo(null);
	}
	public JLabel getLblArea() {
		return lblArea;
	}
	
	public void geraRelatorio3() {
		Agendamento a = new Agendamento();
		
		Date dataInicial = converter(txtDataInicial.getText());
		Date dataFinal = converter(txtDataFinal.getText());
		String tipo = txtTipo.getText();
		
		LinkedList<Agendamento> dados = (LinkedList<Agendamento>) Agendamento.getDao().consulta03(dataInicial, dataFinal, tipo);
		
		if (dados.size() > 0) {
			String valor = "<html> PERIODO:  " + dataInicial + "  A  " + dataFinal + "TIPO: " + tipo + "<br><br>";
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
	
	
	
}
