package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Loguin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loguin frame = new Loguin();
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
	public Loguin() {
		setTitle("Loguin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		txtUsuario.setToolTipText("new ");
		txtUsuario.setBounds(496, 240, 393, 55);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblLoguin = new JLabel("USU\u00C1RIO");
		lblLoguin.setFont(new Font("Arial", Font.BOLD, 14));
		lblLoguin.setBounds(388, 260, 98, 14);
		contentPane.add(lblLoguin);
		
		JLabel lblSenha = new JLabel("PASSWORD");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setBounds(388, 362, 98, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setBackground(new Color(235, 235, 235));
				btnEntrar.setForeground(new Color(58, 65, 84));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntrar.setBackground(new Color(58, 65, 84));
				btnEntrar.setForeground(Color.WHITE);
			}
		});
		
		btnEntrar.setBackground(new Color(0, 0, 0));
		btnEntrar.setForeground(new Color(245, 255, 250));
		btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loguin = txtUsuario.getText();
				String senha = txtSenha.getText();
					
				if (loguin.equals("admin") && senha.equals("admin")) {
					Menu m = new Menu();
					m.setVisible(true);
					Loguin.this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Credências incorretas?");
				}
			}
		});
		btnEntrar.setBounds(496, 433, 393, 55);
		contentPane.add(btnEntrar);
		
		JButton btcRecupeConta = new JButton("ESQUECEU SUA CONTA?");
		btcRecupeConta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btcRecupeConta.setBackground(new Color(235, 235, 235));
				btcRecupeConta.setForeground(new Color(217, 81, 51));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btcRecupeConta.setBackground(new Color(217, 81, 51));
				btcRecupeConta.setForeground(Color.WHITE);
			}
		});
		btcRecupeConta.setForeground(new Color(255, 255, 255));
		btcRecupeConta.setBackground(new Color(210, 105, 30));
		btcRecupeConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "E-mail para alteração enviado");
			}
		});
		btcRecupeConta.setFont(new Font("Arial", Font.BOLD, 14));
		btcRecupeConta.setBounds(496, 539, 393, 55);
		contentPane.add(btcRecupeConta);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.BOLD, 14));
		txtSenha.setToolTipText("");
		txtSenha.setBounds(496, 342, 393, 55);
		contentPane.add(txtSenha);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1379, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CL\u00CDNICA LIBERTAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 36, 1342, 36);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 97, 1921, 5);
		contentPane.add(panel_1);
	}
}
