package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.sql.Date;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class Relatorio04 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMes;
	private JLabel lblArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio04 frame = new Relatorio04();
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
	public Relatorio04() {
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
		
		JLabel lblNewLabel = new JLabel("CONSULTA PACIENTES QUE NASCERAM EM UM DETERMINADO M\u00CAS");
		lblNewLabel.setBounds(10, 34, 1342, 34);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 97, 1352, 4);
		contentPane.add(panel_1);
		
		JLabel lblMes = new JLabel("M\u00CAS");
		lblMes.setFont(new Font("Arial", Font.BOLD, 14));
		lblMes.setBounds(466, 144, 45, 29);
		contentPane.add(lblMes);
		
		txtMes = new JTextField();
		txtMes.setBounds(546, 142, 146, 35);
		contentPane.add(txtMes);
		txtMes.setColumns(10);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraRelatorio4();
			}
		});
		btnConsultar.setBackground(new Color(220, 220, 220));
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 16));
		btnConsultar.setBounds(749, 140, 138, 34);
		contentPane.add(btnConsultar);
		
		lblArea = new JLabel("");
		lblArea.setFont(new Font("Arial", Font.BOLD, 16));
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setBounds(10, 191, 1332, 394);
		contentPane.add(lblArea);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios rel = new Relatorios();
				rel.setVisible(true);
				Relatorio04.this.dispose();
			}
		});
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
		btnVoltar.setBounds(630, 645, 105, 29);
		contentPane.add(btnVoltar);
		this.setLocationRelativeTo(null);
	}
	
	public void geraRelatorio4() {
		Agendamento a = new Agendamento();
		
		int mes = Integer.valueOf(txtMes.getText());
		
		LinkedList<Agendamento> dados = (LinkedList<Agendamento>) Agendamento.getDao().consulta04(mes);
		
		if (dados.size() > 0) {
			String valor = "<html> MES ==> " + mes + "<br><br>";
			for (Agendamento ag: dados) {
			   valor += ag.imprimeRelatorio4() + "<br>";
			}
			valor += "</html>";
			lblArea.setText(valor);
		}
		else {
			lblArea.setText("Não há dados a ser exibidos");
		}

	}
	
	public JLabel getLblArea() {
		return lblArea;
	}
}
