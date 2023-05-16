
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
 *         &lt;element name="CapitalCityResult" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "capitalCityResult"
})
@XmlRootElement(name = "CapitalCityResponse")
public class CapitalCityResponse {

    @XmlElement(name = "CapitalCityResult", required = true)
    protected String capitalCityResult;

    /**
     * Obtiene el valor de la propiedad capitalCityResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapitalCityResult() {
        return capitalCityResult;
    }

    /**
     * Define el valor de la propiedad capitalCityResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapitalCityResult(String value) {
        this.capitalCityResult = value;
    }

}
