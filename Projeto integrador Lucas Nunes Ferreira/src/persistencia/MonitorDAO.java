package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Monitor;

public class MonitorDAO {

	private ConexaoMysql conexao;

	public MonitorDAO() {
		this.conexao = new ConexaoMysql("root", "alunoinfo", "localhost", "3306", "monitorias");
	}

	public Monitor salvar(Monitor monitor) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO monitor VALUES(null, ?, ?, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, monitor.getNome());
			statement.setString(2, monitor.getMatricula());
			statement.setString(3, monitor.getSenha());
			statement.setLong(6, monitor.getDisciplina().getIdDisciplina());
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					monitor.setIdMonitor(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return monitor;
	}

	public void editar(Monitor monitor) {
		this.conexao.abrirConexao();
		String sql = "UPDATE monitor SET nome = ?, email = ?, senha = ? WHERE id_monitor = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, monitor.getNome());
			statement.setString(2, monitor.getMatricula());
			statement.setString(3, monitor.getSenha());
			statement.setLong(4, monitor.getIdMonitor());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sql = "DELETE FROM monitor WHERE id_prrofessor = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public Monitor buscarPorId(long id) {
		Monitor monitor = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM monitor WHERE id_monitor = ?";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				monitor = new Monitor();
				monitor.setIdMonitor(rs.getLong("id_monitor"));
				monitor.setNome(rs.getString("nome"));
				monitor.setMatricula(rs.getString("matricula"));
				monitor.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return monitor;
	}

	public List<Monitor> buscarTodos() {
		List<Monitor> listaMonitor = new ArrayList<>();
		Monitor monitor = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM monitor";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				monitor = new Monitor();
				monitor.setIdMonitor(rs.getLong("id_monitor"));
				monitor.setNome(rs.getString("nome"));
				monitor.setMatricula(rs.getString("matricula"));
				monitor.setSenha(rs.getString("senha"));
				listaMonitor.add(monitor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaMonitor;
	}

}
