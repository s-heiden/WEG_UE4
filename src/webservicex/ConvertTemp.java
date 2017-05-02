
package webservicex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="Temperature" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="FromUnit" type="{http://www.webserviceX.NET/}TemperatureUnit"/>
 *         &lt;element name="ToUnit" type="{http://www.webserviceX.NET/}TemperatureUnit"/>
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
    "temperature",
    "fromUnit",
    "toUnit"
})
@XmlRootElement(name = "ConvertTemp")
public class ConvertTemp {

    @XmlElement(name = "Temperature")
    protected double temperature;
    @XmlElement(name = "FromUnit", required = true)
    @XmlSchemaType(name = "string")
    protected TemperatureUnit fromUnit;
    @XmlElement(name = "ToUnit", required = true)
    @XmlSchemaType(name = "string")
    protected TemperatureUnit toUnit;

    /**
     * Ruft den Wert der temperature-Eigenschaft ab.
     * 
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Legt den Wert der temperature-Eigenschaft fest.
     * 
     */
    public void setTemperature(double value) {
        this.temperature = value;
    }

    /**
     * Ruft den Wert der fromUnit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureUnit }
     *     
     */
    public TemperatureUnit getFromUnit() {
        return fromUnit;
    }

    /**
     * Legt den Wert der fromUnit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureUnit }
     *     
     */
    public void setFromUnit(TemperatureUnit value) {
        this.fromUnit = value;
    }

    /**
     * Ruft den Wert der toUnit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureUnit }
     *     
     */
    public TemperatureUnit getToUnit() {
        return toUnit;
    }

    /**
     * Legt den Wert der toUnit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureUnit }
     *     
     */
    public void setToUnit(TemperatureUnit value) {
        this.toUnit = value;
    }

}
