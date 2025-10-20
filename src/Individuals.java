import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Individuals {

    private ArrayList<Individual> list;

    public Individuals() {

        list = new ArrayList<>();
    }

    @XmlElement
    public ArrayList<Individual> getList() {

        return list;
    }

    public void addIndividual(Individual i) {

        list.add(i);
    }
}
