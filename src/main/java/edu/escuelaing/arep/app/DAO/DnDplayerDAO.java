package edu.escuelaing.arep.app.DAO;

import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Service;

import edu.escuelaing.arep.app.entities.DnDplayer;

@Service
public interface DnDplayerDAO{
    public List<DnDplayer> findAll() throws SQLException;
    public void insertPlayer(DnDplayer t) throws SQLException;
}