
package Services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListOfContinentsByNameResult" type="{http://www.oorsprong.org/websamples.countryinfo}ArrayOftContinent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listOfContinentsByNameResult"
})
@XmlRootElement(name = "ListOfContinentsByNameResponse")
public class ListOfContinentsByNameResponse {

    @XmlElement(name = "ListOfContinentsByNameResult", required = true)
    protected ArrayOftContinent listOfContinentsByNameResult;

    /**
     * Obtiene el valor de la propiedad listOfContinentsByNameResult.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOftContinent }
     *     
     */
    public ArrayOftContinent getListOfContinentsByNameResult() {
        return listOfContinentsByNameResult;
    }

    /**
     * Define el valor de la propiedad listOfContinentsByNameResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOftContinent }
     *     
     */
    public void setListOfContinentsByNameResult(ArrayOftContinent value) {
        this.listOfContinentsByNameResult = value;
    }

}
