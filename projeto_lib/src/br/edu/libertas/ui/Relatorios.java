package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorios extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios frame = new Relatorios();
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
	public Relatorios() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Relatorios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 98);
		panel.setBackground(new Color(32, 178, 170));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RELAT\u00D3RIOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 10, 1354, 74);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 94, 1920, 7);
		panel_1.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel_1);
		
		JButton btnRelatorio1 = new JButton("ABRIR");
		btnRelatorio1.setBounds(20, 147, 555, 34);
		btnRelatorio1.setBackground(new Color(220, 220, 220));
		btnRelatorio1.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio01 r = new Relatorio01();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		getContentPane().add(btnRelatorio1);
		
		JButton btnRelatorio2 = new JButton("ABRIR");
		btnRelatorio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio02 r = new Relatorio02();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio2.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio2.setBackground(new Color(220, 220, 220));
		btnRelatorio2.setBounds(20, 242, 555, 34);
		getContentPane().add(btnRelatorio2);
		
		JButton btnRelatorio3 = new JButton("ABRIR");
		btnRelatorio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio03 r = new Relatorio03();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio3.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio3.setBackground(new Color(220, 220, 220));
		btnRelatorio3.setBounds(20, 334, 555, 34);
		getContentPane().add(btnRelatorio3);
		
		JLabel lblRelatorio1 = new JLabel("1)  CONSULTA AGENDAMENTOS DE UM DETERMINADO PROFISSIONAL");
		lblRelatorio1.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio1.setBounds(20, 112, 514, 24);
		getContentPane().add(lblRelatorio1);
		
		JLabel lblRelatorio2 = new JLabel("2) CONSULTA AGENDAMENTO DE UM DETERMINADO PER\u00CDODO");
		lblRelatorio2.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio2.setBounds(24, 205, 483, 26);
		getContentPane().add(lblRelatorio2);
		
		JLabel lblRelatorio3 = new JLabel("3) CONSULTA AGENDAMENTO DE UM PROFISSIONAL DE UM DETERMINADO TIPO");
		lblRelatorio3.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio3.setBounds(20, 299, 608, 24);
		getContentPane().add(lblRelatorio3);
		
		JLabel lblRelatorio4 = new JLabel("4) \r\nCONSULTA PACIENTES QUE NASCERAM EM UM DETERMINADO M\u00CAS");
		lblRelatorio4.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio4.setBounds(20, 399, 555, 13);
		getContentPane().add(lblRelatorio4);
		
		JButton btnRelatorio4 = new JButton("ABRIR");
		btnRelatorio4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio04 r = new Relatorio04();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio4.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio4.setBackground(new Color(220, 220, 220));
		btnRelatorio4.setBounds(20, 423, 555, 34);
		getContentPane().add(btnRelatorio4);
		
		JLabel lblRelatorio5 = new JLabel("5) LISTA PROFISSIONAIS QUE CONT\u00CAM OS CARACTERES PASSADOS");
		lblRelatorio5.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio5.setBounds(20, 487, 555, 16);
		getContentPane().add(lblRelatorio5);
		
		JButton btnRelatorio5 = new JButton("ABRIR");
		btnRelatorio5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio05 r = new Relatorio05();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio5.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio5.setBackground(new Color(220, 220, 220));
		btnRelatorio5.setBounds(20, 514, 555, 34);
		getContentPane().add(btnRelatorio5);
		
		JLabel lblRelatorio6 = new JLabel("6) CONSULTA A QTD DE AGENDAMENTOS QUE TEM DESCONTO \r\nE N\u00C3O TEM CONV\u00CANIO");
		lblRelatorio6.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio6.setBounds(725, 112, 697, 24);
		getContentPane().add(lblRelatorio6);
		
		JButton btnRelatorio6 = new JButton("ABRIR");
		btnRelatorio6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio06 r = new Relatorio06();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio6.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio6.setBackground(new Color(220, 220, 220));
		btnRelatorio6.setBounds(725, 147, 555, 34);
		getContentPane().add(btnRelatorio6);
		
		JLabel lblRelatorio7 = new JLabel("7) CONSULTA A M\u00C9DIA DE PRE\u00C7OS E A QUANTIDADE DE AGENDAMENTO POR PROFISSIONAL");
		lblRelatorio7.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio7.setBounds(725, 205, 608, 26);
		getContentPane().add(lblRelatorio7);
		
		JButton btnRelatorio7 = new JButton("ABRIR");
		btnRelatorio7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio07 r = new Relatorio07();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio7.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio7.setBackground(new Color(220, 220, 220));
		btnRelatorio7.setBounds(725, 242, 555, 34);
		getContentPane().add(btnRelatorio7);
		
		JLabel lblRelatorio8 = new JLabel("8) CONSULTA O VALOR TOTAL DE CONSULTAS AGENDADAS POR PROFISSIONAL");
		lblRelatorio8.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio8.setBounds(725, 299, 608, 24);
		getContentPane().add(lblRelatorio8);
		
		JButton btnRelatorio8 = new JButton("ABRIR");
		btnRelatorio8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio08 r = new Relatorio08();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio8.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio8.setBackground(new Color(220, 220, 220));
		btnRelatorio8.setBounds(725, 334, 555, 34);
		getContentPane().add(btnRelatorio8);
		
		JLabel lblRelatorio9 = new JLabel("9) CONSULTA A QUANTIDADE E O VALOR TOTAL DAS CONSULTAS AGENDADAS DE UM M\u00CAS");
		lblRelatorio9.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio9.setBounds(725, 399, 591, 13);
		getContentPane().add(lblRelatorio9);
		
		JButton btnRelatorio9 = new JButton("ABRIR");
		btnRelatorio9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio09 r = new Relatorio09();
				r.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio9.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio9.setBackground(new Color(220, 220, 220));
		btnRelatorio9.setBounds(725, 423, 555, 34);
		getContentPane().add(btnRelatorio9);
		
		JLabel lblRelatorio10 = new JLabel("10)  CONSULTA PROFISSIONAL E A QUANTIDADE DE AGENDAMENTOS,EM DETERMINADO M\u00CAS");
		lblRelatorio10.setFont(new Font("Arial", Font.BOLD, 13));
		lblRelatorio10.setBounds(725, 490, 641, 13);
		getContentPane().add(lblRelatorio10);
		
		JButton btnRelatorio10 = new JButton("ABRIR");
		btnRelatorio10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio10 rel = new Relatorio10();
				rel.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnRelatorio10.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorio10.setBackground(new Color(220, 220, 220));
		btnRelatorio10.setBounds(725, 514, 555, 34);
		getContentPane().add(btnRelatorio10);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				Relatorios.this.dispose();
			}
		});
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setBounds(596, 620, 114, 45);
		getContentPane().add(btnVoltar);
	}
}
