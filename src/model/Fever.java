package model;

import rest.ApiCaller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 * Created by Katharina on 01.05.2017.
 */
@ManagedBean(name = "fever")
@RequestScoped
public class Fever {

    private double celsius;
    private double fahrenheit;

    public void callWebServiceClient(){
        // calls webserviceclient
        celsius = utility.SoapCaller.getCelsius(fahrenheit);
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }



}
