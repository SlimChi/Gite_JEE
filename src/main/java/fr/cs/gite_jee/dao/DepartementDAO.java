package fr.cs.gite_jee.dao;


import fr.cs.gite_jee.metier.Departement;
import fr.cs.gite_jee.metier.Region;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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

        ArrayList<Departement> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()){

            String strCmd ="select * from DEPARTEMENT as d join REGION as r on r.ID_REGION = d.ID_REGION";
            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()){
                Region region = new Region();
                region.setId(rs.getInt(3));
                region.setNom(rs.getString(5));
                Departement departement = new Departement(rs.getString(1),rs.getString(2),rs.getInt(3));
                departement.setRegion(region);

                liste.add(departement);

            }rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
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
