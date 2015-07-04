package deneme;
 
import java.io.File;
import java.util.Scanner;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class createXML {
 
	private String firstName;
	private String lastName;
	private String age;
	private String id;
 
	public static void main(String argv[]) {
 
		try {
			createXML person = new createXML();
			DocumentBuilderFactory xmlFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder xmlBuilder = xmlFactory.newDocumentBuilder();
 
			// Tablo ismi
			Document table = xmlBuilder.newDocument();
			Element db = table.createElement("Persons");
			table.appendChild(db);
 
			Scanner count = new Scanner(System.in);
			Scanner input = new Scanner(System.in);
 
			System.out.println("Kişiler tablosuına kaç kişi eklemek istiyorsunuz? :");
			int id_count = count.nextInt();
 
			for (int i = 1; i <= id_count; i++) {
				Element self = table.createElement("Person");
				db.appendChild(self);
 
				Attr attr = table.createAttribute("id");
				attr.setValue(i + "");
				self.setAttributeNode(attr);
 
				System.out.println("İsim gir: ");
				Element firstName = table.createElement("first_name");
				person.setFirstName(input.nextLine());
				firstName.appendChild(table.createTextNode(person
						.getFirstName()));
				self.appendChild(firstName);
 
				System.out.println("Soyisim gir: ");
				Element lastName = table.createElement("last_name");
				person.setLastName(input.nextLine());
				lastName.appendChild(table.createTextNode(person.getLastName()));
				self.appendChild(lastName);
 
				System.out.println("Yaş gir: ");
				Element age = table.createElement("age");
				person.setAge(input.nextLine());
				age.appendChild(table.createTextNode(person.getAge()));
				self.appendChild(age);
				
				System.out.println("Id gir: ");
				Element id = table.createElement("id");
				person.setId(input.nextLine());
				id.appendChild(table.createTextNode(person.getId()));
				self.appendChild(id);
			}
 
			// XML olarak kayıt etme
			TransformerFactory trFactory = TransformerFactory.newInstance();
			Transformer transformer = trFactory.newTransformer();
			DOMSource source = new DOMSource(table);
			StreamResult result = new StreamResult(new File("C:\\file.xml"));
 
			transformer.transform(source, result);
 
			System.out.println("Dosya kayıt edildi!");
 
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
	public String getFirstName() {
		return firstName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	public String getLastName() {
		return lastName;
	}
 
	public void setAge(String age) {
		this.age = age;
	}
 
	public String getAge() {
		return age;
	}
	public void setId(String id) {
		this.id = id;
	}
 
	public String getId() {
		return id;
	}
}
