package dao;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import model.*;
public interface SpostamentoLezioneDAO {
    boolean insert(SpostamentoLezione spostamento) throws SQLException;
    Optional<SpostamentoLezione> getById(int idSpost) throws SQLException;
    List<SpostamentoLezione> getAll() throws SQLException;
}
