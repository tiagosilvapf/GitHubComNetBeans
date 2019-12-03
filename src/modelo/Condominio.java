package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "condominio")
public class Condominio implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @NotBlank(message = "O endereco deve ser informado")
    @Length(max = 50, message = "O endereco não pode ter mais que {max} caracteres")
    @Column(name = "endereco", nullable = false, length = 50)
    private String endereco;
    @NotBlank(message = "O numero do condominio deve ser informado")
    @Length(max = 50, message = "O numero do condominio não pode ter mais que {max} caracteres")
    @Column(name = "numero", nullable = false, length = 50)
    private String numero;
    @NotBlank(message = "O cep não pode ser em branco")
    @Length(max = 9, message = "O cep não pode ter mais que {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)      
    private String cep;
    
    public Condominio(){
        
    }
   
    
          @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "condominio_recurso",
            joinColumns = 
                    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false))    
    private Set<Recurso> condominioRecurso = new HashSet<>();

     @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UnidadeCondominial> unidade = new ArrayList<>();
    
        public void adicionarUnidade (UnidadeCondominial obj){
        obj.setCondominio(this);
        this.unidade.add(obj);
    }
    
    public void removerUnidade(int index){
        this.unidade.remove(index);
    }
     
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<UnidadeCondominial> getUnidade() {
        return unidade;
    }

    public void setUnidade(List<UnidadeCondominial> unidade) {
        this.unidade = unidade;
    }

    public Set<Recurso> getCondominioRecurso() {
        return condominioRecurso;
    }

    public void setCondominioRecurso(Set<Recurso> condominioRecurso) {
        this.condominioRecurso = condominioRecurso;
    }

  
 
    
    
}
