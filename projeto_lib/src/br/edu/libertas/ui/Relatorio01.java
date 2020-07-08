package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.libertas.db.AgendamentoDao;
import br.edu.libertas.dto.Agendamento;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class Relatorio01 extends JFrame {

	private JPanel contentPane;
	private JTextField txtProfissional;
	private JLabel lblArea;
	private Hashtable<String,LinkedList<Agendamento>> listaAgendamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio01 frame = new Relatorio01();
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
	public Relatorio01() {
		setTitle("Relatorios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1352, 134);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONSULTA AGENDAMENTOS DE UM DETERMINADO PROFISSIONAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 50, 1352, 26);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 134, 1931, 4);
		contentPane.add(panel_1);
		
		JLabel txtNomeProfissional = new JLabel("NOME DO PROFISSIONAL");
		txtNomeProfissional.setFont(new Font("Arial", Font.BOLD, 16));
		txtNomeProfissional.setBounds(273, 191, 209, 40);
		contentPane.add(txtNomeProfissional);
		
		txtProfissional = new JTextField();
		txtProfissional.setFont(new Font("Arial", Font.PLAIN, 16));
		txtProfissional.setBounds(511, 190, 495, 44);
		contentPane.add(txtProfissional);
		txtProfissional.setColumns(10);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				geraRelatorio();
			}
		});
		btnConsultar.setFont(new Font("Arial", Font.BOLD, 16));
		btnConsultar.setBackground(new Color(220, 220, 220));
		btnConsultar.setBounds(1050, 189, 149, 45);
		contentPane.add(btnConsultar);
		
		lblArea = new JLabel("");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setBackground(Color.WHITE);
		lblArea.setFont(new Font("Arial", Font.BOLD, 16));
		lblArea.setVerticalAlignment(SwingConstants.TOP);
		lblArea.setBounds(10, 289, 1330, 360);
		contentPane.add(lblArea);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios rel = new Relatorios();
				rel.setVisible(true);
				Relatorio01.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.setBounds(620, 660, 149, 45);
		contentPane.add(btnVoltar);

	}

	public void geraRelatorio() {
		Agendamento a = new Agendamento();
		
		a.setNomeProfissional(txtProfissional.getText());
		
		listaAgendamento = new Hashtable<String, LinkedList<Agendamento>>();
		LinkedList<Agendamento> dados = (LinkedList<Agendamento>) Agendamento.getDao().listaAgendamento();
		
		for (Agendamento agen : dados) {
			listaAgendamento.putIfAbsent(agen.getNomeProfissional(), new LinkedList<Agendamento>());
			listaAgendamento.get(agen.getNomeProfissional()).add(agen);
		}
		
		if (listaAgendamento.containsKey(a.getNomeProfissional())) {
			String valor = "<html> Profissional: " + a.getNomeProfissional() + "<br><br>";
			for (Agendamento ag: listaAgendamento.get(a.getNomeProfissional())) {
			   valor+= ag.imprimeRelatorio1() + "<br>";
			}
			valor += "</html>";
			lblArea.setText(valor);
		}
		else {
			JOptionPane.showMessageDialog(null, "Profissional não cadastrado!");
		}
		
	}
	
}
