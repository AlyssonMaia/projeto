package graduacao;

import java.util.logging.Logger;

public class Notas {
    
    private int id;
    private int pessoa_id;
    private int disciplina_id;
    
    private float primeira;
    private float segunda;
    private float terceira;
    
    private boolean ativo;

    private static final Logger LOG = Logger.getLogger(Notas.class.getName());

    @Override
    public String toString() {
        
        return "Notas{" + "id=" + id + ", pessoa_id=" + pessoa_id + 
                        ", disciplina_id=" + disciplina_id + ", primeira=" + primeira + 
                        ", segunda=" + segunda + ", terceira=" + terceira + ", ativo=" + ativo + 
                    '}';
    
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

    public int getDisciplina_id() {
     
        return disciplina_id;
    
    }

    public void setDisciplina_id(int disciplina_id) {
    
        this.disciplina_id = disciplina_id;
    
    }

    public float getPrimeira() {
    
        return primeira;
    
    }

    public void setPrimeira(float primeira) {
    
        this.primeira = primeira;
    
    }

    public float getSegunda() {
    
        return segunda;
    
    }

    public void setSegunda(float segunda) {
    
        this.segunda = segunda;
    
    }

    public float getTerceira() {
    
        return terceira;
    
    }

    public void setTerceira(float terceira) {
    
        this.terceira = terceira;
    
    }

    public boolean isAtivo() {
    
        return ativo;
    
    }

    public void setAtivo(boolean ativo) {
    
        this.ativo = ativo;
    
    }

    @Override
    public int hashCode() {
        
        int hash = 3;
        
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.pessoa_id;
        hash = 53 * hash + this.disciplina_id;
        hash = 53 * hash + Float.floatToIntBits(this.primeira);
        hash = 53 * hash + Float.floatToIntBits(this.segunda);
        hash = 53 * hash + Float.floatToIntBits(this.terceira);
        hash = 53 * hash + (this.ativo ? 1 : 0);
        
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
        
        final Notas other = (Notas) obj;
        
        if (this.id != other.id) {
        
            return false;
        
        }
        
        if (this.pessoa_id != other.pessoa_id) {
        
            return false;
        
        }
        
        if (this.disciplina_id != other.disciplina_id) {
         
            return false;
        
        }
        
        if (Float.floatToIntBits(this.primeira) != Float.floatToIntBits(other.primeira)) {
         
            return false;
        
        }
        
        if (Float.floatToIntBits(this.segunda) != Float.floatToIntBits(other.segunda)) {
         
            return false;
        
        }
        
        if (Float.floatToIntBits(this.terceira) != Float.floatToIntBits(other.terceira)) {
         
            return false;
        
        }
        
        if (this.ativo != other.ativo) {
         
            return false;
        
        }
    
        return true;
        
    }
}