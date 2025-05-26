package dal;

import entidades.Instrumento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexao.ModuloConexao;

public class InstrumentoDAO {

	public boolean salvar(Instrumento instrumento) {
	    String sqlProduto = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";
	    String sqlInstrumento = "INSERT INTO instrumentos (id, marca, modelo) VALUES (?, ?, ?)";
	    try (Connection conn = ModuloConexao.conector()) {
	        conn.setAutoCommit(false);      
	        try (PreparedStatement psProduto = conn.prepareStatement(sqlProduto, Statement.RETURN_GENERATED_KEYS)) {
	            psProduto.setString(1, instrumento.getNome());
	            psProduto.setDouble(2, instrumento.getPreco());
	            psProduto.executeUpdate();
	            ResultSet rs = psProduto.getGeneratedKeys();
	            if (rs.next()) {
	                int idProduto = rs.getInt(1);
	                try (PreparedStatement psInstrumento = conn.prepareStatement(sqlInstrumento)) {
	                    psInstrumento.setInt(1, idProduto);
	                    psInstrumento.setString(2, instrumento.getMarca());
	                    psInstrumento.setString(3, instrumento.getModelo());
	                    psInstrumento.executeUpdate();
	                }
	            } else {
	                conn.rollback();
	                return false;
	            }
	            conn.commit();
	            return true;
	        } catch (Exception e) {
	            conn.rollback();
	            System.out.println("Erro ao salvar no banco: " + e.getMessage());
	            return false;
	        }
	    } catch (Exception e) {
	        System.out.println("Erro na conexão: " + e.getMessage());
	        return false;
	    }
	}
	
	public List<Instrumento> listarTodos() {
	    List<Instrumento> lista = new ArrayList<>();
	    String sql = "SELECT p.id, p.nome, p.preco, i.marca, i.modelo " +
	                 "FROM produtos p JOIN instrumentos i ON p.id = i.id";
	    try (Connection conn = ModuloConexao.conector();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nome = rs.getString("nome");
	            double preco = rs.getDouble("preco");
	            String marca = rs.getString("marca");
	            String modelo = rs.getString("modelo");
	            Instrumento instrumento = new Instrumento(nome, preco, marca, modelo);
	            instrumento.setId(id);
	            lista.add(instrumento);
	        }
	    } catch (Exception e) {
	        System.out.println("Erro ao listar instrumentos: " + e.getMessage());
	    }
	    return lista;
	}
	
	public boolean remover(int id) {
	    String sql = "DELETE FROM produtos WHERE id = ?";
	    try (Connection conn = ModuloConexao.conector();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        int rows = ps.executeUpdate();
	        return rows > 0;
	    } catch (Exception e) {
	        System.out.println("Erro ao remover instrumento: " + e.getMessage());
	        return false;
	    }
	}
	
	public boolean atualizar(int id, Instrumento inst) {
	    String sqlProduto = "UPDATE produtos SET nome = ?, preco = ? WHERE id = ?";
	    String sqlInstrumento = "UPDATE instrumentos SET marca = ?, modelo = ? WHERE id = ?";
	    try (Connection conn = ModuloConexao.conector()) {
	        try (PreparedStatement psProduto = conn.prepareStatement(sqlProduto)) {
	            psProduto.setString(1, inst.getNome());
	            psProduto.setDouble(2, inst.getPreco());
	            psProduto.setInt(3, id);
	            psProduto.executeUpdate();
	        }
	        try (PreparedStatement psInstrumento = conn.prepareStatement(sqlInstrumento)) {
	            psInstrumento.setString(1, inst.getMarca());
	            psInstrumento.setString(2, inst.getModelo());
	            psInstrumento.setInt(3, id);
	            int linhasAfetadas = psInstrumento.executeUpdate();
	            return linhasAfetadas > 0;
	        }
	    } catch (Exception e) {
	        System.out.println("Erro ao atualizar instrumento: " + e.getMessage());
	        return false;
	    }
	}
	
}