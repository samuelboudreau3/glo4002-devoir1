package org.example;

import java.util.ArrayList;

public class GravityTriageStrategy implements TriageStrategy {
    @Override
    public void addToWaitingList(String name, int gravity, VisibleSymptom symptom, ArrayList<String> doctorWaitingList, ArrayList<String> radiologyWaitingList) {
        if (gravity > 5) {
            doctorWaitingList.addFirst(name);
        }
        else  {
            doctorWaitingList.add(name);
        }
    }
}
