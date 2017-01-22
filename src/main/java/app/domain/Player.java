package app.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
 
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
 
    @Version
    private Integer version;
 
    private String name;
    private BigDecimal quantityContributed;
    private BigDecimal percentContributed;
 
    public Integer getVersion() {
        return version;
    }
 
    public void setVersion(Integer version) {
        this.version = version;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getQuantityContributed() {
		return quantityContributed;
	}

	public void setQuantityContributed(BigDecimal quantityContributed) {
		this.quantityContributed = quantityContributed;
	}

	public BigDecimal getPercentContributed() {
		return percentContributed;
	}

	public void setPercentContributed(BigDecimal percentContributed) {
		this.percentContributed = percentContributed;
	}
    
}
