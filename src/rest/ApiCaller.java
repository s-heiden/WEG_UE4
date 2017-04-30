package rest;

import model.Patient;
import utility.Config;

import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonArray;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class ApiCaller {
    private List<Patient> patients = new ArrayList<>();
    private static Client client;
    public List<Patient> getPatients() {
        return patients;
    }

    public ApiCaller(){
        if (client == null) {
            client = ClientBuilder.newClient();
        }
    }

    public Patient initPatientVitalData() {
        WebTarget target = client.target(Config.REST_SHOW_URL);
        String jsonResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
        JsonReader reader = Json.createReader(new StringReader(jsonResponse));
        JsonObject jsonObject = reader.readObject();
        return jsonObjectToPatient(jsonObject);

    }

    public void initPatients() {
        WebTarget target = client.target(Config.REST_INDEX_URL);
        String jsonResponse = target.request(MediaType.APPLICATION_JSON).get(String.class);
        JsonReader reader = Json.createReader(new StringReader(jsonResponse));
        JsonArray jsonArray = reader.readArray();

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.getJsonObject(i);
            Patient patient = jsonObjectToPatient(jsonObject);
            patients.add(patient);
        }
    }

    private Patient jsonObjectToPatient(JsonObject jsonObject) {
        Patient patient = new Patient();
        patient.setId(jsonObject.getString("id"));
        patient.setDiastolicPressure(
                Integer.parseInt(jsonObject.getString("diastolic_pressure"))
        );
        patient.setSystolicPressure(
                Integer.parseInt(jsonObject.getString("systolic_pressure"))
        );
        patient.setHeartRate(Integer.parseInt(jsonObject.getString("heart_rate")));
        patient.setPressureUnit(jsonObject.getString("pressure_unit"));
        patient.setHeartRateUnit(jsonObject.getString("heart_rate_unit"));

        // process the name
        String name = jsonObject.getString("name");
        if (!name.equals("") & name.contains(" ")) {
            patient.setFirstName(name.substring(0, name.lastIndexOf(" ")));
            patient.setLastName(name.substring(name.lastIndexOf(" ") + 1, name.length()));
        } else {
            patient.setFirstName("");
            patient.setLastName("");
        }
        return patient;
    }

    /**
     * Posts the given Patient object as a JSON String to the target of this ApiCaller
     *
     * @param patient the Patient object which is to be posted
     */
    public String sendAsJson(Patient patient) {
        /*
            {
               "id":"vital_data",
               "name":"Vital Data",
               "diastolic_pressure":"80",
               "systolic_pressure":"120",
               "heart_rate":"60",
               "pressure_unit":"mm Hg",
               "heart_rate_unit":"bpm"
            }
         */
        Client sendClient = ClientBuilder.newClient();
        WebTarget target = sendClient.target(Config.REST_ADD_URL);
        JsonObject value = Json.createObjectBuilder()
                .add("id", String.valueOf(patient.getId()) + patient.getBirthdateFormatted())
                .add("name", patient.getFirstName() + " " + patient.getLastName())
                .add("diastolic_pressure", patient.getDiastolicPressure())
                .add("systolic_pressure", patient.getSystolicPressure())
                .add("heart_rate", patient.getHeartRate())
                .add("pressure_unit", patient.getPressureUnit())
                .add("heart_rate_unit", patient.getHeartRateUnit().toLowerCase())
                .build();
        System.out.println(value.toString());
        Entity e = Entity.json(value);
        Response r = target.request(MediaType.APPLICATION_JSON).post(e);
        return "success";
    }
}
