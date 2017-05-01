package model;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import rest.ApiCaller;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "patientList")
public class PatientList {
    public LineChartModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(LineChartModel patientModel) {
        this.patientModel = patientModel;
    }

    private LineChartModel patientModel;

    private List<Patient> patients = new ArrayList<>();

    public PatientList() {
        ApiCaller apiCaller = new ApiCaller();
        apiCaller.initPatients();
        this.patients = apiCaller.getPatients();
        initChartModel();
    }

    private void initChartModel(){
        patientModel = new LineChartModel();
        patientModel.setTitle("Vital Data Chart");
        patientModel.setLegendPosition("e");
        patientModel.getAxes().put(AxisType.X, new CategoryAxis("Vital Data Type"));
        patientModel.getAxes().get(AxisType.Y).setLabel("Values");
        patientModel.getAxes().get(AxisType.Y).setMin(0);
        patientModel.getAxes().get(AxisType.Y).setMax(800);

        for (Patient p : patients) {
            LineChartSeries patientSeries = new LineChartSeries();

            patientSeries.setLabel(p.getFirstName() + " " + p.getLastName());
            patientSeries.set("Heartrate", p.getHeartRate());
            patientSeries.set("Blood Dia", p.getDiastolicPressure());
            patientSeries.set("Blood Sys", p.getSystolicPressure());
            patientModel.addSeries(patientSeries);
        }

    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


}
