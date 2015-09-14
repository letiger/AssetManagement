package za.ac.cput.assets.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.assets.domain.Item;

import java.util.List;

/**
 * Created by student on 2015/08/12.
 */
public class ItemTypeResource extends ResourceSupport{
    private Long Resid;
    private String code;
    private String name;
    private List<Item> itemList;
    public ItemTypeResource(){}

    public Long getResid() {
        return Resid;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public List<Item> getItemList() {
        return itemList;
    }
    public ItemTypeResource(Builder builder){
        Resid = builder.Resid;
        code = builder.code;
        name = builder.name;
        itemList = builder.itemList;
    }
    public static class Builder{
        private Long Resid;
        private String code;
        private String name;
        List<Item> itemList;
        public Builder (String value){
            code = value;
        }
        public Builder id(Long value){
            Resid=value;
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
        public Builder copy(ItemTypeResource value){
            this.Resid = value.getResid();
            this.name = value.getName();
            this.code = value.getCode();
            this.itemList = value.getItemList();
            return this;
        }
        public ItemTypeResource build(){
            return new ItemTypeResource(this);
        }
    }//End of Builder Static class

}
