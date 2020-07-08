package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.libertas.dto.Agendamento;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorio09 extends JFrame {

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
					Relatorio09 frame = new Relatorio09();
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
	public Relatorio09() {
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
		
		JLabel lblNewLabel = new JLabel("CONSULTA A QUANTIDADE E O VALOR TOTAL DAS CONSULTAS AGENDADAS EM UM DETERMINADO MÊS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 27, 1352, 37);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 95, 1352, 6);
		contentPane.add(panel_1);
		
		JLabel lblMes = new JLabel("M\u00CAS");
		lblMes.setFont(new Font("Arial", Font.BOLD, 14));
		lblMes.setBounds(475, 142, 45, 29);
		contentPane.add(lblMes);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(555, 140, 146, 35);
		contentPane.add(txtMes);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraRelatorio9();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 16));
		btnConsultar.setBackground(new Color(220, 220, 220));
		btnConsultar.setBounds(758, 138, 138, 34);
		contentPane.add(btnConsultar);
		
		lblArea = new JLabel("");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("Arial", Font.BOLD, 16));
		lblArea.setBounds(10, 205, 1332, 412);
		contentPane.add(lblArea);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios rel = new Relatorios();
				rel.setVisible(true);
				Relatorio09.this.dispose();
			}
		});
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 15));
		btnVoltar.setBounds(629, 663, 97, 35);
		contentPane.add(btnVoltar);
		this.setLocationRelativeTo(null);
	}
	
	public void geraRelatorio9() {
		
		int mes = Integer.valueOf(txtMes.getText());
		
		LinkedList<Agendamento> dados = (LinkedList<Agendamento>) Agendamento.getDao().consulta09(mes);
		
		
		if (dados.size() > 0) {
			String valor = "<html>" + "<br><br>";
			for (Agendamento ag: dados) {
			   valor += ag.imprimeRelatorio9() + "<br><br>";
			}
			valor += "</html>";
			lblArea.setText(valor);
		}else {
			lblArea.setText("Não há dados a ser exibidos");
		}
		
	}
	
	public JLabel getLblArea() {
		return lblArea;
	}
}
