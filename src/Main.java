import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

void main() {

    Individuals list = Unmarshalling("person.xml");

    System.out.println(list.getList().get(0).getName());

    Marshalling(list);
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
        Individuals lista = (Individuals) unmarshaller.unmarshal(file);

        return lista;
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}