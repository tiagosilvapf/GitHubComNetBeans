package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Tiago
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "locatario")
public class Locatario extends Pessoa implements Serializable {
    

    @Min(value = 0, message = "O valor da renda não pode ser negativo")
    @Column(name = "renda", columnDefinition = "numeric(10,2)")
    private Double renda;
    @NotBlank(message = "O local de trabalho deve ser informado")
    @Length(max = 50, message = "O local de trabalho não pode ter mais que {max} caracteres")
    @Column(name = "local_trabalho", nullable = false, length = 50)
    private String localTrabalho;
    @NotBlank(message = "O telefone de trabalho deve ser informado")
    @Length(max = 14, message = "O telefone de trabalho não pode ter mais que {max} caracteres")
    @Column(name = "telefone_trabalho", length = 14, nullable = false)    
    private String telefone_trabalho;

    
    public Locatario(){
        
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getTelefone_trabalho() {
        return telefone_trabalho;
    }

    public void setTelefone_trabalho(String telefone_trabalho) {
        this.telefone_trabalho = telefone_trabalho;
    }

    

    
    
}
