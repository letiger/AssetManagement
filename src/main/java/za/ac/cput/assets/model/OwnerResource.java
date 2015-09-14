package za.ac.cput.assets.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.assets.domain.Item;
import za.ac.cput.assets.domain.OwnerDetail;

import java.util.List;

/**
 * Created by student on 2015/09/14.
 */
public class OwnerResource extends ResourceSupport{
    private Long Resid;
    private String pk;
    private String startDate;
    private String endDate;
    private String name;
    private String surname;
    private String email;
    private List<Item> itemList;
    private OwnerDetail detail;

    //Getters
    //constructor
    private OwnerResource(){}
    public Long getResid() {
        return Resid;
    }
    public String getPk() {
        return pk;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public List<Item> getItemList() {
        return itemList;
    }
    public OwnerDetail getDetail(){
        return detail;
    }
    //Getters

    //public constructor with Builder as param
    public OwnerResource(Builder builder){
        Resid=builder.Resid;
        pk=builder.pk;
        startDate=builder.startDate;
        endDate=builder.endDate;
        name=builder.name;
        surname=builder.surname;
        email=builder.email;
        itemList=builder.itemList;
        detail=builder.detail;

    }


    //Builder
    public static class Builder {
        private Long Resid;
        private String pk;
        private String startDate;
        private String endDate;
        private String name;
        private String surname;
        private String email;
        private List<Item> itemList;
        private OwnerDetail detail;

        //constructor for builder
        public Builder(String pk) {
            this.pk = pk;
        }
        public Builder id(Long value) {
            this.Resid = value;
            return this;
        }
        public Builder startDate(String value) {
            this.startDate = value;
            return this;
        }
        public Builder endDate(String value) {
            this.endDate = value;
            return this;
        }
        public Builder name(String value) {
            this.name = value;
            return this;
        }
        public Builder surname(String value) {
            this.surname = value;
            return this;
        }
        public Builder email(String value) {
            this.email = value;
            return this;
        }
        public Builder itemList(List<Item> value) {
            this.itemList = value;
            return this;
        }
        public Builder detail(OwnerDetail value) {
            this.detail = value;
            return this;
        }

        //Copy the builder
        public Builder copy(OwnerResource value) {
            this.pk = value.getPk();
            this.startDate = value.getStartDate();
            this.endDate = value.getEndDate();
            this.name = value.getName();
            this.surname = value.getSurname();
            this.email = value.getEmail();
            this.itemList = value.getItemList();
            this.detail = value.getDetail();
            return this;
        }//Copy the builder

        //Creating the double in memory, but not in DB
        public OwnerResource build() {
            return new OwnerResource(this);
        }//Builder
    }
}
