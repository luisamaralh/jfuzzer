package br.unb.cic.jfuzzer.beans.localidade;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.unb.cic.jfuzzer.beans.Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa uma Mesorregião de acordo com o IBGE.
 * 
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_MESORREGIAO")
public class Mesorregiao implements Entidade<Long> {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadeFederacao uf;

    @OneToMany(mappedBy = "mesorregiao", fetch = FetchType.LAZY)
    private Set<Microrregiao> microrregioes = new HashSet<>();

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mesorregiao)) {
            return false;
        }
        Mesorregiao other = (Mesorregiao) obj;
        return Objects.equals(codigo, other.codigo) && Objects.equals(id, other.id) && Objects.equals(microrregioes, other.microrregioes) && Objects.equals(nome, other.nome) && Objects.equals(uf, other.uf);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(codigo, id, microrregioes, nome, uf);
    }

}