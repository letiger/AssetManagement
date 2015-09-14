package za.ac.cput.assets.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/07/27.
 */
@Entity
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String barcode;
    private String expireDate;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "detail_id")
    private List<ItemDetail> itemDetailList;

    //Getters, constructor, toString
    private Item(){}
    public Long getId() {
        return id;
    }
    public String getBarcode() {
        return barcode;
    }
    public String getExpireDate() {
        return expireDate;
    }
    public String getName() {
        return name;
    }
    public List<ItemDetail> getItemDetailList() {
        return itemDetailList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public Item(Builder builder){
        this.id=builder.id;
        this.barcode = builder.barcode;
        this.expireDate = builder.expireDate;
        this.name = builder.name;
        this.itemDetailList = builder.itemDetailList;
    }
    //Getters, constructor, toString

    //Builder inner class
    public static class Builder{
        private Long id;
        private String barcode;
        private String expireDate;
        private String name;
        private List<ItemDetail> itemDetailList;

        public Builder(String value){
            barcode = value;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder expireDate(String value){
            this.expireDate = value;
            return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder detailList(List<ItemDetail> value){
            this.itemDetailList = value;
            return this;
        }
        public Builder copy(Item value){
            this.id=value.getId();
            this.barcode=value.getBarcode();
            this.name = value.getName();
            this.itemDetailList = value.getItemDetailList();
            this.expireDate = value.getExpireDate();
            return this;
        }
        //Inner Static Builder constructor
        public Item build(){
            return new Item(this);
        }
        //Inner Static Builder constructor

    }//Builder inner class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item object = (Item) o;
        return !(id != null ? !id.equals(object.id) : object.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
