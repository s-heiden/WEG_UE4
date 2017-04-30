package model;

import javax.faces.bean.ManagedBean;

import rest.ApiCaller;

@ManagedBean(name = "patientVitalData")
public class PatientVitalData {
    private Patient patient;

    public PatientVitalData() {
        ApiCaller apiCaller = new ApiCaller();
        this.patient = apiCaller.initPatientVitalData();
    }

    public String getId() {
        return patient.getId();
    }

    public String getFirstName() {
        return patient.getFirstName();
    }

    public String getLastName() {
        return patient.getLastName();
    }

    public String getBirthdate() {
        return patient.getBirthdate();
    }

    public int getDiastolicPressure() {
        return patient.getDiastolicPressure();
    }

    public int getSystolicPressure() {
        return patient.getSystolicPressure();
    }

    public int getHeartRate() {
        return patient.getHeartRate();
    }
}
