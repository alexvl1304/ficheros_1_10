import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

void main() {

    Individuals list = Unmarshalling("person.xml");

    System.out.println(list.getList().get(0).getName());

    Marshalling(list);

    System.out.println(validarXMLconXSD("salida.xml","full_person.xsd"));

    System.out.println(validarXMLconXSD("ejemplo.xml","full_person.xsd"));
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


public static boolean validarXMLconXSD(String xmlPath, String xsdPath) {
    try {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        Schema schema = factory.newSchema(new File(xsdPath));

        Validator validator = schema.newValidator();

        validator.validate(new StreamSource(new File(xmlPath)));

        return true;
    } catch (SAXException e) {
        System.out.println("El XML no es válido: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Error durante la validación: " + e.getMessage());
    }
    return false;
}