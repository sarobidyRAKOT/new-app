package itu.mg.new_app.models_form;

public class Login_form {


    private String usr;
    private String pwd;

    public Login_form () {}


    public String getPwd() { return pwd; }
    public String getUsr() { return usr; }
    public void setPwd(String pwd) { this.pwd = pwd; }
    public void setUsr(String usr) { this.usr = usr; }
}