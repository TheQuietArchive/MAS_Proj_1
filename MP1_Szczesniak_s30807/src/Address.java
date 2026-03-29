import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Address implements Serializable{
    private String city;
    private String street;
    private String postalCode;
    private static List<Address> extent = new ArrayList<>();

    public Address(String city, String street, String postalCode) {
        setCity(city);
        setStreet(street);
        setPostalCode(postalCode);
        extent.add(this);
    }

    public void setCity(String city) {
        if (city == null || city.isBlank()){
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.city = city;
    }

    public void setStreet(String street) {
        if (street == null || street.isBlank()){
            throw new IllegalArgumentException("Street cannot be null or empty");
        }
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        if (postalCode == null || postalCode.isBlank()){
            throw new IllegalArgumentException("Postal code cannot be null or empty");
        }
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public String getStreet() {
        return this.street;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public static List<Address> getExtent() {
        return extent;
    }

    @Override
    public String toString() {
        return "\n\tcity: " + getCity() + ",\n\tstreet: " + getStreet()
                + ",\n\tpostal code: " + getPostalCode();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Address>) stream.readObject();
    }
}
