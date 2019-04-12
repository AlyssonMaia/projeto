package model;

import java.util.Objects;
import java.util.logging.Logger;

public class Pessoa {
    
    private int id;
    
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private String tipo;
    private String titulacao;
    
    private boolean ativo;
    
    private static final Logger LOG = Logger.getLogger(Pessoa.class.getName());

    @Override
    public String toString() {
        
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + 
                           ", endereco=" + endereco + ", email=" + email + 
                           ", telefone=" + telefone + ", tipo=" + tipo + 
                           ", titulacao=" + titulacao + ", ativo=" + ativo + 
                     "}";
    }
    
    public String isCargo(){
       
        if(getTipo().equals("DIRETOR")){
        
            return "DIRETOR";
        
        }
        
        if(getTipo().equals("COORDENADOR")){
            
            return "COORDENADOR";
        
        }
        
        if(getTipo().equals("PROFESSOR")){
        
            return "PROFESSOR";
        
        }
        
        return "ALUNO";
        
    }
    
    public String isConfirmacaoCreate(){
        
        StringBuilder msg = new StringBuilder();
        
        msg.append(isCargo());
        msg.append(" cadastrado com sucesso!");
        
        return msg.toString();
    }
    
    public String isConfirmacaoRead(){
        
        StringBuilder msg = new StringBuilder();
        
        msg.append("Busca de ");
        msg.append(isCargo());
        msg.append(" realizada com sucesso!");
        
        return msg.toString();
    }
    
    public String isConfirmacaoUpdate(){
        
        StringBuilder msg = new StringBuilder();
        
        msg.append(isCargo());
        msg.append(" atualizado com sucesso!");
        
        return msg.toString();
    }
    
    public String isConfirmacaoDelete(){
        
        StringBuilder msg = new StringBuilder();
        
        msg.append(isCargo());
        msg.append(" deletado com sucesso!");
        
        return msg.toString();
    }
    
    public int getId() {
        
        return id;
    
    }

    public void setId(int id) {
    
        this.id = id;
    
    }

    public String getNome() {
    
        return nome;
    
    }

    public void setNome(String nome) {
    
        this.nome = nome;
    
    }

    public String getCpf() {
    
        return cpf;
    
    }

    public void setCpf(String cpf) {
    
        this.cpf = cpf;
    
    }

    public String getEndereco() {
    
        return endereco;
    
    }

    public void setEndereco(String endereco) {
    
        this.endereco = endereco;
    
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

    public String getTipo() {
    
        return tipo;
    
    }

    public void setTipo(String tipo) {
    
        this.tipo = tipo;
    
    }

    public String getTitulacao() {
    
        return titulacao;
    
    }

    public void setTitulacao(String titulacao) {
    
        this.titulacao = titulacao;
    
    }

    public boolean isAtivo() {
    
        return ativo;
    
    }

    public void setAtivo(boolean ativo) {
    
        this.ativo = ativo;
    
    }

    @Override
    public int hashCode() {
        
        int hash = 7;
        
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.cpf);
        hash = 67 * hash + Objects.hashCode(this.endereco);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.telefone);
        hash = 67 * hash + Objects.hashCode(this.tipo);
        hash = 67 * hash + Objects.hashCode(this.titulacao);
        hash = 67 * hash + (this.ativo ? 1 : 0);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
        
            return true;
        
        }
        
        if (obj == null) {
            
            return false;
        
        }
        
        if (getClass() != obj.getClass()) {
        
            return false;
        
        }
        final Pessoa other = (Pessoa) obj;
        
        if (this.id != other.id) {
        
            return false;
        
        }
        
        if (this.ativo != other.ativo) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.nome, other.nome)) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.cpf, other.cpf)) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.endereco, other.endereco)) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.email, other.email)) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.telefone, other.telefone)) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.tipo, other.tipo)) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.titulacao, other.titulacao)) {
        
            return false;
        
        }
        
        return true;
    }
    
}