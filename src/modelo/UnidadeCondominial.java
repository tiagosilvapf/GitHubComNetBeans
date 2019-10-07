package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "unidade_condominial")
public class UnidadeCondominial implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_unidade_condominial", sequenceName = "seq_unidade_condominial_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_unidade_condominial", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O numero da unidade deve ser informado")
    @Length(max = 50, message = "O numero da unidade não pode ter mais que {max} caracteres")
    @Column(name = "numero", nullable = false, length = 50)
    private String numero;
    
    @NotBlank(message = "A descricao da unidade deve ser informada")
    @Length(max = 50, message = "A descricao da unidade não pode ter mais que {max} caracteres")
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
    
    @Min(value = 0, message = "O valor da area não pode ser negativo")
    @Column(name = "area", columnDefinition = "numeric(10,2)")
    private Double area;
    
    @Min(value = 0, message = "O numero do quarto não pode ser negativo")
    @Column(name = "numero_quarto")
    private Integer numero_quarto;
    
    @NotNull(message = "A pessoa deve ser informada")
    @ManyToOne
    @JoinColumn(name = "pessoa",referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    
    @NotNull(message = "O condominio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "condominio",referencedColumnName = "id", nullable = false)
    private Condominio condominio;
    
    public UnidadeCondominial(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getNumero_quarto() {
        return numero_quarto;
    }

    public void setNumero_quarto(Integer numero_quarto) {
        this.numero_quarto = numero_quarto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    
    
}
