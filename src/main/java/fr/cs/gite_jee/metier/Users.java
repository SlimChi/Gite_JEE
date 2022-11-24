package fr.cs.gite_jee.metier;

public class Users {

    private int idUser;

    private String login;

    private String passeword;

    public Users() {
    }

    public Users(int idUser, String login, String passeword) {
        this.idUser = idUser;
        this.login = login;
        this.passeword = passeword;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }
}
