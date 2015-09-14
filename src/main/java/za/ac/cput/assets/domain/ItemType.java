package za.ac.cput.assets.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/08/08.
 */
@Entity
public class ItemType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private List<Item> itemList;

    private ItemType(){}

    public Long getId() {
        return id;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public ItemType(Builder builder){
        id = builder.id;
        code = builder.code;
        name = builder.name;
        itemList = builder.itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        return getName();
    }

    public static class Builder{
        private Long id;
        private String code;
        private String name;
        private List<Item> itemList;
        public Builder (String value){
            code = value;
        }
        public Builder id(Long value){
            id=value;
            return this;
        }

        public Builder name(String value){
            name=value;
            return this;
        }
        public Builder itemList(List<Item> value){
            itemList = value;
            return this;
        }
        public Builder copy(ItemType value){
            this.id = value.getId();
            this.name = value.getName();
            this.code = value.getCode();
            this.itemList = value.getItemList();
            return this;
        }
        public ItemType build(){
            return new ItemType(this);
        }
    }//End of Builder Static class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemType)) return false;

        ItemType object = (ItemType) o;
        return !(id != null ? !id.equals(object.id) : object.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
