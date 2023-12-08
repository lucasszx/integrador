package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Professor;

public class ProfessorDAO {

	private ConexaoMysql conexao;

	public ProfessorDAO() {
		this.conexao = new ConexaoMysql("root", "alunoinfo", "localhost", "3306", "monitorias");
	}

	public Professor salvar(Professor professor) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO professor VALUES(null, ?, ?, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, professor.getNome());
			statement.setString(2, professor.getMatricula());
			statement.setString(3, professor.getSenha());
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					professor.setIdProfessor(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return professor;
	}

	public void editar(Professor professor) {
		this.conexao.abrirConexao();
		String sql = "UPDATE professor SET nome = ?, email = ?, senha = ? WHERE id_professor = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, professor.getNome());
			statement.setString(2, professor.getMatricula());
			statement.setString(3, professor.getSenha());
			statement.setLong(4, professor.getIdProfessor());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sql = "DELETE FROM professor WHERE id_prrofessor = ?";
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

	public Professor buscarPorId(long id) {
		Professor professor = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM professor WHERE id_professor = ?";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				professor = new Professor();
				professor.setIdProfessor(rs.getLong("id_professor"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return professor;
	}

	public List<Professor> buscarTodos() {
		List<Professor> listaProfessor = new ArrayList<>();
		Professor professor = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM professor";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				professor = new Professor();
				professor.setIdProfessor(rs.getLong("id_professor"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));
				professor.setSenha(rs.getString("senha"));
				listaProfessor.add(professor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaProfessor;
	}

}
