package za.ac.cput.assets.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Owner implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String pk;
    private String startDate;
    private String endDate;
    private String name;
    private String surname;
    private String email;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private List<Item> itemList;
    @Embedded
    private OwnerDetail detail;

    //Getters
        //constructor
        private Owner(){}
    public Long getId() {
        return id;
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
        public Owner(Builder builder){
        id=builder.id;
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
    public static class Builder{
        private Long id;
        private String pk;
        private String startDate;
        private String endDate;
        private String name;
        private String surname;
        private String email;
        private List<Item> itemList;
        private OwnerDetail detail;

        //constructor for builder
        public Builder(String pk){
            this.pk = pk;
        }
        public Builder id(Long value){
            this.id = value;
            return this;
        }
        public Builder startDate(String value){
            this.startDate = value;
            return this;
        }
        public Builder endDate(String value){
            this.endDate = value;
            return this;
        }
        public Builder name(String value){
            this.name = value;
            return this;
        }
        public Builder surname(String value){
            this.surname = value;
            return this;
        }
        public Builder email(String value){
            this.email = value;
            return this;
        }
        public Builder itemList(List<Item> value){
            this.itemList = value;
            return this;
        }
        public Builder detail(OwnerDetail value){
            this.detail = value;
            return this;
        }

        //Copy the builder
        public Builder copy(Owner value){
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
            public Owner build(){
            return new Owner(this);
        }


    }//Builder

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Owner)) return false;

        Owner object = (Owner) o;
        return !(id != null ? !id.equals(object.id) : object.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", pk='" + pk + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
