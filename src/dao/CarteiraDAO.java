package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Carteira;
import model.Usuarios;

public class CarteiraDAO {

	public Carteira criar() {
		String sqlCarteira = "INSERT INTO carteira (saldo) values (?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stmCart = conn.prepareStatement(sqlCarteira);) {
			stmCart.setDouble(1, 00.00);
			stmCart.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Carteira verificarSaldo(Usuarios usuario, Carteira cart) {
		String sqlIdCart = "SELECT idcarteira FROM usuario WHERE nome = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stmCart = conn.prepareStatement(sqlIdCart);){
			stmCart.setInt(1, usuario.getCarteira());
			try (ResultSet rs = stmCart.executeQuery();){
				if(rs.next()) {
					usuario.setCarteira(rs.getInt("idcarteira"));
				} else {
				usuario.setCarteira(0);
				}
			}
		
		String sqlSaldo = "SELECT saldo FROM carteira WHERE idcarteira = ?";
		try (PreparedStatement stm2 = conn.prepareStatement(sqlSaldo);){
			stm2.setInt(1, usuario.getCarteira());
			try (ResultSet rs2 = stm2.executeQuery();){
				if (rs2.next()) {
					cart.setSaldo(rs2.getDouble("saldo"));
				} else {
					cart.setSaldo(0.00);
				}
			}
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}

	public Carteira retirarDinheiro(Usuarios usuario, Carteira cart) {
		String sqlUp = "UPDATE carteira SET saldo = 0.00 WHERE idcarteira = ?;";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUp);){
			stm.setInt(1, usuario.getCarteira());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}
}
