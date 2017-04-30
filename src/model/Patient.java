package model;

import rest.ApiCaller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "patient")
@RequestScoped
public class Patient {
    private String id = "1234";
    private String firstName = "Martha";
    private String lastName = "Muster";
    private int diastolicPressure = 80;
    private int systolicPressure = 120;
    private int heartRate = 60;
    private String pressureUnit = "mm Hg";
    private String heartRateUnit = "BPM";
    private String birthdate = "01.01.1990";

    public Patient(){
    }

    /**
     * @return  the birthdate '01.01.1900' is transformed to '010100'
     */
    public String getBirthdateFormatted(){
        // TODO: check if input is OK
        return birthdate.substring(0,2)
                + birthdate.substring(3,5)
                + birthdate.substring(8,10);
    }

    public String getBirthdate(){
        return this.birthdate;
    }

    public void setBirthdate(String birthdate){
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public String getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(String pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public String getHeartRateUnit() {
        return heartRateUnit;
    }

    public void setHeartRateUnit(String heartRateUnit) {
        this.heartRateUnit = heartRateUnit;
    }

    public String save(){
        ApiCaller apiCaller = new ApiCaller();
        return (apiCaller.sendAsJson(this));
    }

}
