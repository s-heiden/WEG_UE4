package utility;

import webservicex.ConvertTemperature;
import webservicex.ConvertTemperatureSoap;
import webservicex.TemperatureUnit;

public class SoapCaller {

    public static double getCelsius(double fahrenheit){
        ConvertTemperature convertTemperature = new ConvertTemperature();
        ConvertTemperatureSoap convertTemperatureSoap = convertTemperature.getConvertTemperatureSoap();
        return convertTemperatureSoap.convertTemp(fahrenheit, TemperatureUnit.DEGREE_FAHRENHEIT,
                TemperatureUnit.DEGREE_CELSIUS);
    }

}
