package model;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import org.primefaces.model.chart.MeterGaugeChartModel;

import javax.faces.bean.ManagedBean;


@ManagedBean(name = "fever")
public class Fever implements Serializable {
    private double fahrenheit;
    private double celsius;
    private MeterGaugeChartModel model;

    public Fever(){
        fahrenheit = 0;
        celsius = 0;
    }

    private void updateMeterGaugeChartModel() {
        // init MeterGaugeChartModel
        List<Number> intervals = new ArrayList<Number>();
        intervals.add(celsius);
        intervals.add(celsius + fahrenheit);
        model = new MeterGaugeChartModel(celsius, intervals);
        model.setTitle("Celsius/Fahrenheit");
        model.setGaugeLabel("Grad");
    }

    public void callWebServiceClient(){
        // calls webserviceclient
        celsius = utility.SoapCaller.getCelsius(fahrenheit);
        updateMeterGaugeChartModel();
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

    public MeterGaugeChartModel getModel() { return model; }

    public boolean formIsFilled(){
        return !(fahrenheit == 0 && celsius == 0);
    }

}
