package za.ac.cput.assets.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/07/28.
 */
@Entity
public class ItemDetail implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dateCreated;
    private String heading;
    private String comment;
    //private List<Detail> detailList;

    public Long getId() {
        return id;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public String getHeading() {
        return heading;
    }
    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", dateCreated='" + dateCreated + '\'' +
                ", heading='" + heading + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public ItemDetail(Builder builder){
        this.id = builder.id;
        this.dateCreated = builder.dateCreated;
        this.heading = builder.heading;
        this.comment = builder.comment;
    }
    public static class Builder{
        private Long id;
        private String dateCreated;
        private String heading;
        private String comment;

        public Builder(String value){
            dateCreated = value;
        }
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        public Builder heading(String value){
            this.heading = value;
            return this;
        }
        public Builder comments(String value){
            this.comment = value;
            return this;
        }
        public Builder copy(ItemDetail value){
            this.id = value.getId();
            this.dateCreated = value.getDateCreated();
            this.heading = value.getHeading();
            this.comment = value.getComment();
            return this;
        }
        public ItemDetail build(){
            return new ItemDetail(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemDetail)) return false;

        ItemDetail object = (ItemDetail) o;
        return !(id != null ? !id.equals(object.id) : object.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
