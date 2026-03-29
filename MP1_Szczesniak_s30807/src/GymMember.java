import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class GymMember implements Serializable{
    //Extent
    private static List<GymMember> extent = new ArrayList<>();

    //Atributes
    private List<String> names = new ArrayList<>();
    private String surname;
    private Address address;
    private String phoneNumber;
    private double weight;
    private double height;
    private static String gymName = "Best Gym";

    //Constructor
    public GymMember(List<String> names, String surname, String city, String street, String postalCode, Double weight, Double height, String phoneNumber) {
        addName(names);
        setSurname(surname);
        setAddress(city, street, postalCode);
        setPhoneNumber(phoneNumber);
        setWeight(weight);
        setHeight(height);

        extent.add(this);
    }

    public GymMember(List<String> names, String surname, String city, String street, String postalCode, Double weight, Double height) {
        addName(names);
        setSurname(surname);
        setAddress(city, street, postalCode);
        setPhoneNumber(null);
        setWeight(weight);
        setHeight(height);

        extent.add(this);
    }


    //Setters
    public void addName(List<String> names){
        if (names == null || names.isEmpty()){
            throw new IllegalArgumentException("Names list cannot be null or empty.");
        }
        for (String name : names){
            if (name == null || name.isBlank()){
                throw new IllegalArgumentException("Name cannot be null or empty.");
            }
            this.names.add(name);
        }
    }

    public void removeName(List<String> names){
        if (names == null || names.isEmpty()){
            throw new IllegalArgumentException("Names list cannot be null or empty");
        }
        if (this.names.size() - names.size() < 1){
            throw new IllegalStateException("Cannot remove all names, there must be at least one left.");
        }
        this.names.removeAll(names);
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isBlank()){
            throw new IllegalArgumentException("Surname cannot be null or empty");
        }
        this.surname = surname;
    }

    public void setWeight(double weight) {
        if (weight<=0){
            throw new IllegalArgumentException("Weight must be greater than zero");
        }
        this.weight = weight;
    }

    public void setHeight(double height) {
        if (height<=0){
            throw new IllegalArgumentException("Height must be greater than zero");
        }
        this.height = height;
    }

    public void setAddress(String city, String street, String postalCode) {
        this.address = new Address(city,street,postalCode);
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null){
            this.phoneNumber = null;
            return;
        }
        if (phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number can't be empty. (But can be null)");
        }
        this.phoneNumber = phoneNumber;
    }

    public static void setGymName(String gymName) {
        if (gymName == null || gymName.isBlank()){
            throw new IllegalArgumentException("Gym name cannot be null or empty");
        }
        GymMember.gymName = gymName;
    }

    //Getters
    public List<String> getNames() {
        return java.util.Collections.unmodifiableList(this.names);
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    private static String getGymName() {
        return gymName;
    }

    public double getBMI(){
        return this.weight/Math.sqrt((this.height/100));
    }

    public static List<GymMember> getExtent() {
        return java.util.Collections.unmodifiableList(extent);
    }

    public static List<GymMember> getListOfMembersWithBMIHigherThan(double BMI) {
        return java.util.Collections.unmodifiableList(
                extent.stream()
                .filter(member -> member.getBMI() > BMI)
                .toList()
        );
    }

    //toString
    @Override
    public String toString() {
        return "GymMember info:" +
                "\nnames: " + getNames() +
                ",\nsurname: " + getSurname() +
                ",\naddress: " + getAddress() +
                ",\nphoneNumber: " + getPhoneNumber() +
                ",\nweight: " + getWeight() + " kg" +
                ",\nheight: " + getHeight() + " cm" +
                ",\ngym name: " + getGymName() + "\n\n";
    }

    //Write and Read Extent
    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<GymMember>) stream.readObject();
    }

}
