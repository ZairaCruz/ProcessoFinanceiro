package com.pcsistemas.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pcsistemas.controle.PessoaControle;
import com.pcsistemas.modelo.Titulo;

public class TituloDao {

	public static List<Titulo> listaTitulos() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Titulo> lista = new ArrayList<Titulo>();
		String sql = "select id, numero, dtCriacao, dtVencimento, vlTitulo, txJuro, "
				+ "vlJuro, vlDesconto, dtPagamento, vlPago, tipo, cnpj from titulo order by numero";
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Titulo titulo = new Titulo();
				titulo.setId(rs.getLong("id"));
				titulo.setNumero(rs.getInt("numero"));
				titulo.setDtCriacao(rs.getDate("dtCriacao"));
				titulo.setDtVencimento(rs.getDate("dtVencimento"));
				titulo.setVlTitulo(rs.getFloat("vltitulo"));
				titulo.setTxJuro(rs.getFloat("txJuro"));
				titulo.setVlJuro(rs.getFloat("vlJuro"));
				titulo.setVlDesconto(rs.getFloat("vlDesconto"));
				titulo.setDtPagamento(rs.getDate("dtPagamento"));
				titulo.setVlPago(rs.getFloat("vlpago"));
				titulo.setTipo(rs.getString("tipo"));
				titulo.setPessoa(new PessoaControle().buscarCpnj(rs.getString("cnpj")));
			}
			return lista;
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro ao listar: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
			return null;
		}
	}

	public static void inserir(Titulo titulo) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into titulo (numero, dtCriacao, dtVencimento, vlTitulo, txJuro, "
				+ " tipo, cnpj) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, titulo.getNumero());
			ps.setDate(2, new Date(titulo.getDtCriacao().getTime()));
			ps.setDate(3, new Date(titulo.getDtVencimento().getTime()));
			ps.setFloat(4, titulo.getVlTitulo());
			ps.setFloat(5, titulo.getTxJuro());
			ps.setString(6, titulo.getTipo());
			ps.setString(7, titulo.getPessoa().getCnpj());
			ps.executeUpdate();
			System.out.println("Inserido com sucesso!");// apenas para teste
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro ao inserir: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		}
	}

	public static void baixar(Titulo titulo) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update titulo set txJuro = ?, vlJuro = ?, vlDesconto = ?, "
				+ "dtPagamento = ?, vlPago = ? WHERE id = ?";

		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setFloat(1, titulo.getTxJuro());
			ps.setFloat(2, titulo.getVlJuro());
			ps.setFloat(3, titulo.getVlDesconto());
			ps.setDate(4, new Date(titulo.getDtPagamento().getTime()));
			ps.setFloat(5, titulo.getVlPago());
			ps.setLong(6, titulo.getId());
			ps.executeUpdate();
			System.out.println("Alterada com sucesso");// apenas para teste
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro ao fazer update: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		}
	}

	public static Titulo buscarPorNumero(int numero) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT numero, id, dtcriacao, dtnascimento, vltitulo, txjuro, cnpj "
				+ " from titulo WHERE numero = ? ;";
		Titulo titulo = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, titulo.getNumero());
			rs = ps.executeQuery();
			while (rs.next()) {
				titulo = new Titulo();
				titulo.setNumero(rs.getInt("numero"));
				titulo.setId(rs.getLong("id"));
				titulo.setDtCriacao(rs.getDate("dtcriacao"));
				titulo.setDtVencimento(rs.getDate("dtvencimento"));
				titulo.setVlTitulo(rs.getFloat("vltitulo"));
				titulo.setTxJuro(rs.getFloat("txjuro"));
				titulo.setPessoa(new PessoaControle().buscarCpnj(rs.getString("cnpj")));
			}
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		} 
		return titulo;
	}

	public static void inativar(Titulo titulo) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update titulo SET cnpj = ?, dtnascimento = ?, cep = ?, logradouro = ?, "
				+ "numero = ?, bairro = ?, cidade = ?, uf = ? WHERE nome = ?";
		try {
			// conn = ConnectionFactory.getConnection();
			// ps = conn.prepareStatement(sql);
			// ps.setString(1, pessoa.getCnpj());
			// ps.setDate(2, new Date(pessoa.getDtNascimento().getTime()));
			// ps.setString(3, pessoa.getCep());
			// ps.setString(4, pessoa.getLogradouro());
			// ps.setInt(5, pessoa.getNumero());
			// ps.setString(6, pessoa.getBairro());
			// ps.setString(7, pessoa.getCidade());
			// ps.setString(8, pessoa.getUf());
			// ps.setString(9, pessoa.getNome());
			// ps.executeUpdate();
			System.out.println("Excluido com sucesso1");// apenas para teste
		} catch (Exception e) {
			System.err.println("---------------------");
			System.err.println("Erro ao excluir: " + e.getMessage());
			e.printStackTrace();
			System.err.println("---------------------");
		}
	}

	// ps.setFloat(6, titulo.getVlJuro());
	// ps.setFloat(7, titulo.getVlDesconto());
	// java.sql.Date dataPagamento = new
	// java.sql.Date(titulo.getDtPagamento().getTime());
	// ps.setDate(8, dataPagamento);
	// ps.setFloat(9, titulo.getVlPago());
}
