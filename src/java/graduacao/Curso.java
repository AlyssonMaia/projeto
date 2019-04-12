package graduacao;

import java.util.Objects;
import java.util.logging.Logger;

public class Curso {
    
    private int id;
    private int pessoa_id;
    
    private String nome;
    private String area;
    
    private boolean ativo;
    
    private static final Logger LOG = Logger.getLogger(Curso.class.getName());

    @Override
    public String toString() {
        
        return "Curso{" + "id=" + id + ", pessoa_id=" + pessoa_id + ", nome=" + nome +  
                           ", area=" + area +", ativo=" + ativo + 
                    "}";
        
    }

    public int getId() {
        
        return id;
    
    }

    public void setId(int id) {
    
        this.id = id;
    
    }

    public int getPessoa_id() {
    
        return pessoa_id;
    
    }

    public void setPessoa_id(int pessoa_id) {
    
        this.pessoa_id = pessoa_id;
    
    }
    
    public String getNome() {
    
        return nome;
    
    }

    public void setNome(String nome) {
    
        this.nome = nome;
    
    }

    public String getArea() {
    
        return area;
    
    }

    public void setArea(String area) {
    
        this.area = area;
    
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
        
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + Objects.hashCode(this.area);
        hash = 19 * hash + this.pessoa_id;
        hash = 19 * hash + (this.ativo ? 1 : 0);
    
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
        
        final Curso other = (Curso) obj;
        
        if (this.id != other.id) {
        
            return false;
        
        }
        
        if (this.pessoa_id != other.pessoa_id) {
        
            return false;
        
        }
        
        if (this.ativo != other.ativo) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.nome, other.nome)) {
        
            return false;
        
        }
        
        if (!Objects.equals(this.area, other.area)) {
        
            return false;
        
        }
        
        return true;
        
    }
    
}