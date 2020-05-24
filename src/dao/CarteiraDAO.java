package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Carteira;
import model.Usuarios;

public class CarteiraDAO {

	public int criar(Carteira cart) {
		String sqlCarteira = "INSERT INTO carteira (saldo) values (?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stmCart = conn.prepareStatement(sqlCarteira);) {
			stmCart.setDouble(1, 00.00);
			stmCart.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					cart.setIdCarteira(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cart.getIdCarteira();
	}

	public Carteira verificarSaldo(Usuarios usuario, Carteira cart) {
		
		String sqlSaldo = "SELECT saldo FROM carteira WHERE idcarteira = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm2 = conn.prepareStatement(sqlSaldo);){
			stm2.setInt(1, usuario.getCarteira());
			try (ResultSet rs2 = stm2.executeQuery();){
				if (rs2.next()) {
					cart.setSaldo(rs2.getDouble("saldo"));
				} else {
					cart.setSaldo(0.00);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
	}

	public void retirarDinheiro(Usuarios usuario) {
		String sqlUp = "UPDATE carteira SET saldo = 0.00 WHERE idcarteira = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUp);){
			stm.setInt(1, usuario.getCarteira());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
