/*TODO:
- weryfikacje czy weight,height > 0 i wyrzucanie wtedy bledu
- wyrzucenie bledow (w Address tez)

Pytania:
- czy musze wstawiac setPhoneNumber(null); do konstr. ktory nie przyjmuje phoneNumber
*/

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
// z phone number
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
        if (names == null){
            //wyrzuc blad
        }
        if (names.isEmpty()){
            //wyrzuc blad
        }
        for (String name : names){
            if (name == ""){
                //wyrzuc blad
            }
            this.names.add(name);
        }
    }

    public void removeName(List<String> names){
        if (this.names.size()==1){
            //wyrzuc blad
        }
        if (names == null){
            //wyrzuc blad
        }
        if (names.isEmpty()){
            //wyrzuc blad
        }
        for (String name : names){
            this.names.remove(name);
        }
    }

    public void setSurname(String surname) {
        if (surname == null){
            //wyrzuc blad
        }
        if (surname == ""){
            // wyrzuc blad
        }
        this.surname = surname;
    }

    public void setWeight(double weight) {
        if (weight<=0){
            // wyrzuc blad
        }
        this.weight = weight;
    }

    public void setHeight(double height) {
        if (height<=0){
            // wyrzuc blad
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
        if (phoneNumber == ""){
            //wyrzuc blad
        }
        this.phoneNumber = phoneNumber;
    }

    public static void setGymName(String gymName) {
        if (gymName == null){
            //wyrzuc blad
        }
        if (gymName == ""){
            //wyrzuc blad
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

    public static String getGymName() {
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

}
