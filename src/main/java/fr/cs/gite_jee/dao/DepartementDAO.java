package fr.cs.gite_jee.dao;


import fr.cs.gite_jee.metier.Departement;

import java.sql.Connection;
import java.util.ArrayList;

public class DepartementDAO extends DAO<Departement,Departement> {

    protected DepartementDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Departement getByID(int id) {
        return null;
    }

    @Override
    public ArrayList<Departement> getAll() {
        return null;
    }

    @Override
    public ArrayList<Departement> getLike(Departement objet) {
        return null;
    }

    @Override
    public boolean insert(Departement objet) {
        return false;
    }

    @Override
    public boolean update(Departement object) {
        return false;
    }

    @Override
    public boolean delete(Departement object) {
        return false;
    }


}
