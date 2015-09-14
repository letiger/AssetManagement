package za.ac.cput.assets.domain;

/**
 * Created by student on 2015/07/30.
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OwnerType implements Serializable{
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
    private OwnerType (){}
    public OwnerType(Builder builder){
        id = builder.id;
        code = builder.code;
        name = builder.name;
    }

    @Override
    public String toString() {
        return "OwnerType{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder{
        private Long id;
        private String code;
        private String name;

        public  Builder(String value) {
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
        public Builder copy(OwnerType value){
            this.id = value.getId();
            this.code = value.getCode();
            this.name = value.getName();
            return this;
        }//Copy the builder

        //Inner Static Builder constructor
        public OwnerType build(){
            return new OwnerType(this);
        }
        //Inner Static Builder constructor
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerType)) return false;

        OwnerType object = (OwnerType) o;
        return !(id != null ? !id.equals(object.id) : object.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
