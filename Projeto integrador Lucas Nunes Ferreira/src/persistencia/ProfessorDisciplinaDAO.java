package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ProfessorDisciplina;

public class ProfessorDisciplinaDAO {

	private ConexaoMysql conexao;

	public ProfessorDisciplinaDAO() {
		this.conexao = new ConexaoMysql("root", "alunoinfo", "localhost", "3306", "monitorias");
	}

	public ProfessorDisciplina salvar(ProfessorDisciplina professorDisciplina) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO professor VALUES(null, ?, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setLong(1, professorDisciplina.getProfessor().getIdProfessor());
			statement.setLong(2, professorDisciplina.getDisciplina().getIdDisciplina());
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					professorDisciplina.setIdProfessorDisciplina(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return professorDisciplina;
	}
}
