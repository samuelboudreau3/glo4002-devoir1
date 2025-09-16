package org.example;

import java.util.ArrayList;

public class FifoTriageStrategy implements TriageStrategy {
    @Override
    public void addToWaitingList(String name, int gravity, VisibleSymptom symptom, ArrayList<String> doctorWaitingList, ArrayList<String> radiologyWaitingList) {
        doctorWaitingList.add(name);
    }
}
