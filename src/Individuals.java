import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "individuals")
@XmlAccessorType(XmlAccessType.FIELD)
public class Individuals {

    @XmlElement(name = "individual")
    private ArrayList<Individual> list;

    public Individuals() {

        list = new ArrayList<>();
    }

    public void addIndividual(Individual i) {

        list.add(i);
    }

    public ArrayList<Individual> getList() {
        return list;
    }
}
