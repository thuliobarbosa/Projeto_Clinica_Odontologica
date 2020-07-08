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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorio08 extends JFrame {

	private JPanel contentPane;
	private JLabel lblArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio08 frame = new Relatorio08();
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
	public Relatorio08() {
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
		
		JLabel lblNewLabel = new JLabel("CONSULTA O VALOR TOTAL DE CONSULTAS AGENDADAS POR PROFISSIONAL, CASO O VALOR TOTAL DE CONSULTAS AGENDADAS SEJA MAIOR DO QUE R$ 500,00 ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 30, 1352, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 97, 1352, 5);
		contentPane.add(panel_1);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios rel = new Relatorios();
				rel.setVisible(true);
				Relatorio08.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 15));
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setBounds(708, 639, 141, 47);
		contentPane.add(btnVoltar);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraRelatorio8();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsultar.setBackground(new Color(220, 220, 220));
		btnConsultar.setBounds(531, 639, 141, 47);
		contentPane.add(btnConsultar);
		
		lblArea = new JLabel("");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("Arial", Font.BOLD, 16));
		lblArea.setBounds(10, 130, 1332, 458);
		contentPane.add(lblArea);
		this.setLocationRelativeTo(null);
	}

	public void geraRelatorio8() {
		
		LinkedList<Agendamento> dados = (LinkedList<Agendamento>) Agendamento.getDao().consulta08();
		
		if (dados.size() > 0) {
		String valor = "<html>" + "<br><br>";
		for (Agendamento ag: dados) {
		   valor += ag.imprimeRelatorio8() + "<br><br>";
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
