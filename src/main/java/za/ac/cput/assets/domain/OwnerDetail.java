package za.ac.cput.assets.domain;

import javax.persistence.Embeddable;

/**
 * Created by student on 2015/07/28.
 */
@Embeddable
public class OwnerDetail {
    //private Long id;
    private String userType;
    private String region;
    private String department;

    //Getters
        //constructor
        private OwnerDetail(){}
    /*public Long getId() {
        return id;
    }*/
    public String getUserType() {
        return userType;
    }
    public String getRegion() {
        return region;
    }
    public String getDepartment() {
        return department;
    }
    //Getters

    //constructor with Builder as param
    public OwnerDetail(Builder builder){
        //this.id=builder.id;
        this.userType=builder.userType;
        this.region=builder.region;
        this.department=builder.department;
    }
    //constructor with Builder as param

    //Builder
    public static class Builder{
        //Long id;
        String userType;
        String region;
        String department;

        public Builder(String value){
            this.department = value;
        }
        /*public Builder id(Long value){
            this.id = value;
            return this;
        }*/
        public Builder userType(String value){
            this.userType = value;
            return this;
        }
        public Builder region(String value){
            this.region = value;
            return this;
        }
        public Builder copy(OwnerDetail value){
            //this.id = value.getId();
            this.userType = value.getUserType();
            this.region = value.getRegion();
            this.department = value.getDepartment();
            return this;
        }
        public OwnerDetail build(){
            return new OwnerDetail(this);
        }
    }//Builder
    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OwnerDetail)) return false;

        OwnerDetail object = (OwnerDetail) o;
        return !(id != null ? !id.equals(object.id) : object.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }*/
}
