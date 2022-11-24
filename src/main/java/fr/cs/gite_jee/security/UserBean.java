package fr.cs.gite_jee.security;

import fr.cs.gite_jee.metier.Personne;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Named
@RequestScoped
public class UserBean implements Serializable {



    @Inject
    ApplicationBean applicationBean;

    private Personne personne;


    @PostConstruct
    public void init() {
    personne = new Personne();
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public ApplicationBean getApplicationBean() {
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }

    public void Creer() throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE,10);
        Date expiration = calendar.getTime();
        String url = String.format("/%s?c=%s&e=%s&p=%s&d=%s",
                personne.getUsers().getLogin(),
                SecurityTools.checksum(personne.getUsers().getLogin()+personne.getIdMail()),
                personne.getIdMail(),
                applicationBean.passwordHash(personne.getUsers().getPasseword()),
                new SimpleDateFormat("dd-MM-yy-HH:mm:ss").format(expiration));
        String urlEncode = SecurityTools.encrypt(url);
        String valideUrl = applicationBean.getAbsolutePath() + "/confirm.jsf?compte=" + urlEncode;
        StringBuilder body = new StringBuilder("Veuillez cliquer le lien");
        body.append(valideUrl);
        Email.sendEmail(personne.getIdMail(), "Confirmation",body.toString());


    }

}