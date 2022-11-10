package fr.cs.gite_jee.dao;




import fr.cs.gite_jee.metier.Region;

import java.sql.Connection;
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
        return null;
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
