import org.example.Clinic;
import org.example.VisibleSymptom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.stream.Stream;


public class ClinicTest {
    String A_NAME = "John";
    String B_NAME = "Joe";
    Integer SecondInTheList = 1;
    VisibleSymptom A_SYMPTOM = VisibleSymptom.MIGRAINE;
    Integer A_GRAVITY = 4;
    Clinic clinic;


    @BeforeEach
    public void setup() {
        clinic = new Clinic();
    }

    @Test
    public void givenEmptyDoctorWaitingList_whenPatientArrives_thenPatientIsFirstInDoctorWaitingList() {
        // Arrange

        // Act
        clinic.triagePatient(A_NAME, A_GRAVITY, A_SYMPTOM);

        // Assert
        assert (clinic.getDoctorWaitingList().getFirst().equals(A_NAME));
    }

    @Test
    public void givenAPatient_whenOtherPatientArrive_thenPatientsAreInTheFIFOOrder() {
        //Arrange

        // Act
        clinic.triagePatient(A_NAME, A_GRAVITY, A_SYMPTOM);
        clinic.triagePatient(B_NAME, A_GRAVITY, A_SYMPTOM);

        //Assert
        assert (clinic.getDoctorWaitingList().getFirst().equals(A_NAME));
        assert (clinic.getDoctorWaitingList().get(SecondInTheList).equals(B_NAME));
    }

    @Test
    public void givenAPatient_whenOtherPatientArriveWithFLU_thenPatientsAreInTheFIFOOrder() {
        //Arrange

        // Act
        clinic.triagePatient(A_NAME, A_GRAVITY, A_SYMPTOM);
        clinic.triagePatient(B_NAME, A_GRAVITY, VisibleSymptom.FLU);

        //Assert
        assert (clinic.getDoctorWaitingList().getFirst().equals(A_NAME));
        assert (clinic.getDoctorWaitingList().get(SecondInTheList).equals(B_NAME));
    }

    @Test
    public void givenNothing_whenArriveWithASprain_thenShouldBeFirstInRadiologyWaitingList() {
        //Arrange

        // Act
        clinic.triagePatient(A_NAME, A_GRAVITY, VisibleSymptom.SPRAIN);

        //Assert
        assert (clinic.getRadiologyWaitingList().getFirst().equals(A_NAME));
    }

    @Test
    public void givenNothing_whenArriveWithABrokenBone_thenShouldBeFirstInRadiologyWaitingList() {
        //Arrange


        // Act
        clinic.triagePatient(A_NAME, A_GRAVITY, VisibleSymptom.BROKEN_BONE);

        //Assert
        assert (clinic.getRadiologyWaitingList().getFirst().equals(A_NAME));
    }
    

//    @Test
//    public void givenNothing_whenPatientArrivesWithNonRadiologySymptom_thenNotIncludedInRadiologyWaitingList() {
//        //Arrange
//
//        // Act
//        clinic.triagePatient(A_NAME, A_GRAVITY, A_SYMPTOM);
//
//        //Assert
//        assert (clinic.getRadiologyWaitingList().getFirst().equals(A_NAME));
//    }

//    # Is radiology
//    @ParameterizedTest
//    @ValueSource(strings = {"COLD", "FLU", "MIGRAINE"})
//    public void givenNonRadiologySymptomByName_whenPatientArrives_thenNotIncludedInRadiologyWaitingList(String symptomName) {
//        VisibleSymptom symptom = VisibleSymptom.valueOf(symptomName);
//        clinic.triagePatient(A_NAME, A_GRAVITY, symptom);
//
//        assert !clinic.getRadiologyWaitingList().contains(A_NAME);
//    }


//    @Test
//    public void GivenAPatient_WhenMigraine_ShouldbeFirst....
}
