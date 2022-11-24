package fr.cs.gite_jee.dao;

import fr.cs.gite_jee.metier.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDAO extends DAO<Users, Users>{


    protected UsersDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Users getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Users> getAll() {
        return null;
    }

    @Override
    public ArrayList<Users> getLike(Users objet) {
        return null;
    }

    @Override
    public boolean insert(Users users) {
        String Statement = "insert into USERS (LOGIN,PASSWORD) values (?,?)";
        try(PreparedStatement pStmt = this.connexion.prepareStatement(Statement)){
            if (users != null){
                pStmt.setString(2, users.getLogin());
                pStmt.setString(3, users.getPasseword());
                pStmt.execute();

            }
            return  true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Users object) {
        return false;
    }

    @Override
    public boolean delete(Users object) {
        return false;
    }
}
