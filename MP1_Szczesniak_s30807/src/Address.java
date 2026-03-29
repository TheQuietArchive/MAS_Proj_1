import java.io.Serializable;

public class Address implements Serializable{
    private String city;
    private String street;
    private String postalCode;

    public Address(String city, String street, String postalCode) {
        setCity(city);
        setStreet(street);
        setPostalCode(postalCode);
    }

    public void setCity(String city) {
        if (city == null){
            //wyrzuc blad
        }
        if (city == ""){
            //wyrzuc blad
        }
        this.city = city;
    }

    public void setStreet(String street) {
        if (city == null){
            //wyrzuc blad
        }
        if (city == ""){
            //wyrzuc blad
        }
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        if (city == null){
            //wyrzuc blad
        }
        if (city == ""){
            //wyrzuc blad
        }
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
