package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Tiago
 */

@Entity
@Table(name = "recurso")
public class Recurso implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "A descrição do recurso deve ser informada")
    @Length(max = 50, message = "A descricao não pode ter mais que {max} caracteres")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;

       @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "condominio_recurso",
            joinColumns = 
                    @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false))    
    private Set<Recurso> condominioRecurso = new HashSet<>();

    
    
    public Recurso(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Set<Recurso> getCondominioRecurso() {
        return condominioRecurso;
    }

    public void setCondominioRecurso(Set<Recurso> condominioRecurso) {
        this.condominioRecurso = condominioRecurso;
    }


    
    
}
