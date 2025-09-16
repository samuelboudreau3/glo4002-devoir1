package org.example;

import java.util.ArrayList;

public interface TriageStrategy {
    public void addToWaitingList(String name, int gravity, VisibleSymptom symptom, ArrayList<String> doctorWaitingList, ArrayList<String> radiologyWaitingList);
}
