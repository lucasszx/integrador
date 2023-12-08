package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Agendamento;
import model.Aluno;
import model.Disciplina;
import model.Monitor;
import util.ConversaoDeDataUtil;

public class AgendamentoDAO {

	private ConexaoMysql conexao;

	public AgendamentoDAO() {
		this.conexao = new ConexaoMysql("root", "alunoinfo", "localhost", "3306", "monitorias");
	}

	public Agendamento salvar(Agendamento agendamento) {
		this.conexao.abrirConexao();
		String sql = "INSERT INTO agendamento VALUES(null, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setTimestamp(1, ConversaoDeDataUtil.localDateTimeToTimestamp(agendamento.getHorarioInicio()));
			statement.setTimestamp(2, ConversaoDeDataUtil.localDateTimeToTimestamp(agendamento.getHorarioFim()));
			statement.setString(3, agendamento.getDescricaoFinal());
			statement.setLong(4, agendamento.getAluno().getIdAluno());
			statement.setLong(5, agendamento.getMonitor().getIdMonitor());
			statement.setLong(6, agendamento.getDisciplina().getIdDisciplina());
			int linhasAfetadas = statement.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					agendamento.setIdAgendamento(rs.getLong(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return agendamento;
	}

	public void editar(Agendamento agendamento) {
		this.conexao.abrirConexao();
		String sql = "UPDATE agendamento SET horario_inicio = ?, horario_fim = ?, descricao_final = ?, WHERE id_agendamento = ?";
		try {
			PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
			statement.setTimestamp(1, ConversaoDeDataUtil.localDateTimeToTimestamp(agendamento.getHorarioInicio()));
			statement.setTimestamp(2, ConversaoDeDataUtil.localDateTimeToTimestamp(agendamento.getHorarioFim()));
			statement.setString(3, agendamento.getDescricaoFinal());
			statement.setLong(4, agendamento.getIdAgendamento());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sql = "DELETE FROM agendamento WHERE id_agendamento = ?";
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

	public Agendamento buscarPorId(long id) {
		Agendamento agendamento = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM agendamento WHERE id_agendamento = ?";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				agendamento = new Agendamento();
				agendamento.setIdAgendamento(rs.getLong("id_agendamento"));
				agendamento.setHorarioInicio(
						ConversaoDeDataUtil.timestampToLocalDateTime(rs.getTimestamp("horario_inicio)")));
				agendamento.setHorarioFim(
						ConversaoDeDataUtil.timestampToLocalDateTime(rs.getTimestamp("horario_inicio)")));
				agendamento.setDescricaoFinal(rs.getString("descricao_final"));
				AlunoDAO alunoDAO = new AlunoDAO();
				Aluno aluno = alunoDAO.buscarPorId(rs.getLong("id_aluno"));
				agendamento.setAluno(aluno);
				MonitorDAO monitorDAO = new MonitorDAO();
				Monitor monitor = monitorDAO.buscarPorId(rs.getLong("id_monitor"));
				agendamento.setMonitor(monitor);
				DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
				Disciplina disciplina = disciplinaDAO.buscarPorId(rs.getLong("id_disciplina"));
				agendamento.setDisciplina(disciplina);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return agendamento;
	}

	public List<Agendamento> buscarTodos() {
		List<Agendamento> listaAgendamento = new ArrayList<>();
		Agendamento agendamento = null;
		this.conexao.abrirConexao();
		String sql = "SELECT * FROM agendamento";
		PreparedStatement statement;
		try {
			statement = conexao.getConexao().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				agendamento = new Agendamento();
				agendamento.setIdAgendamento(rs.getLong("id_agendamento"));
				agendamento.setHorarioInicio(
						ConversaoDeDataUtil.timestampToLocalDateTime(rs.getTimestamp("horario_inicio)")));
				agendamento.setHorarioFim(
						ConversaoDeDataUtil.timestampToLocalDateTime(rs.getTimestamp("horario_inicio)")));
				agendamento.setDescricaoFinal(rs.getString("descricao_final"));
				AlunoDAO alunoDAO = new AlunoDAO();
				Aluno aluno = alunoDAO.buscarPorId(rs.getLong("id_aluno"));
				agendamento.setAluno(aluno);
				MonitorDAO monitorDAO = new MonitorDAO();
				Monitor monitor = monitorDAO.buscarPorId(rs.getLong("id_monitor"));
				agendamento.setMonitor(monitor);
				DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
				Disciplina disciplina = disciplinaDAO.buscarPorId(rs.getLong("id_disciplina"));
				agendamento.setDisciplina(disciplina);
				listaAgendamento.add(agendamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaAgendamento;
	}

}
