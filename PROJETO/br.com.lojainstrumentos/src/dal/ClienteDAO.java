package dal;

import entidades.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexao.ModuloConexao;

public class ClienteDAO {

    public boolean salvar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, idade, email, cpf, telefone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ModuloConexao.conector();
             PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, cliente.getNome());
            pst.setInt(2, cliente.getIdade());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getCpf());
            pst.setString(5, cliente.getTelefone());

            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                return false;
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cliente.setId(generatedKeys.getInt(1));
                }
            }

            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try (Connection conn = ModuloConexao.conector();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("idade"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("telefone")
                );
                cliente.setId(rs.getInt("id"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = ModuloConexao.conector();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, id);
            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao remover cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(int id, Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, idade = ?, email = ?, cpf = ?, telefone = ? WHERE id = ?";
        try (Connection conn = ModuloConexao.conector();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, cliente.getNome());
            pst.setInt(2, cliente.getIdade());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getCpf());
            pst.setString(5, cliente.getTelefone());
            pst.setInt(6, id);

            int affectedRows = pst.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        }
    }
}