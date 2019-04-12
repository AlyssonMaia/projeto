package graduacao;

import java.util.Objects;
import java.util.logging.Logger;

public class Disciplina {
    
    private int id;
    private int curso_id;
    private int pessoa_id;
    
    private String nome;
    
    private boolean ativo;
    
    private static final Logger LOG = Logger.getLogger(Disciplina.class.getName());

    @Override
    public String toString() {
    
        return "Disciplina{" + "id=" + id + ", curso_id=" + curso_id + 
                               ", pessoa_id=" + pessoa_id + ", nome=" + nome + 
                               ", ativo=" + ativo + 
                         "}";
        
    }

    public int getId() {
        
        return id;
    
    }

    public void setId(int id) {

        this.id = id;

    }

    public int getCurso_id() {

        return curso_id;

    }

    public void setCurso_id(int curso_id) {

        this.curso_id = curso_id;

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

    public boolean isAtivo() {

        return ativo;

    }

    public void setAtivo(boolean ativo) {

        this.ativo = ativo;

    }

    @Override
    public int hashCode() {
        
        int hash = 5;
        
        hash = 47 * hash + this.id;
        hash = 47 * hash + this.curso_id;
        hash = 47 * hash + this.pessoa_id;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + (this.ativo ? 1 : 0);
        
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
        
        final Disciplina other = (Disciplina) obj;
        
        if (this.id != other.id) {
        
            return false;
        
        }
        
        if (this.curso_id != other.curso_id) {
        
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
        
        return true;

    }

}