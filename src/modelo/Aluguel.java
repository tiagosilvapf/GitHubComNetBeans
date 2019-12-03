package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Tiago
 */

@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Min(value = 0, message = "O valor do aluguel não pode ser negativo")
    @Column(name = "valor", columnDefinition = "numeric(10,2)")
    private Double valor;
    
    @NotNull(message = "A data inicio do contrato deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio_contrato", nullable = false)
    private Calendar inicioContrato;
    
    @NotNull(message = "A data final do contrato deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "fim_contrato", nullable = false)
    private Calendar fimContrato;
    
    @Min(value = 0, message = "O dia do vencimento não pode ser negativo")
    @Column(name = "dia_vencimento")
    private Integer diaVencimento;
    
    @NotNull(message = "A unidade condominial deve ser informada")
    @ManyToOne
    @JoinColumn(name = "uni_condominial",referencedColumnName = "id", nullable = false)
    private UnidadeCondominial unidadeCondominial;  
    
    @NotNull(message = "O locatorio deve ser informado")
    @ManyToOne
    @JoinColumn(name = "locatorio",referencedColumnName = "id", nullable = false)
    private Locatario locatorio;  
    
      @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mensalidades> mensalidade = new ArrayList<>();
    
        public void adicionarMensalidade (Mensalidades obj){
        obj.setAluguel(this);
        this.mensalidade.add(obj);
    }
    
    public void removerMensalidade(int index){
        this.mensalidade.remove(index);
    }
     
    
    public Aluguel(){
        
    }
    
    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mensalidades> mensalidades = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Calendar getFimContrato() {
        return fimContrato;
    }

    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public UnidadeCondominial getUnidadeCondominial() {
        return unidadeCondominial;
    }

    public void setUnidadeCondominial(UnidadeCondominial unidadeCondominial) {
        this.unidadeCondominial = unidadeCondominial;
    }

    public Locatario getLocatorio() {
        return locatorio;
    }

    public void setLocatorio(Locatario locatorio) {
        this.locatorio = locatorio;
    }
    
    public List<Mensalidades> getMensalidades() {
    return mensalidades;
    
    }

    public void setMensalidades(List<Mensalidades> mensalidades) {
        this.mensalidades = mensalidades;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Mensalidades> getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(List<Mensalidades> mensalidade) {
        this.mensalidade = mensalidade;
    }

    
}
