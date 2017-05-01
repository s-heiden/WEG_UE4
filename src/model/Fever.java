package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * Created by Katharina on 01.05.2017.
 */
@ManagedBean(name = "fever")
@RequestScoped
public class Fever {

    private float celsius;
    private float fahrenheit;

    public void callWebServiceClient(){
        //calls webserviceclient
        //celsius =;
    }

    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public float getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(float fahrenheit) {
        this.fahrenheit = fahrenheit;
    }



}
