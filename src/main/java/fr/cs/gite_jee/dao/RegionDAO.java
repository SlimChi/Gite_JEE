package fr.cs.gite_jee.dao;




import fr.cs.gite_jee.metier.Departement;
import fr.cs.gite_jee.metier.Region;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class RegionDAO extends DAO <Region, Region>
{
    public RegionDAO(Connection connexion)
    {
        super(connexion);
    }

    @Override
    public Region getByID(int id) {

        return null;
    }

    @Override
    public ArrayList<Region> getAll() {
        ArrayList<Region> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {

            String strCmd = "select * from REGION";
            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()){
               Region region = new Region();
               region.setId(rs.getInt(1));
               region.setNom(rs.getString(2));

               liste.add(region);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public ArrayList<Region> getLike(Region objet) {
        return null;
    }

    @Override
    public boolean insert(Region objet) {
        return false;
    }

    @Override
    public boolean update(Region object) {
        return false;
    }

    @Override
    public boolean delete(Region object) {
        return false;
    }

}
