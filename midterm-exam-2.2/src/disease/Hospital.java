package disease;

import java.util.ArrayList;

import util.Patient;
import util.SevereLevel;

public class Hospital {
    private ArrayList<Patient> patients;

    public Hospital() {
        this.patients = new ArrayList<Patient>();
    }

    public void admit(String firstname, String lastname, String id, String disease, boolean isVacinated) {
        Disease d = null;
        switch (disease) {
            case "Covid19":
                d = new Covid19();
                break;
            case "Hypopnea":
                d = new Hypopnea();
                break;
            case "Delta":
                d = new Delta();
                break;
        }

        Patient p = new Patient(firstname, lastname, id, d, isVacinated);
        this.patients.add(p);
    }

    public ArrayList<Patient> getCovidPatients(SevereLevel s) {
        ArrayList<Patient> covidPatients = new ArrayList<Patient>();
        for (Patient p : this.patients) {
            boolean isVaccinated = p.isVaccinated();
            Disease d = p.getDisease();
            if ((d.toString().equals("Covid19") || d.toString().equals("Delta"))  && p.getDisease().getSevereLevel(isVaccinated).equals(s)) {
                covidPatients.add(p);
            }
        }
        return covidPatients;
    }


    public ArrayList<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

}
