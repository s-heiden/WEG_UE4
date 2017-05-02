
package webservicex;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ConvertTemperatureSoap", targetNamespace = "http://www.webserviceX.NET/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ConvertTemperatureSoap {


    /**
     * 
     * @param temperature
     * @param toUnit
     * @param fromUnit
     * @return
     *     returns double
     */
    @WebMethod(operationName = "ConvertTemp", action = "http://www.webserviceX.NET/ConvertTemp")
    @WebResult(name = "ConvertTempResult", targetNamespace = "http://www.webserviceX.NET/")
    @RequestWrapper(localName = "ConvertTemp", targetNamespace = "http://www.webserviceX.NET/", className = "net.webservicex.ConvertTemp")
    @ResponseWrapper(localName = "ConvertTempResponse", targetNamespace = "http://www.webserviceX.NET/", className = "net.webservicex.ConvertTempResponse")
    public double convertTemp(
        @WebParam(name = "Temperature", targetNamespace = "http://www.webserviceX.NET/")
        double temperature,
        @WebParam(name = "FromUnit", targetNamespace = "http://www.webserviceX.NET/")
        TemperatureUnit fromUnit,
        @WebParam(name = "ToUnit", targetNamespace = "http://www.webserviceX.NET/")
        TemperatureUnit toUnit);

}
