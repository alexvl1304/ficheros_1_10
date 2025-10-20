import jakarta.xml.bind.annotation.XmlElement;

public class Address {

    @XmlElement
    public String getZip() {
        return zip;
    }

    @XmlElement
    public String getCity() {
        return city;
    }

    @XmlElement
    public String getStreet() {
        return street;
    }

    private final String zip;
    private final String city;
    private final String street;

    public Address(String zip, String city, String street) {
        this.zip = zip;
        this.city = city;
        this.street = street;
    }
}
