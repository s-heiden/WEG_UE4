package model;

import rest.ApiCaller;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "patientList")
public class PatientList {
    private List<Patient> patients = new ArrayList<>();

    public PatientList() {
        ApiCaller apiCaller = new ApiCaller();
        apiCaller.initPatients();
        this.patients = apiCaller.getPatients();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


}
