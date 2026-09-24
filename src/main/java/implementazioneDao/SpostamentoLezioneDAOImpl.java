package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import Progetto.*;
public class SpostamentoLezioneDAOImpl implements SpostamentoLezioneDAO {

    private final Connection connection;
    Docente d=new Docente("Anna","Neri","annaneri05@unina.it","Adjdn3432","Anna_neri5");
    Insegnamento i=new Insegnamento("Algebra",LocalDate.of(2025,1,4),LocalDate.of(2027,1,5),d,45);
    Aula a=new Aula("A7");
    Responsabile r=new Responsabile("Marco","Verdi","marco_verdi05@unina.it","marcoverdi5","Asvf4857",i);
    Lezione l=new Lezione("N7654",GiornoSettimana.MARTEDI,LocalTime.of(16,0),LocalTime.of(18, 0),i,a,r);
    SpostamentoLezione spostamento=new SpostamentoLezione("W4533453",l,GiornoSettimana.GIOVEDI,LocalTime.of(12,0),LocalTime.of(14, 0));
    public SpostamentoLezioneDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insert(SpostamentoLezione spostamento) throws SQLException {
        String query = "INSERT INTO spostamento_lezione " +
                       "(id_spost, id_lezione, nuovo_giorno, nuovo_orario_iniziale, nuovo_orario_fin, id_aula, stato) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, spostamento.getIdSpost());
            stmt.setString(2, spostamento.getLezione().getId());
            stmt.setString(3, spostamento.getNuovoGiorno().name());
            stmt.setTime(4, Time.valueOf(spostamento.getOrarioIniziale()));
            stmt.setTime(5, Time.valueOf(spostamento.getOrarioFinale()));
            stmt.setString(6, spostamento.getAula().getNomeAula());
            stmt.setString(7, spostamento.getStato().name());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }
    }

    @Override
    public Optional<SpostamentoLezione> getById(int idSpost) throws SQLException {
        String query = "SELECT * FROM spostamento_lezione WHERE id_spost = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idSpost);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToEntity(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<SpostamentoLezione> getAll() throws SQLException {
        List<SpostamentoLezione> lista = new ArrayList<>();
        String query = "SELECT * FROM spostamento_lezione";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(mapResultSetToEntity(rs));
            }
        }
        return lista;
    }

    private SpostamentoLezione mapResultSetToEntity(ResultSet rs) throws SQLException {
    	spostamento.setIdSpost("R8546");
    	spostamento.getLezione().setIdLezione("A75465");
    	spostamento.setOrarioIniziale(LocalTime.of(8, 45));
        spostamento.setOrarioFinale(LocalTime.of(10, 30));
        spostamento.setAula(a);
        spostamento.setStato(Stato.APPROVATA);
        return spostamento;
            
        }
}
