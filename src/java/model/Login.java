package model;

import java.util.Objects;
import java.util.logging.Logger;

public class Login {
    
    private int idPessoa;
    
    private String matricula;
    private String senha;
    
    private boolean ativo;
    
    private static final Logger LOG = Logger.getLogger(Login.class.getName());
    
    @Override
    public String toString() {
        
        return "Login{" + "idPessoa=" + idPessoa + ", matricula=" + matricula + 
                          ", senha=" + senha + ", ativo=" + ativo + 
                    "}";
    
    }
    
    public int getIdPessoa() {
        
        return idPessoa;
    
    }

    public void setIdPessoa(int idPessoa) {
    
        this.idPessoa = idPessoa;
    
    }
    
    public String getMatricula() {
        
        return matricula;
    
    }

    public void setMatricula(String matricula) {
    
        this.matricula = matricula;
    
    }

    public String getSenha() {
    
        return senha;
    
    }

    public void setSenha(String senha) {
    
        this.senha = senha;
    
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
        
        hash = 41 * hash + this.idPessoa;
        hash = 41 * hash + Objects.hashCode(this.matricula);
        hash = 41 * hash + Objects.hashCode(this.senha);
        hash = 41 * hash + (this.ativo ? 1 : 0);
        
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
        
        final Login other = (Login) obj;
        
        if (this.idPessoa != other.idPessoa) {
        
            return false;
        
        }
        
        if (this.ativo != other.ativo) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.matricula, other.matricula)) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.senha, other.senha)) {
        
            return false;
        
        }
        
        return true;
    
    }
    
}