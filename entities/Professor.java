package Trabalho_BD.entities;

public class Professor {
    private String email;
    private String telefone;

    public Professor(){
    }

    public Professor(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Professor [email=" + email + ", telefone=" + telefone + "]";
    }
}