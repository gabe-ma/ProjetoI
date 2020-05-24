package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ContaBancaria;
import model.Usuarios;

public class ContaBancariaDAO {

	public int criar(ContaBancaria conta) {
		String sqlInsert = "INSERT INTO conta_bancaria (banco, conta, agencia) values (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, conta.getBanco());
			stm.setString(2, conta.getConta());
			stm.setString(3, conta.getAgencia());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					conta.setIdConta(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conta.getIdConta();
	}
	
	public ContaBancaria carregar(int id) {
		ContaBancaria conta = new ContaBancaria();
		conta.setIdConta(id);
		String sqlSelect = "SELECT banco, conta, agencia FROM conta_bancaria WHERE idconta_bancaria = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, conta.getIdConta());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					conta.setBanco(rs.getString("banco"));
					conta.setConta(rs.getString("conta"));
					conta.setAgencia(rs.getString("agencia"));
				} else {
					conta.setBanco(null);
					conta.setConta(null);
					conta.setAgencia(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return conta;
	}
	
}
