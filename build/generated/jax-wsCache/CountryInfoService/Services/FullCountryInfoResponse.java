
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
 *         &lt;element name="FullCountryInfoResult" type="{http://www.oorsprong.org/websamples.countryinfo}tCountryInfo"/>
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
    "fullCountryInfoResult"
})
@XmlRootElement(name = "FullCountryInfoResponse")
public class FullCountryInfoResponse {

    @XmlElement(name = "FullCountryInfoResult", required = true)
    protected TCountryInfo fullCountryInfoResult;

    /**
     * Obtiene el valor de la propiedad fullCountryInfoResult.
     * 
     * @return
     *     possible object is
     *     {@link TCountryInfo }
     *     
     */
    public TCountryInfo getFullCountryInfoResult() {
        return fullCountryInfoResult;
    }

    /**
     * Define el valor de la propiedad fullCountryInfoResult.
     * 
     * @param value
     *     allowed object is
     *     {@link TCountryInfo }
     *     
     */
    public void setFullCountryInfoResult(TCountryInfo value) {
        this.fullCountryInfoResult = value;
    }

}
