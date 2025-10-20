import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;



void main() {

    Individuals list = Unmarshalling("person.xml");

    System.out.println(list.getList().get(0).getName());
}

public boolean Marshalling(Individuals list) {

    try(BufferedWriter bw = new BufferedWriter(new FileWriter("salida.xml"))){

        JAXBContext context = JAXBContext.newInstance(Individuals.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(list, bw);

        return true;
    }catch(Exception e){
        e.printStackTrace();
        return false;
    }
}

public Individuals Unmarshalling(String ruta) {

    try{
        JAXBContext context = JAXBContext.newInstance(Individuals.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        File file = new File(ruta);
        Individuals list = (Individuals) unmarshaller.unmarshal(file);

        return list;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}