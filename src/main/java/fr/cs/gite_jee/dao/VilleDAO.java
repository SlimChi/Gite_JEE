package fr.cs.gite_jee.dao;

import fr.cs.gite_jee.metier.Departement;
import fr.cs.gite_jee.metier.Region;
import fr.cs.gite_jee.metier.Ville;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VilleDAO extends DAO<Ville, Ville> {
    public VilleDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Ville getByID(int id) {
        return null;


    }

    @Override
    public ArrayList<Ville> getAll() {
        return null;
    }

    @Override
    public ArrayList<Ville> getLike(Ville objet) {
        return null;
    }

    @Override
    public boolean insert(Ville objet) {
        return false;
    }

    @Override
    public boolean update(Ville object) {
        return false;
    }

    @Override
    public boolean delete(Ville object) {
        return false;
    }

    public Ville getVilleByCodeInsee(String codeInseeDept, String codeInsee) {
        Ville ville = new Ville();
        ResultSet rs;

        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement(" SELECT NOM_VILLE, LATITUDE, LONGITUDE, D.CODE_INSEE_DEPT, CODE_INSEE,D.NOM_DEPARTEMENT,R.ID_REGION,R.NOM_REGION FROM VILLE as V \n" +
                            "                    join DEPARTEMENT as D on D.CODE_INSEE_DEPT = V.CODE_INSEE_DEPT\n" +
                            "                    join REGION as R on R.ID_REGION = D.ID_REGION\n" +
                            "\t\t\t\t\tWHERE V.CODE_INSEE_DEPT = ? and V.CODE_INSEE=?\n" +
                            "                    order by NOM_VILLE;");
            // Determine the column set column

            pStmt.setString(1, codeInseeDept);
            pStmt.setString(2, codeInsee);


            rs = pStmt.executeQuery();

            while (rs.next()) {


                Region region = new Region();
                region.setId(rs.getInt(7));
                region.setNom(rs.getString(8));

                Departement departement = new Departement();
                departement.setCodeInseeDept(rs.getString(4));
                departement.setNomDepartement(rs.getString(6));
                departement.setRegion(region);


                ville.setNom(rs.getString(1));
                ville.setLatitude(rs.getFloat(2));
                ville.setLongitude(rs.getFloat(3));
                ville.setCodeInseeDept(rs.getString(4));
                ville.setCodeInsee(rs.getString(5));
                ville.setDepartement(departement);



            }
            rs.close();
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return ville;
    }


}
