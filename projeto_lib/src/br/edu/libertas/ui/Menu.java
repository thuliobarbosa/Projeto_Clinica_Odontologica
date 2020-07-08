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
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Menu extends JFrame {

	private JPanel contentPane;
	private LocalDate dataAtual = LocalDate.now();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 13));
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loguin l = new Loguin();
				l.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnVoltar.setBounds(1169, 644, 142, 48);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 191, 255));
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1352, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CL\u00CDNICA LIBERTAS");
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(23, 11, 288, 63);
		panel.add(lblTitulo);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 27));
		
		JLabel lblInformacoes = new JLabel("USU\u00C1RIO:  ADMIN " + " | " + "DATA: " + formataDatas(dataAtual) + " | " + " LIBERTAS / MATRIZ");
		lblInformacoes.setBounds(930, 0, 412, 48);
		panel.add(lblInformacoes);
		lblInformacoes.setForeground(new Color(255, 255, 255));
		lblInformacoes.setFont(new Font("Arial", Font.BOLD, 14));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 101, 286, 718);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdicionaAgendamento = new JButton("CADASTRAR AGENDAMENTO");
		btnAdicionaAgendamento.setBackground(new Color(220, 220, 220));
		btnAdicionaAgendamento.setForeground(new Color(0, 0, 0));
		btnAdicionaAgendamento.setFont(new Font("Arial", Font.BOLD, 13));
		btnAdicionaAgendamento.setBounds(11, 214, 267, 43);
		panel_1.add(btnAdicionaAgendamento);
		
		JButton btnRemoveAgendamento = new JButton("REMOVER AGENDAMENTO");
		btnRemoveAgendamento.setBackground(new Color(220, 220, 220));
		btnRemoveAgendamento.setForeground(new Color(0, 0, 0));
		btnRemoveAgendamento.setFont(new Font("Arial", Font.BOLD, 13));
		btnRemoveAgendamento.setBounds(12, 288, 266, 43);
		panel_1.add(btnRemoveAgendamento);
		
		JButton btnAlteraAgendamento = new JButton("ALTERAR AGENDAMENTO");
		btnAlteraAgendamento.setBackground(new Color(220, 220, 220));
		btnAlteraAgendamento.setForeground(new Color(0, 0, 0));
		btnAlteraAgendamento.setFont(new Font("Arial", Font.BOLD, 13));
		btnAlteraAgendamento.setBounds(11, 356, 267, 43);
		panel_1.add(btnAlteraAgendamento);
		
		JButton btnConsultaAgendamento = new JButton("CONSULTAR AGENDAMENTO");
		btnConsultaAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaAgendamento c = new ConsultaAgendamento();
				c.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnConsultaAgendamento.setBackground(new Color(220, 220, 220));
		btnConsultaAgendamento.setFont(new Font("Arial", Font.BOLD, 13));
		btnConsultaAgendamento.setBounds(11, 429, 267, 43);
		panel_1.add(btnConsultaAgendamento);
		
		JButton btnRelatorios = new JButton("RELAT\u00D3RIOS");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios r = new Relatorios();
				r.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnRelatorios.setFont(new Font("Arial", Font.BOLD, 13));
		btnRelatorios.setBackground(new Color(220, 220, 220));
		btnRelatorios.setBounds(10, 573, 267, 43);
		panel_1.add(btnRelatorios);
		
		JButton btnListaAgendamento = new JButton("LISTA AGENDAMENTO");
		btnListaAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaAgendamento a = new listaAgendamento();
				a.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnListaAgendamento.setFont(new Font("Arial", Font.BOLD, 13));
		btnListaAgendamento.setBackground(new Color(220, 220, 220));
		btnListaAgendamento.setBounds(11, 500, 267, 43);
		panel_1.add(btnListaAgendamento);
		
		JButton btnSobre = new JButton("SOBRE");
		btnSobre.setFont(new Font("Arial", Font.BOLD, 13));
		btnSobre.setBackground(new Color(220, 220, 220));
		btnSobre.setBounds(10, 790, 301, 43);
		panel_1.add(btnSobre);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Thulio Barbosa\\Documents\\eclipse-workspace\\projeto_lib\\icons\\logo.PNG"));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(11, -28, 267, 254);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(286, 101, 3, 630);
		contentPane.add(panel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(-1, 97, 1921, 4);
		contentPane.add(panel_1_1);
		panel_1_1.setBackground(Color.BLACK);
		btnAlteraAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alteraAgendamento altera = new alteraAgendamento();
				altera.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnRemoveAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluiAgendamento ex = new ExcluiAgendamento();
				ex.setVisible(true);
				Menu.this.dispose();
			}
		});
		btnAdicionaAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastraAgendamento c = new CadastraAgendamento();
				c.setVisible(true);
				Menu.this.dispose();
			}
		});
	}
	
	private static String formataDatas(LocalDate data) {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
