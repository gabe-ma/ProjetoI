package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Carteira;
import model.LocaisReciclagem;
import model.Relatorio;
import model.TipoDeLixo;

public class RelatorioDAO {

	ArrayList<Relatorio> relatorioLista;
	Relatorio relatorio;
	
	public int criar(Relatorio relatorio) {
		String sqlInsert = "INSERT INTO relatorio (bairro, qntLixo, maiorTipoLixo, descricao) values (?,?,?,?)"; 
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, relatorio.getBairro());
			stm.setInt(2, relatorio.getQntLixo());
			stm.setInt(3, relatorio.getMaiorTipoLixo());
			stm.setString(4, relatorio.getDescricao());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					relatorio.setIdRelatorio(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return relatorio.getIdRelatorio();
	}
	
	public List<Relatorio> carregar(String bairro) {
		relatorioLista = new ArrayList<Relatorio>();
		String sqlSelect = "SELECT r.bairro, r.qntLixo, r.maiorTipoLixo, l.tipo_de_lixo, r.descricao FROM relatorio as r INNER JOIN lixos_reciclados as l" + 
				"                on r.maiorTipoLixo = l.idlixos_reciclados WHERE bairro = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, bairro);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					relatorio = new Relatorio();
					TipoDeLixo tipo = new TipoDeLixo();
					relatorio.setBairro(rs.getString("bairro"));
					relatorio.setQntLixo(rs.getInt("qntLixo"));
					relatorio.setMaiorTipoLixo(rs.getInt("maiorTipoLixo"));
					tipo.setId(rs.getInt("maiorTipoLixo"));
					tipo.setTipo_de_lixo(rs.getString("tipo_de_lixo"));
					relatorio.setTipoLixo(tipo);
					relatorio.setDescricao(rs.getString("descricao"));
					relatorioLista.add(relatorio);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return relatorioLista;
	}
	
}
