package Database;
import java.util.List;
import java.util.Optional;
import Progetto.*;
public interface SpostamentoLezioneDAO {
    boolean insert(SpostamentoLezione spostamento) throws Exception;
    Optional<SpostamentoLezione> getById(int idSpost) throws Exception;
    List<SpostamentoLezione> getAll() throws Exception;
}
