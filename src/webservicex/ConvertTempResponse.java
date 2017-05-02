
package webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConvertTempResult" type="{http://www.w3.org/2001/XMLSchema}double"/>
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
    "convertTempResult"
})
@XmlRootElement(name = "ConvertTempResponse")
public class ConvertTempResponse {

    @XmlElement(name = "ConvertTempResult")
    protected double convertTempResult;

    /**
     * Ruft den Wert der convertTempResult-Eigenschaft ab.
     * 
     */
    public double getConvertTempResult() {
        return convertTempResult;
    }

    /**
     * Legt den Wert der convertTempResult-Eigenschaft fest.
     * 
     */
    public void setConvertTempResult(double value) {
        this.convertTempResult = value;
    }

}
