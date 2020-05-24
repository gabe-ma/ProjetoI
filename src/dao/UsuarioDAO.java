package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Carteira;
import model.Usuarios;

public class UsuarioDAO {
	
	public int criar(Usuarios usuario) {
		CarteiraDAO dao = new CarteiraDAO();
		String sqlInsert;
		if (usuario.getTipoUsuario() == 2) {
			sqlInsert = "INSERT INTO usuario(nome, email, senha, idtipo_de_usuario, idconta_bancaria, idcarteira) VALUES (?, ?, ?, ?, ?, ?)";
		} else {
			sqlInsert = "INSERT INTO usuario(nome, email, senha, idtipo_de_usuario, idconta_bancaria) VALUES (?, ?, ?, ?, ?)";
		}
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setInt(4, usuario.getTipoUsuario());
			stm.setInt(5, usuario.getContaBancaria());
			if (usuario.getTipoUsuario() == 2) {
				Carteira cart = new Carteira();
				dao.criar(cart);
				stm.setInt(6, cart.getIdCarteira());
			}
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setIdUsuario(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getIdUsuario();
	}

	public Usuarios carregar(String email) {
		Usuarios usuario = new Usuarios();
		usuario.setEmail(email);
		String sqlSelect = "SELECT nome, senha, idtipo_de_usuario, idconta_bancaria, idcarteira FROM usuario WHERE email = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getEmail());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setTipoUsuario(rs.getInt("idtipo_de_usuario"));
					usuario.setContaBancaria(rs.getInt("idconta_bancaria"));
					usuario.setCarteira(rs.getInt("idcarteira"));
				} else {
					usuario.setNome(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	public Usuarios login(String email, String senha) {
		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		Usuarios usuario = new Usuarios();

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sql);) {
			
			stm.setString(1, email);
			stm.setString(2, senha);

			ResultSet rs = stm.executeQuery();

			if(rs.next()) {
				usuario.setIdUsuario(rs.getInt("idusuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTipoUsuario(rs.getInt("idtipo_de_usuario"));
				usuario.setContaBancaria(rs.getInt("idconta_bancaria"));
				usuario.setCarteira(rs.getInt("idcarteira"));
			} else {
				usuario.setIdUsuario(0);
				usuario.setNome(null);
				usuario.setEmail(null);
				usuario.setSenha(null);
				usuario.setTipoUsuario(0);
				usuario.setContaBancaria(0);
				usuario.setCarteira(0);
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}
}
