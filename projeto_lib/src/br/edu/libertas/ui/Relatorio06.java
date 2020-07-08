package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.libertas.db.AgendamentoDao;
import br.edu.libertas.dto.Agendamento;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Relatorio06 extends JFrame {

	private JPanel contentPane;
	private JLabel teste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio06 frame = new Relatorio06();
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
	public Relatorio06() {
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
		
		JLabel lblTitulo = new JLabel("CONSULTA A QUANTIDADE DE AGENDAMENTOS QUE TEM DESCONTO E N\u00C3O TEM CONV\u00CANIO");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(0, 27, 1352, 34);
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 96, 1352, 5);
		contentPane.add(panel_1);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraRelatorio6();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 15));
		btnConsultar.setBackground(new Color(220, 220, 220));
		btnConsultar.setBounds(520, 644, 141, 47);
		contentPane.add(btnConsultar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios rel = new Relatorios();
				rel.setVisible(true);
				Relatorio06.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 15));
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setBounds(710, 644, 141, 47);
		contentPane.add(btnVoltar);
		
		teste = new JLabel("");
		teste.setHorizontalAlignment(SwingConstants.CENTER);
		teste.setFont(new Font("Arial", Font.BOLD, 16));
		teste.setBounds(10, 139, 1332, 481);
		contentPane.add(teste);
		this.setLocationRelativeTo(null);
	}
	
	public void geraRelatorio6() {
		
		AgendamentoDao aDao = new AgendamentoDao();
		
		int quantidade = aDao.consulta06();
		
		if (quantidade > 0) {
			teste.setText("A QUANTIDADE DE AGENDAMENTO QUE TEM DESCONTO É NÃO TEM CONVENIO É: " + quantidade);
		}
		else {
			teste.setText("Não há dados a ser exibidos");
		}
		

	}
	public JLabel getTeste() {
		return teste;
	}
}
