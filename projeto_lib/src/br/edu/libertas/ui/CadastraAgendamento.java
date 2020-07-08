package br.edu.libertas.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.libertas.db.AgendamentoDao;
import br.edu.libertas.dto.Agendamento;
import br.edu.libertas.dto.Data;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class CadastraAgendamento extends JFrame {

	private JPanel contentPane;
	private JTextField txtDataAgendamento;
	private JTextField txtHorario;
	private JTextField txtDuracao;
	private JTextField txtCpf;
	private JTextField txtNomePaciente;
	private JTextField txtTelefone;
	private JTextField txtDataNascimento;
	private JTextField txtNomeProfissional;
	private JTextField txtTipo;
	private JTextField txtValorConsulta;
	private JTextField txtTaxaDesconto;
	private JTextField txtConvenio;
	
	private int idAgendamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraAgendamento frame = new CadastraAgendamento();
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
	public CadastraAgendamento() {
		setTitle("Cadastro de agendamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblDataAgendamento = new JLabel("DATA AGENDAMENTO");
		lblDataAgendamento.setFont(new Font("Arial", Font.BOLD, 16));
		lblDataAgendamento.setBounds(242, 185, 193, 14);
		contentPane.add(lblDataAgendamento);
		
		txtDataAgendamento = new JTextField();
		txtDataAgendamento.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDataAgendamento.setBounds(445, 170, 214, 40);
		contentPane.add(txtDataAgendamento);
		txtDataAgendamento.setColumns(10);
		
		JLabel lblHorario = new JLabel("HOR\u00C1RIO");
		lblHorario.setFont(new Font("Arial", Font.BOLD, 16));
		lblHorario.setBounds(242, 260, 104, 19);
		contentPane.add(lblHorario);
		
		txtHorario = new JTextField();
		txtHorario.setFont(new Font("Arial", Font.PLAIN, 16));
		txtHorario.setBounds(445, 250, 214, 40);
		contentPane.add(txtHorario);
		txtHorario.setColumns(10);
		
		JLabel lblDuracao = new JLabel("DURA\u00C7\u00C3O");
		lblDuracao.setFont(new Font("Arial", Font.BOLD, 16));
		lblDuracao.setBounds(242, 328, 104, 29);
		contentPane.add(lblDuracao);
		
		txtDuracao = new JTextField();
		txtDuracao.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDuracao.setBounds(445, 326, 214, 40);
		contentPane.add(txtDuracao);
		txtDuracao.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCpf.setBounds(445, 403, 214, 40);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 16));
		lblCpf.setBounds(242, 420, 104, 14);
		contentPane.add(lblCpf);
		
		txtNomePaciente = new JTextField();
		txtNomePaciente.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNomePaciente.setBounds(445, 480, 214, 40);
		contentPane.add(txtNomePaciente);
		txtNomePaciente.setColumns(10);
		
		JLabel lblNomePaciente = new JLabel("NOME PACIENTE");
		lblNomePaciente.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomePaciente.setBounds(242, 497, 161, 14);
		contentPane.add(lblNomePaciente);
		
		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTelefone.setBounds(445, 556, 214, 40);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblTelefone = new JLabel("TELEFONE");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 16));
		lblTelefone.setBounds(242, 573, 104, 14);
		contentPane.add(lblTelefone);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setFont(new Font("Arial", Font.PLAIN, 16));
		txtDataNascimento.setBounds(941, 170, 214, 40);
		contentPane.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		JLabel lblDataNascimento = new JLabel("DATA NASCIMENTO");
		lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 16));
		lblDataNascimento.setBounds(764, 185, 158, 14);
		contentPane.add(lblDataNascimento);
		
		JLabel lblNomeProfissional = new JLabel("PROFISSIONAL");
		lblNomeProfissional.setFont(new Font("Arial", Font.BOLD, 16));
		lblNomeProfissional.setBounds(764, 265, 146, 14);
		contentPane.add(lblNomeProfissional);
		
		txtNomeProfissional = new JTextField();
		txtNomeProfissional.setFont(new Font("Arial", Font.PLAIN, 16));
		txtNomeProfissional.setBounds(941, 250, 214, 40);
		contentPane.add(txtNomeProfissional);
		txtNomeProfissional.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTipo.setBounds(941, 328, 214, 40);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTipo.setBounds(764, 345, 89, 14);
		contentPane.add(lblTipo);
		
		txtValorConsulta = new JTextField();
		txtValorConsulta.setFont(new Font("Arial", Font.PLAIN, 16));
		txtValorConsulta.setBounds(941, 403, 214, 40);
		contentPane.add(txtValorConsulta);
		txtValorConsulta.setColumns(10);
		
		JLabel lblValorConsulta = new JLabel("VALOR CONSULTA");
		lblValorConsulta.setFont(new Font("Arial", Font.BOLD, 16));
		lblValorConsulta.setBounds(764, 420, 158, 14);
		contentPane.add(lblValorConsulta);
		
		txtTaxaDesconto = new JTextField();
		txtTaxaDesconto.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTaxaDesconto.setBounds(941, 480, 214, 40);
		contentPane.add(txtTaxaDesconto);
		txtTaxaDesconto.setColumns(10);
		
		JLabel lblTaxaDesconto = new JLabel("DESCONTO");
		lblTaxaDesconto.setFont(new Font("Arial", Font.BOLD, 16));
		lblTaxaDesconto.setBounds(764, 497, 146, 14);
		contentPane.add(lblTaxaDesconto);
		
		JLabel lblConvenio = new JLabel("CONVENIO");
		lblConvenio.setFont(new Font("Arial", Font.BOLD, 16));
		lblConvenio.setBounds(764, 573, 146, 14);
		contentPane.add(lblConvenio);
		
		txtConvenio = new JTextField();
		txtConvenio.setFont(new Font("Arial", Font.PLAIN, 16));
		txtConvenio.setBounds(941, 556, 214, 40);
		contentPane.add(txtConvenio);
		txtConvenio.setColumns(10);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 16));
		btnSalvar.setBackground(new Color(220, 220, 220));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				salvar();

			}
		});
		btnSalvar.setBounds(445, 646, 214, 40);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
		btnVoltar.setBackground(new Color(220, 220, 220));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				CadastraAgendamento.this.dispose();
			}
		});
		btnVoltar.setBounds(764, 646, 214, 40);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 1352, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE AGENDAMENTO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 25, 1354, 43);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 96, 1919, 5);
		contentPane.add(panel_1);
	}

	public void salvar(){
		
		Agendamento a = new Agendamento();
		
		a.setIdAgendamento(idAgendamento);
		a.setDataAgendamento(converter(txtDataAgendamento.getText()));
		a.setHorario(Time.valueOf(txtHorario.getText()));
		a.setDuracao(Double.parseDouble(txtDuracao.getText()));
		a.setCpf(txtCpf.getText());
		a.setNomePaciente(txtNomePaciente.getText());
		a.setTelefone(txtTelefone.getText());
		a.setDataNascimento(converter(txtDataNascimento.getText())); 
		a.setNomeProfissional(txtNomeProfissional.getText());
		a.setTipo(txtTipo.getText());
		a.setValorConsulta(Double.parseDouble(txtValorConsulta.getText()));
		a.setPercDesconto(Integer.parseInt(txtTaxaDesconto.getText()));
		a.setConvenio(Integer.parseInt(txtConvenio.getText()));
		
		AgendamentoDao aDao = new AgendamentoDao();
		if (idAgendamento > 0) {
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar esse agendamento?",
					   "Exclusão", JOptionPane.YES_NO_OPTION);
			if (resposta == JOptionPane.YES_OPTION) {
				aDao.alteraAgendamento(a);;
			}
		}
		else {
			aDao.addAgendamento(a);
		}
		
		Menu m = new Menu();
		m.setVisible(true);
		
		CadastraAgendamento.this.dispose();
		
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

	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
		
		AgendamentoDao aDao = new AgendamentoDao();
		Agendamento a = aDao.consultaAgendamento(idAgendamento);
		
		txtDataAgendamento.setText(String.valueOf(a.getDataAgendamento()));
		txtHorario.setText(String.valueOf(a.getHorario()));
		txtDuracao.setText(String.valueOf(a.getDuracao()));
		txtCpf.setText(a.getCpf());
		txtNomePaciente.setText(a.getNomePaciente());
		txtTelefone.setText(a.getTelefone());
		txtDataNascimento.setText(String.valueOf(a.getDataNascimento()));
		txtNomeProfissional.setText(a.getNomeProfissional());
		txtTipo.setText(a.getTipo());
		txtValorConsulta.setText(String.valueOf(a.getValorConsulta()));
		txtTaxaDesconto.setText(String.valueOf(a.getPercDesconto()));
		txtConvenio.setText(String.valueOf(a.getConvenio()));
	}
}
