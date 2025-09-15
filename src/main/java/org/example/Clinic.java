package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class Clinic {
    private ArrayList<String> doctorWaitingList;
    private ArrayList<String> radiologyWaitingList;

    public Clinic() {
        doctorWaitingList = new ArrayList<>();
        radiologyWaitingList = new ArrayList<>();
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        doctorWaitingList.add(name);

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