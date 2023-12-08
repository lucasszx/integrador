package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

public class DisciplinaDAO {

	private ConexaoMysql conexao;

	public DisciplinaDAO() {
		this.conexao = new ConexaoMysql("root", "alunoinfo", "localhost", "3306", "monitorias");
	}

	public Disciplina salvar(Disciplina disciplina) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO disciplina VALUES(null, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, disciplina.getNome());
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					disciplina.setIdDisciplina(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return disciplina;
	}

	public void editar(Disciplina disciplina) {
		this.conexao.abrirConexao();
		String sql = "UPDATE disciplina SET nome = ?, WHERE id_disciplina = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, disciplina.getNome());
			statement.setLong(4, disciplina.getIdDisciplina());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public Disciplina buscarPorId(long id) {
		Disciplina disciplina = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM disciplina WHERE id_disciplina = ?";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNome(rs.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return disciplina;
	}

	public List<Disciplina> buscarTodos() {
		List<Disciplina> listaDisciplina = new ArrayList<>();
		Disciplina disciplina = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM disciplina";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				disciplina = new Disciplina();
				disciplina.setIdDisciplina(rs.getLong("id_disciplina"));
				disciplina.setNome(rs.getString("nome"));
				listaDisciplina.add(disciplina);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDisciplina;
	}

}
