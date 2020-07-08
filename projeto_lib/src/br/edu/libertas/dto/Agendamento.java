package br.edu.libertas.dto;

import java.sql.Time;
import java.text.SimpleDateFormat;

import br.edu.libertas.db.AgendamentoDao;

import java.sql.Date;

public class Agendamento {
	
	private int idAgendamento;
	private Date dataAgendamento;
	private Time horario;
	private double duracao;
	private String cpf;
	private String nomePaciente;
	private String telefone;
	private Date dataNascimento;
	private String nomeProfissional;
	private String tipo;
	private double valorConsulta;
	private int percDesconto;
	private int convenio;
	private int idade;
	private static AgendamentoDao aDao = new AgendamentoDao();
	
	// auxiliar
	private int quantidadeAgen;
	
	public int getIdAgendamento() {
		return idAgendamento;
	}

	public void setIdAgendamento(int idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
	public Time getHorario() {
		return horario;
	}
	
	public void setHorario(Time horario) {
		this.horario = horario;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getDuracao() {
		return duracao;
	}
	
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getNomeProfissional() {
		return nomeProfissional;
	}
	
	public void setNomeProfissional(String nomeProfissional) {
		this.nomeProfissional = nomeProfissional;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getValorConsulta() {
		return valorConsulta;
	}
	
	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	
	public int getConvenio() {
		return convenio;
	}
	
	public void setConvenio(int convenio) {
		this.convenio = convenio;
	}
	
	public void setPercDesconto(int perc) {
		this.percDesconto = perc;
	}
	
	public int getPercDesconto() {
		return percDesconto;
	}
	
	public int getQuantidadeAgen() {
		return quantidadeAgen;
	}

	public void setQuantidadeAgen(int quantidadeAgen) {
		this.quantidadeAgen = quantidadeAgen;
	}

	/**
	 * @author Thulio Barbosa Martins
	 * @param
	 * @descripton Responsavel por criar um vetor com 13 posições, para facilitar o uso da JTable na UI
	*/
	public String[] getVetor() {
		String[] v = new String[13];
		v[0] = String.valueOf(idAgendamento);
		v[1] = String.valueOf(dataAgendamento);
		v[2] = String.valueOf(horario);
		v[3] = String.valueOf(duracao);
		v[4] = cpf;
		v[5] = nomePaciente;
		v[6] = telefone;
		v[7] = String.valueOf(dataNascimento);
		v[8] = nomeProfissional;
		v[9] = tipo;
		v[10] = String.valueOf(valorConsulta);
		v[11] = String.valueOf(percDesconto);
		v[12] = String.valueOf(convenio);
		
		return v;
	}
	
	public static AgendamentoDao getDao() {
		return aDao;
	}
	
	public String getDataString(Date data) {
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}

	public String imprimeRelatorio1() {
		return "\nData agendamento: " + getDataString(getDataAgendamento()) + " | " + " Horario: " + getHorario() +  " | " + " Duração: " +
			   getDuracao() + " | " + " Nome paciente: " + getNomePaciente();
	}
	
	public String imprimeRelatorio2() {
		return "\nNome Profissional: " + getNomeProfissional() + " | " + "Data agendamento: " + getDataString(getDataAgendamento()) + 
				" | " + " Horario: " + getHorario() +  " | " + " Duração: " + getDuracao() + " | " + " Nome paciente: " 
				+ getNomePaciente();
	}
	
	public String imprimeRelatorio4() {
		return "CPF: " + getCpf() + " | " + "Nome paciente: " + getNomePaciente() + " | " + 
			   " Telefone: " + getTelefone() + " | " + " Data nascimento: " + getDataString(getDataNascimento()) +
			   " | " + " Idade: " + getIdade();
	}
	
	public String imprimeRelatorio5() {
		return "Nome profissional: " + getNomeProfissional();
	}
	
	public String imprimeRelatorio6() {
		return "Quantidade: " + getQuantidadeAgen();
	}
	
	public String imprimeRelatorio7() {
		return "Tipo: " + getTipo() + " | " + " Valor Médio: " + getValorConsulta() + " | " + "Quantidade: " + getQuantidadeAgen() ;
	}
	
	public String imprimeRelatorio8() {
		return "Nome do Profissional: " + getNomeProfissional() + " | " + " Valor total: " + getValorConsulta();
	}
	
	public String imprimeRelatorio9() {
		return "Quantidade de agendamentos: " + getQuantidadeAgen() + " | " + " Valor Total: " + getValorConsulta(); 
	}	
	
	public String imprimeRelatorio10() {
		return "Nome profissional: " + getNomeProfissional() + " | " + " Quantidade de consultas: " + getQuantidadeAgen();
	}
}