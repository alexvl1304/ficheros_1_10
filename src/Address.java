import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    private String zip;

    private String city;

    private String street;

    public Address() {
        this.zip = null;
        this.city = null;
        this.street = null;
    }

    public Address(String zip, String city, String street) {
        this.zip = zip;
        this.city = city;
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
