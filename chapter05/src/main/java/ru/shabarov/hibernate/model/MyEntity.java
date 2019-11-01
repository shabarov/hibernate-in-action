package ru.shabarov.hibernate.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class MyEntity {

    @Id
    @Column(name = "DESCR")
    protected String description;

    @Formula("substr(DESCR, 1, 4) || '...'")
    protected String shortDescr;

    @Formula("(select 42 from dual)")
    protected BigDecimal value;

    @Column(name = "IMPERIALWEIGHT")
    @ColumnTransformer(
            //read = "IMPERIALWEIGHT / 2.2",
            write = "? * 2.2"
    )
    protected double metricWeight;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
//    @Generated(GenerationTime.ALWAYS)
    @CreationTimestamp
    protected Date lastModified;

    @Column(insertable = false)
    @ColumnDefault("1.00")
    @Generated(GenerationTime.INSERT)
    protected BigDecimal price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescr() {
        return shortDescr;
    }

    public void setShortDescr(String shortDescr) {
        this.shortDescr = shortDescr;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public double getMetricWeight() {
        return metricWeight;
    }

    public void setMetricWeight(double metricWeight) {
        this.metricWeight = metricWeight;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "description='" + description + '\'' +
                ", shortDescr='" + shortDescr + '\'' +
                ", value=" + value +
                ", metricWeight=" + metricWeight +
                ", lastModified=" + lastModified +
                ", price=" + price +
                '}';
    }
}
