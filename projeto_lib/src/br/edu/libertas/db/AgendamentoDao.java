package br.edu.libertas.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import br.edu.libertas.dto.Agendamento;
import jdk.jfr.Description;

import java.sql.Date;

public class AgendamentoDao {
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param a
	 * @description Responsavel por adicionar agendamentos ao banco de dados
	*/
	public void addAgendamento(Agendamento a) {
		try {
			Conexao con = new Conexao();

			String sql = "INSERT INTO agendamento(dataAgendamento, horario, duracao, cpf, nomePaciente, telefone," +
					     "dataNascimento, nomeProfissional, tipo, valorConsulta, percDesconto, convenio)" +
					     "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement instrucao = con.getConexao().prepareStatement(sql);
			instrucao.setDate(1, a.getDataAgendamento());
			
			//instrucao.setDate(1, Date.valueOf(a.getDataAgendamento()));
			instrucao.setTime(2, a.getHorario());
			instrucao.setDouble(3, a.getDuracao());
			instrucao.setString(4, a.getCpf());
			instrucao.setString(5, a.getNomePaciente());
			instrucao.setString(6, a.getTelefone());
			instrucao.setDate(7, a.getDataNascimento());
			instrucao.setString(8, a.getNomeProfissional());
			instrucao.setString(9, a.getTipo());
			instrucao.setDouble(10, a.getValorConsulta());
			instrucao.setInt(11, a.getPercDesconto());
			instrucao.setInt(12, a.getConvenio());
			
			instrucao.execute();
			
			instrucao.close();
			con.getConexao().close();	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param a
	 * @description Responsavel por alterar agendamentos no banco de dados
	*/
	public void alteraAgendamento(Agendamento a) {
		try {
			Conexao con = new Conexao();
	
			String sql = "UPDATE agendamento SET dataAgendamento = ?," +
						 	" horario = ?," +
						 	" duracao = ?," +
						 	" cpf = ?," +
						 	" nomePaciente = ?," +
							" telefone = ?," + 
							" dataNascimento = ?," +
							" nomeProfissional = ?," +
							" tipo = ?," +
							" valorConsulta = ?," +
							" percDesconto = ?," +
							" convenio = ?" +
						" WHERE idAgendamento = ?";
			
			PreparedStatement instrucao = con.getConexao().prepareStatement(sql);
			
			instrucao.setDate(1, a.getDataAgendamento());
			instrucao.setTime(2, a.getHorario());
			instrucao.setDouble(3, a.getDuracao());
			instrucao.setString(4, a.getCpf());
			instrucao.setString(5, a.getNomePaciente());
			instrucao.setString(6, a.getTelefone());
			instrucao.setDate(7, a.getDataNascimento());
			instrucao.setString(8, a.getNomeProfissional());
			instrucao.setString(9, a.getTipo());
			instrucao.setDouble(10, a.getValorConsulta());
			instrucao.setInt(11, a.getPercDesconto());
			instrucao.setInt(12, a.getConvenio());
			instrucao.setInt(13, a.getIdAgendamento());
			
			instrucao.execute();
			
			//instrucao.close();
			con.getConexao().close();	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param a
	 * @description Responsavel por remover agendamentos no banco de dados
	*/
	public void removeAgendamento(Agendamento a) {
		 try {
			 	Conexao con = new Conexao();
				
				String sql = "DELETE FROM agendamento WHERE idAgendamento = ?"; 
				
				PreparedStatement instrucao = con.getConexao().prepareStatement(sql);
				
				instrucao.setInt(1, a.getIdAgendamento());
				instrucao.execute();
				
		        instrucao.close();
				con.getConexao().close();
		 } 
		 catch (Exception e) {
		    	e.printStackTrace();
		 }
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param id
	 * @description Consulta agendamento filtrando referente ao paramento passado
	*/
	public Agendamento consultaAgendamento(int id) {
		
		Agendamento a = new Agendamento();
		
		 try {
			 	Conexao con = new Conexao();
				
				String sql = "SELECT * FROM agendamento WHERE idAgendamento = " + id; 
				
				Statement instrucao = con.getConexao().createStatement();
				ResultSet res = instrucao.executeQuery(sql);
				
				if(res.next()) {
					a.setIdAgendamento(res.getInt("idAgendamento"));
					a.setDataAgendamento(res.getDate("dataAgendamento"));
					//a.setDataAgendamento(res.getDate("dataAgendamento").toLocalDate());
					a.setHorario(res.getTime("horario"));
					a.setDuracao(res.getDouble("duracao"));
					a.setCpf(res.getString("cpf"));
					a.setNomePaciente(res.getString("nomePaciente"));
					a.setTelefone(res.getString("telefone"));
					a.setDataNascimento(res.getDate("dataNascimento"));
					a.setNomeProfissional(res.getString("nomeProfissional"));
					a.setTipo(res.getString("tipo"));
					a.setValorConsulta(res.getDouble("valorConsulta"));
					a.setPercDesconto(res.getInt("percDesconto"));
					a.setConvenio(res.getInt("convenio"));
				}
				else {
					JOptionPane.showMessageDialog(null, "ID de agendamento não cadastrado!");
				}
				
				con.getConexao().close();	
		 } 
		 catch (Exception e) {
		    	e.printStackTrace();
		 }
		 
		 return a;
		 
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param 
	 * @description Responsavel por listas todos agendamentos que cadastrado ao banco de dados
	*/
	public List<Agendamento> listaAgendamento() {
		List<Agendamento> ag = new LinkedList<Agendamento>();
		
		try {
			Conexao con = new Conexao();
			
			String sql = "SELECT idAgendamento," +
					   		" dataAgendamento," +
					   		" horario," +
					   		" duracao," +
					   		" cpf," +
					   		" nomePaciente," +
					   		" telefone," +
							" dataNascimento," +
							" nomeProfissional," +
							" tipo," +
							" valorConsulta," +
							" percDesconto," +
							" convenio" +
						" FROM agendamento" + 
					    " ORDER BY dataAgendamento";
			
			Statement instrucao = con.getConexao().createStatement();
			
			ResultSet res = instrucao.executeQuery(sql);
			
			while (res.next()) {
				Agendamento a = new Agendamento();
				a.setIdAgendamento(res.getInt("idAgendamento"));
				a.setDataAgendamento(res.getDate("dataAgendamento"));
				a.setHorario(res.getTime("horario"));
				a.setDuracao(res.getDouble("duracao"));
				a.setCpf(res.getString("cpf"));
				a.setNomePaciente(res.getString("nomePaciente"));
				a.setTelefone(res.getString("telefone"));
				a.setDataNascimento(res.getDate("dataNascimento"));
				a.setNomeProfissional(res.getString("nomeProfissional"));
				a.setTipo(res.getString("tipo"));
				a.setValorConsulta(res.getDouble("valorConsulta"));
				a.setPercDesconto(res.getInt("percDesconto"));
				a.setConvenio(res.getInt("convenio"));
				ag.add(a);
				
				con.getConexao().close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ag;
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param dataInicial, dataFinal
	 * @description Responsavel por consultar agendamentos entre o período passsado
	*/
	public List<Agendamento> consulta02(Date dataInicial, Date dataFinal) {
		
		List<Agendamento> dados = new LinkedList<Agendamento>(); 
		
		try {
			
			Conexao con = new Conexao();
			
			String sql = "SELECT nomeProfissional, dataAgendamento, horario, duracao, nomePaciente " +
					     " FROM agendamento " +
					     " WHERE dataAgendamento BETWEEN + '" + dataInicial + "' AND '" + dataFinal + "'" +
						 " ORDER BY nomeProfissional ";
			
			Statement instrucao = con.getConexao().createStatement();
			
			ResultSet res = instrucao.executeQuery(sql);
			
			while (res.next()) {
				Agendamento a = new Agendamento();
				
				a.setNomeProfissional(res.getString("NomeProfissional"));
				a.setDataAgendamento(res.getDate("dataAgendamento"));
				a.setHorario(res.getTime("horario"));
				a.setDuracao(res.getDouble("duracao"));
				a.setNomePaciente(res.getString("nomePaciente"));
				
				dados.add(a);
				
				//res.close();
				con.getConexao().close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param dataInicial, dataFinal, tipo
	 * @description Responsavel por consultar agendamentos entre o período e o tipo passsado
	*/
	public List<Agendamento> consulta03(Date dataInicial, Date dataFinal, String tipo) {
			
			List<Agendamento> dados = new LinkedList<Agendamento>(); 
			
			try {
				
				Conexao con = new Conexao();
				
				String sql = "SELECT nomeProfissional, dataAgendamento, horario, duracao, nomePaciente " +
						     " FROM agendamento " +
						     " WHERE dataAgendamento BETWEEN + '" + dataInicial + "' AND '" + dataFinal + "'" +
						     " AND tipo = '" + tipo + "'" +
							 " ORDER BY dataAgendamento DESC, " +
						     " horario";
				
				Statement instrucao = con.getConexao().createStatement();
				
				ResultSet res = instrucao.executeQuery(sql);
				
				while (res.next()) {
					Agendamento a = new Agendamento();
					
					a.setNomeProfissional(res.getString("NomeProfissional"));
					a.setDataAgendamento(res.getDate("dataAgendamento"));
					a.setHorario(res.getTime("horario"));
					a.setDuracao(res.getDouble("duracao"));
					a.setNomePaciente(res.getString("nomePaciente"));
					
					dados.add(a);
			
					con.getConexao().close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dados;
		}

	/**
	 * @author Thulio Barbosa Martins
	 * @param mes
	 * @description Responsavel por consultar pacientes que nasceram no mês do parametro passado
	*/
	public List<Agendamento> consulta04(int mes) {
		
		List<Agendamento> dados = new LinkedList<Agendamento>(); 
		
		try {
			
			Conexao con = new Conexao();
			
			String sql = "SELECT cpf," +
						" nomePaciente," +
						" telefone," +
						" dataNascimento," + 
						" (TIMESTAMPDIFF(YEAR, dataNascimento, CURDATE())) AS idade " +
						" FROM agendamento " +
						" WHERE MONTH(dataNascimento) = '" + mes + "'";
			
			Statement instrucao = con.getConexao().createStatement();
			
			ResultSet res = instrucao.executeQuery(sql);
			
			while (res.next()) {
				Agendamento a = new Agendamento();
				
				a.setCpf(res.getString("cpf"));
				a.setNomePaciente(res.getString("nomePaciente"));
				a.setTelefone(res.getString("telefone"));
				a.setDataNascimento(res.getDate("dataNascimento"));
				a.setIdade(res.getInt("idade"));
				
				dados.add(a);
		
				con.getConexao().close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}

	/**
	 * @author Thulio Barbosa Martins
	 * @param caracters
	 * @description Responsavel por consultar profissional que contém os caracters passados em seu nome
	*/
	public List<Agendamento> consulta05(String caracters) {
		
		List<Agendamento> dados = new LinkedList<Agendamento>(); 
		
		try {
			
			Conexao con = new Conexao();
			
			String sql = "SELECT nomeProfissional" +
						 " FROM agendamento" +
						 " WHERE nomeProfissional LIKE '%" + caracters + "%'" +
						 " ORDER BY nomeProfissional";
			
			Statement instrucao = con.getConexao().createStatement();
			
			ResultSet res = instrucao.executeQuery(sql);
			
			while (res.next()) {
				Agendamento a = new Agendamento();
				
				a.setNomeProfissional(res.getString("nomeProfissional"));
				
				dados.add(a);
		
				con.getConexao().close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param 
	 * @description Responsavel por consultar todos agendamento que não tem desconto e nem convenio 
	*/
	public int consulta06() {
	
		int quantidade = 0; 
		
		try {
			
			Conexao con = new Conexao();
			
			String sql = "SELECT idAgendamento, COUNT(*) AS quantidade FROM agendamento" + 
						 " WHERE percDesconto != 0" + 
					     " AND convenio = 0";
			
			Statement instrucao = con.getConexao().createStatement();
			
			ResultSet res = instrucao.executeQuery(sql);
			
			 
			 while (res.next()) {
				 
				 quantidade = res.getInt("quantidade");

				con.getConexao().close();
			}
		}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		return quantidade;
	}

	/**
	 * @author Thulio Barbosa Martins
	 * @param 
	 * @description Responsavel por consultar tipos de profissionais realizando a média e quantidade de consultas de cada tipo
	*/
	public List<Agendamento> consulta07() {
		
		List<Agendamento> dados = new LinkedList<Agendamento>();
		
		try {
			
			Conexao con = new Conexao();
			
			String sql = "SELECT tipo, AVG(valorConsulta) AS media, COUNT(*) AS quantidade " +
						 " FROM agendamento" +
					     " GROUP BY tipo" +
					     " ORDER BY tipo";
			
			Statement instrucao = con.getConexao().createStatement();
			
			ResultSet res = instrucao.executeQuery(sql);
			
			 
			 while (res.next()) {
				 
				 Agendamento a = new Agendamento();
				 
				 a.setTipo(res.getString("tipo"));
				 a.setValorConsulta(res.getDouble("media"));
				 a.setQuantidadeAgen(res.getInt("quantidade"));
				 
				 dados.add(a);
	
				 con.getConexao().close();
			}
		}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param 
	 * @description Responsavel por consultar valores de consulta dos profissionais
	*/
	public List<Agendamento> consulta08() {
		
		List<Agendamento> dados = new LinkedList<Agendamento>();
		
		try {
			
			Conexao con = new Conexao();
			
			String sql = "SELECT nomeProfissional, SUM(valorConsulta)  AS valorTotal " + 
						" FROM agendamento" +
						" GROUP BY nomeProfissional" +
						" HAVING SUM(valorConsulta) > 500"; 
			
			Statement instrucao = con.getConexao().createStatement();
			
			ResultSet res = instrucao.executeQuery(sql);
			
			 
			 while (res.next()) {
				 
				 Agendamento a = new Agendamento();
				 
				 a.setNomeProfissional(res.getString("nomeProfissional"));
				 a.setValorConsulta(res.getDouble("valorTotal"));
				 
				 dados.add(a);
	
				 con.getConexao().close();
			}
		}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param mes
	 * @description Responsavel por consultar e calcular os valores de consultas de cada profissional
	*/
	public List<Agendamento> consulta09(int mes) {
		
		List<Agendamento> dados = new LinkedList<Agendamento>();
		
		try {
			
			Conexao con = new Conexao();
			
			String sql = " SELECT COUNT(*) AS qtdConsultas, SUM((valorConsulta - ((valorConsulta * percDesconto)/100)))" +
						" AS valorTotal" +
						" FROM agendamento" +
						" WHERE MONTH(dataAgendamento) = '" + mes + "'"; 
			
			Statement instrucao = con.getConexao().createStatement();
			
			ResultSet res = instrucao.executeQuery(sql);
			 
			 while (res.next()) {
				 
				 Agendamento a = new Agendamento();
				 
				 a.setQuantidadeAgen(res.getInt("qtdConsultas"));
				 a.setValorConsulta(res.getDouble("valorTotal"));
				 
				 if (a.getQuantidadeAgen() > 0) {
					 dados.add(a);
				 }
				 
				 con.getConexao().close();
			}
		}
			
		catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}
	
	/**
	 * @author Thulio Barbosa Martins
	 * @param mes
	 * @description Responsavel por consultar profissionais com no minino 10 agendamentos em um determinao mês 
	*/
	public List<Agendamento> consulta10(int mes) {
			
			List<Agendamento> dados = new LinkedList<Agendamento>();
			
			try {
				
				Conexao con = new Conexao();
				
				String sql = "SELECT nomeProfissional," +
						" COUNT(*) AS qtdConsultas" +
						" FROM agendamento" +
						" WHERE MONTH(dataAgendamento) = '" + mes + "'" +
						" GROUP BY nomeProfissional" +
						" HAVING qtdConsultas >= 10"+
						" ORDER BY qtdConsultas DESC";
							
				Statement instrucao = con.getConexao().createStatement();
				
				ResultSet res = instrucao.executeQuery(sql);
				 
				 while (res.next()) {
					 
					 Agendamento a = new Agendamento();
					 
					 a.setNomeProfissional(res.getString("nomeProfissional"));
					 a.setQuantidadeAgen(res.getInt("qtdConsultas"));
					 
					 if (a.getQuantidadeAgen() > 0) {
						 dados.add(a);
					 }
					 
					 con.getConexao().close();
				}
			}
				
			catch (Exception e) {
				e.printStackTrace();
			}
			return dados;
		}
	
	}
