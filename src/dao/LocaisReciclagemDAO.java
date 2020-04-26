package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LocaisReciclagem;

public class LocaisReciclagemDAO {
	ArrayList<LocaisReciclagem> localLista;
	LocaisReciclagem local;
	
	public List<LocaisReciclagem> carregar(int id) {
		localLista = new ArrayList<LocaisReciclagem>();
		String sqlSelect = "SELECT rua, numero, bairro, telefone, quantidade_lixo_toneladas FROM locais_reciclagem WHERE idlixos_reciclados = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					local = new LocaisReciclagem();
					local.setRua(rs.getString("rua"));
					local.setNumero(rs.getInt("numero"));
					local.setBairro(rs.getString("bairro"));
					local.setTelefone(rs.getString("telefone"));
					local.setQuantLixo(rs.getInt("quantidade_lixo_toneladas"));
					localLista.add(local);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return localLista;
	}
	
}
