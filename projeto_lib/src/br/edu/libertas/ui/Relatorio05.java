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

public class Relatorio05 extends JFrame {

	private JPanel contentPane;
	private JTextField txtCaracters;
	private JLabel lblArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio05 frame = new Relatorio05();
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
	public Relatorio05() {
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
		
		JLabel lblNewLabel = new JLabel("LISTA PROFISSIONAIS QUE CONTEM OS CARACTERES PASSADOS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 29, 1352, 28);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 95, 1352, 6);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCaracters = new JLabel("CARACTERS");
		lblCaracters.setFont(new Font("Arial", Font.BOLD, 14));
		lblCaracters.setBounds(426, 136, 101, 32);
		contentPane.add(lblCaracters);
		
		txtCaracters = new JTextField();
		txtCaracters.setBounds(537, 138, 207, 32);
		contentPane.add(txtCaracters);
		txtCaracters.setColumns(10);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraRelatorio5();
			}
		});
		btnConsultar.setBackground(new Color(220, 220, 220));
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 16));
		btnConsultar.setBounds(788, 135, 146, 33);
		contentPane.add(btnConsultar);
		
		lblArea = new JLabel("");
		lblArea.setFont(new Font("Arial", Font.BOLD, 16));
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setBounds(10, 187, 1342, 427);
		contentPane.add(lblArea);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios rel = new Relatorios();
				rel.setVisible(true);
				Relatorio05.this.dispose();
			}
		});
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
		btnVoltar.setBounds(604, 653, 101, 32);
		contentPane.add(btnVoltar);
		this.setLocationRelativeTo(null);
	}
	
	public void geraRelatorio5() {
		Agendamento a = new Agendamento();
		
		String caracters = txtCaracters.getText();
		
		LinkedList<Agendamento> dados = (LinkedList<Agendamento>) Agendamento.getDao().consulta05(caracters);
		
		if (dados.size() > 0) {
			String valor = "<html> BUSCANDO... " + caracters + "<br><br>";
			for (Agendamento ag: dados) {
			   valor += ag.imprimeRelatorio5() + "<br>";
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
