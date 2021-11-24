package ifpr.pgua.eic.biblioteca.modelos;

import java.io.Serializable;

public class Autor implements Serializable{
    private String nome;
    private String email;
    private String cpf;
    
    public Autor(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return nome;
    }

    public String paraTexto(){
        return "nome:"+nome+";email:"+email+";cpf:"+cpf;
    }
   
}
