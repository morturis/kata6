package model;

public class Mail {
    private Integer id;
    private String mail;


    public Mail(Integer id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }
    
    public Integer getId() {
        return id;
    }
    
}
