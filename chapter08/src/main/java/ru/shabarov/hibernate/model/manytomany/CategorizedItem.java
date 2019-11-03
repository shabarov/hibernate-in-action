package ru.shabarov.hibernate.model.manytomany;

import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CATEGORY_ITEM2")
@Immutable
public class CategorizedItem {
    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "CATEGORY_ID")
        protected Long categoryId;

        @Column(name = "ITEM_ID")
        protected Long itemId;

        public Id() {
        }

        public Id(Long categoryId, Long itemId) {
            this.categoryId = categoryId;
            this.itemId = itemId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Id id = (Id) o;
            return Objects.equals(categoryId, id.categoryId) &&
                    Objects.equals(itemId, id.itemId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(categoryId, itemId);
        }
    }

    @EmbeddedId
    protected Id id = new Id();

    @Column(updatable = false)
    @NotNull
    protected String addedBy;

    @Column(updatable = false)
    @NotNull
    protected Date addedOn = new Date();

    @ManyToOne
    @JoinColumn(
            name = "CATEGORY_ID",
            insertable = false, updatable = false
    )
    protected Category2 category;

    @ManyToOne
    @JoinColumn(
            name = "ITEM_ID",
            insertable = false, updatable = false
    )
    protected Item3 item;

    public CategorizedItem(String addedBy, Category2 category, Item3 item) {
        this.addedBy = addedBy;
        this.category = category;
        this.item = item;

        this.id.categoryId = category.getId();
        this.id.itemId = item.getId();

        category.getCategorizedItems().add(this);
        item.getCategorizedItems().add(this);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Category2 getCategory() {
        return category;
    }

    public void setCategory(Category2 category) {
        this.category = category;
    }

    public Item3 getItem() {
        return item;
    }

    public void setItem(Item3 item) {
        this.item = item;
    }


}
