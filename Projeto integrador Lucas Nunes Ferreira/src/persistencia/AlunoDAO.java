package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDAO {

	private ConexaoMysql conexao;

	public AlunoDAO() {
		this.conexao = new ConexaoMysql("root", "alunoinfo", "localhost", "3306", "monitorias");
	}

	public Aluno salvar(Aluno aluno) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO aluno VALUES(null, ?, ?, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getMatricula());
			statement.setString(3, aluno.getSenha());
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					aluno.setIdAluno(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return aluno;
	}

	public void editar(Aluno aluno) {
		this.conexao.abrirConexao();
		String sql = "UPDATE aluno SET nome = ?, email = ?, senha = ? WHERE id_aluno = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setString(1, aluno.getNome());
			statement.setString(2, aluno.getMatricula());
			statement.setString(3, aluno.getSenha());
			statement.setLong(4, aluno.getIdAluno());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sql = "DELETE FROM aluno WHERE id_aluno = ?";
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

	public Aluno buscarPorId(long id) {
		Aluno aluno = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM aluno WHERE id_aluno = ?";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				aluno = new Aluno();
				aluno.setIdAluno(rs.getLong("id_aluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return aluno;
	}

	public List<Aluno> buscarTodos() {
		List<Aluno> listaAluno = new ArrayList<>();
		Aluno aluno = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM aluno";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				aluno = new Aluno();
				aluno.setIdAluno(rs.getLong("id_aluno"));
				aluno.setNome(rs.getString("nome"));
				aluno.setMatricula(rs.getString("matricula"));
				aluno.setSenha(rs.getString("senha"));
				listaAluno.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaAluno;
	}

}
