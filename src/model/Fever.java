package model;

import org.primefaces.model.chart.MeterGaugeChartModel;
import rest.ApiCaller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "fever")
@RequestScoped
public class Fever implements Serializable {

    private double celsius;
    private double fahrenheit;
    private MeterGaugeChartModel meterGaugeModel;

    public Fever(){
        initMeterGaugeModel();
    }

    @PostConstruct
    public void init() {
        createMeterGaugeModel();
    }

    public MeterGaugeChartModel getMeterGaugeModel() {
        return meterGaugeModel;
    }

    private void createMeterGaugeModel() {
        meterGaugeModel = initMeterGaugeModel();
        meterGaugeModel.setMin(20);
        meterGaugeModel.setMax(45);
        meterGaugeModel.setTitle("Fever");
        meterGaugeModel.setSeriesColors("66cc66,93b75f,E7E658,cc6666");
        meterGaugeModel.setGaugeLabel("Degrees");
        meterGaugeModel.setGaugeLabelPosition("bottom");
        meterGaugeModel.setShowTickLabels(false);
//        meterGaugeModel.setLabelHeightAdjust(110);
//        meterGaugeModel.setIntervalOuterRadius(100);
    }

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

    public void setMeterGaugeModel(MeterGaugeChartModel meterGaugeModel){
        this.meterGaugeModel = meterGaugeModel;
    }


    private MeterGaugeChartModel initMeterGaugeModel() {
        List<Number> intervals = new ArrayList<Number>();
        intervals.add(20);
        intervals.add(25);
        intervals.add(30);
        intervals.add(35);
        intervals.add(40);
        intervals.add(45);

        return new MeterGaugeChartModel(celsius, intervals);
    }


}
