import jakarta.xml.bind.annotation.XmlElement;

public class Individual {

    private final String name;

    private final Address address;

    public Individual(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @XmlElement
    public Address getAddress() {
        return address;
    }

    @XmlElement
    public String getName() {
        return name;
    }
}
