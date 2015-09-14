package za.ac.cput.assets.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/07/30.
 */
@Entity
public class OwnerRegion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String code;
    private String name;

    public Long getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    private OwnerRegion(){}
    public OwnerRegion(Builder builder){
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder{
        private Long id;
        private String code;
        private String name;

        public  Builder (String value) {
            this.code = value;
        }

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder name(String value) {
            this.name = value;
            return this;
        }
        //Copy the builder
        public Builder copy(OwnerRegion value){
            this.id = value.getId();
            this.code = value.getCode();
            this.name = value.getName();
            return this;
        }//Copy the builder

        //Inner Static Builder constructor
        public OwnerRegion build(){
            return new OwnerRegion(this);
        }
        //Inner Static Builder constructor
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerRegion)) return false;

        OwnerRegion object = (OwnerRegion) o;
        return !(id != null ? !id.equals(object.id) : object.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
