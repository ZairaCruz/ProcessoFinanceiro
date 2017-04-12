package com.pcsistemas.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pcsistemas.modelo.Pessoa;

public class PessoaDao {
	
	public static List<Pessoa> listaPessoas(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select id, cnpj, nome, tipo, dtnascimento, cep, logradouro, "
				+ "numero, bairro, cidade, uf from pessoa order by nome";
		List<Pessoa> lista = new ArrayList<Pessoa>();
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()){
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getLong("id"));
				pessoa.setCnpj(rs.getString("cnpj"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setTipo(rs.getString("tipo"));
				pessoa.setDtNascimento(rs.getDate("dtnascimento"));
				pessoa.setCep(rs.getString("cep"));
				pessoa.setLogradouro(rs.getString("logradouro"));
				pessoa.setNumero(rs.getInt("numero"));
				pessoa.setBairro(rs.getString("bairro"));
				pessoa.setCidade(rs.getString("cidade"));
				pessoa.setUf(rs.getString("uf"));
				lista.add(pessoa); 
			}
			return lista;
		}catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro ao listar: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
			return null;
		} 
	}
	
	public static void inserir(Pessoa pessoa){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into pessoa (cnpj, nome, tipo, dtnascimento, cep, logradouro, "
				+ "numero, bairro, cidade, uf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getCnpj());
			ps.setString(2, pessoa.getNome());
			ps.setString(3, pessoa.getTipo());
			ps.setDate(4, new Date(pessoa.getDtNascimento().getTime()));
			ps.setString(5, pessoa.getCep());
			ps.setString(6, pessoa.getLogradouro());
			ps.setInt(7, pessoa.getNumero());
			ps.setString(8, pessoa.getBairro());
			ps.setString(9, pessoa.getCidade());
			ps.setString(10, pessoa.getUf());
			ps.executeUpdate();
			System.out.println("Inserido com sucesso!");//apenas para teste
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro ao inserir: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} 
	}
	
	public static void alterar(Pessoa pessoa){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update pessoa SET cnpj = ?, dtnascimento = ?, cep = ?, logradouro = ?, "
				+ "numero = ?, bairro = ?, cidade = ?, uf = ?, tipo = ? WHERE id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pessoa.getCnpj());
			ps.setDate(2, new Date(pessoa.getDtNascimento().getTime()));
			ps.setString(3, pessoa.getCep());
			ps.setString(4, pessoa.getLogradouro());
			ps.setInt(5, pessoa.getNumero());
			ps.setString(6, pessoa.getBairro());
			ps.setString(7, pessoa.getCidade());
			ps.setString(8, pessoa.getUf());
			ps.setString(9, pessoa.getNome());
			ps.setLong(10, pessoa.getId());
			ps.setString(11, pessoa.getTipo());
			ps.executeUpdate();
			System.out.println("Alterada com sucesso");//apenas para teste
		} catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro ao fazer update: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} 
	}
	
//	public static void inativar(Pessoa pessoa){
//		Connection conn = null;
//		PreparedStatement ps = null;
//		String sql = "update pessoa SET cnpj = ?, dtnascimento = ?, cep = ?, logradouro = ?, "
//				+ "numero = ?, bairro = ?, cidade = ?, uf = ? WHERE nome = ?";
//		try {
//			conn = ConnectionFactory.getConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, pessoa.getCnpj());
//			ps.setDate(2, new Date(pessoa.getDtNascimento().getTime()));
//			ps.setString(3, pessoa.getCep());
//			ps.setString(4, pessoa.getLogradouro());
//			ps.setInt(5, pessoa.getNumero());
//			ps.setString(6, pessoa.getBairro());
//			ps.setString(7, pessoa.getCidade());
//			ps.setString(8, pessoa.getUf());
//			ps.setString(9, pessoa.getNome());
//			ps.executeUpdate();
//			System.out.println("Excluido com sucesso1");//apenas para teste
//		} catch (Exception e){
//			System.err.println("---------------------");
//			System.err.println("Erro ao excluir: " + e.getMessage());
//			e.printStackTrace();
//			System.err.println("---------------------");
//		} 	
//	}
	
	public static Pessoa cnpj(String cnpj){
		Pessoa pessoa = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select cnpj, nome FROM pessoa WHERE cnpj = ?";
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cnpj);
			rs = ps.executeQuery();
			pessoa = new Pessoa();
			if (rs.next()){
				pessoa.setCnpj(rs.getString("cnpj"));
				pessoa.setNome(rs.getString("nome"));
			}
		}catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro ao buscar cnpj: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
			return null;
		} 
		return pessoa;
	}
	
	public static void buscarCnpjFavorecido(String cnpj){
		Pessoa pessoa = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select cnpj FROM pessoa WHERE cnpj = ?";
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cnpj);
			rs = ps.executeQuery();
			pessoa = new Pessoa();
			if (rs.next()){
				pessoa.setCnpj(rs.getString("cnpj"));
			}
		}catch (Exception e){
			System.err.println("---------------------");
			System.err.println("Erro ao buscar cnpj: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} 

	}
}
