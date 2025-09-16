package org.example;

import java.util.ArrayList;

public class Clinic {
    private ArrayList<String> doctorWaitingList;
    private ArrayList<String> radiologyWaitingList;
    private TriageStrategy triageStrategy;

    public Clinic(TriageStrategy triageStrategy) {
        this.triageStrategy = triageStrategy;
        this.doctorWaitingList = new ArrayList<>();
        this.radiologyWaitingList = new ArrayList<>();
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        triageStrategy.addToWaitingList(name, gravity, visibleSymptom, doctorWaitingList, radiologyWaitingList);

        if (visibleSymptom == VisibleSymptom.SPRAIN || visibleSymptom == VisibleSymptom.BROKEN_BONE) {
            radiologyWaitingList.add(name);
        }
    }

    public ArrayList<String> getDoctorWaitingList() {
        return doctorWaitingList;
    }

    public ArrayList<String> getRadiologyWaitingList() {
        return radiologyWaitingList;
    }

//    public boolean isRadiologySymptom(VisibleSymptom visibleSymptom) {
//
//    }

    // D'autres méthodes peuvent être nécessaires

}