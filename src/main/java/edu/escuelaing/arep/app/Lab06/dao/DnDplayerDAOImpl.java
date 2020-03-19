package edu.escuelaing.arep.app.lab06.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.escuelaing.arep.app.lab06.entities.DnDplayer;

@Component
public class DnDplayerDAOImpl implements DnDplayerDAO{

    @Autowired
    private DataSource dSource;

    @Override
    public List<DnDplayer> findAll() throws SQLException {
        String query = "SELECT * FROM test";
        List<DnDplayer> dnDplayers = new ArrayList<DnDplayer>();
        Connection connection = null;

        try{
            connection = dSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                DnDplayer dnDplayer = new DnDplayer();
                dnDplayer.setName(rs.getString("name"));
                dnDplayer.setLifePoints(rs.getInt("lifepoints"));
                dnDplayer.setRace(rs.getString("race"));
                dnDplayer.setPclass(rs.getString("class"));
                dnDplayers.add(dnDplayer);
            }
            connection.close();
            return dnDplayers;
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertPlayer(DnDplayer t) throws SQLException {
        String query = "INSERT INTO test VALUES ('"+t.getName()
                                                   +"',"+t.getLifePoints()
                                                   +",'"+t.getRace()
                                                   +"','"+t.getClass()+"');";

        Connection connection = null;
        System.out.println(query);
        try {
            connection = dSource.getConnection();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            connection.close();
            
        } catch (SQLException e) {
            System.err.println("Error trying to create player ["+ t.getName() +"], Exception: " + e.getMessage());
        }

    }

    

    
}

