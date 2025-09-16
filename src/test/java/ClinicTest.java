import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class ClinicTest {
    String A_NAME = "John";
    String B_NAME = "Joe";
    Integer SECOND_IN_LIST = 1;
    VisibleSymptom A_SYMPTOM = VisibleSymptom.MIGRAINE;
    Integer A_GRAVITY = 1;
    Integer LOW_GRAVITY = 5;
    Integer HIGH_GRAVITY = 6;
    Clinic clinic_FIFO;
    Clinic clinic_GRAVITY;

    @BeforeEach
    public void setup() {
        TriageStrategy triageStrategy_FIFO = new FifoTriageStrategy();
        TriageStrategy triageStrategy_GRAVITY = new GravityTriageStrategy();
        clinic_FIFO = new Clinic(triageStrategy_FIFO);
        clinic_GRAVITY = new Clinic(triageStrategy_GRAVITY);
    }

    @Test
    public void givenEmptyDoctorWaitingList_whenPatientArrives_thenPatientIsFirstInDoctorWaitingList() {
        // Arrange

        // Act
        clinic_FIFO.triagePatient(A_NAME, A_GRAVITY, A_SYMPTOM);

        // Assert
        assert (clinic_FIFO.getDoctorWaitingList().getFirst().equals(A_NAME));
    }

    @Test
    public void givenAPatient_whenOtherPatientArrive_thenPatientsInDoctorListRespectFIFOOrder() {
        //Arrange

        // Act
        clinic_FIFO.triagePatient(A_NAME, A_GRAVITY, A_SYMPTOM);
        clinic_FIFO.triagePatient(B_NAME, A_GRAVITY, A_SYMPTOM);

        //Assert
        assert (clinic_FIFO.getDoctorWaitingList().getFirst().equals(A_NAME));
        assert (clinic_FIFO.getDoctorWaitingList().get(SECOND_IN_LIST).equals(B_NAME));
    }

    @Test
    public void givenAPatient_whenOtherPatientArriveWithFLU_thenPatientsInDoctorListRespectFIFOOrder() {
        //Arrange

        // Act
        clinic_FIFO.triagePatient(A_NAME, A_GRAVITY, A_SYMPTOM);
        clinic_FIFO.triagePatient(B_NAME, A_GRAVITY, VisibleSymptom.FLU);

        //Assert
        assert (clinic_FIFO.getDoctorWaitingList().getFirst().equals(A_NAME));
        assert (clinic_FIFO.getDoctorWaitingList().get(SECOND_IN_LIST).equals(B_NAME));
    }

    @Test
    public void givenNothing_whenArriveWithASprain_thenShouldBeFirstInRadiologyWaitingList() {
        //Arrange

        // Act
        clinic_FIFO.triagePatient(A_NAME, A_GRAVITY, VisibleSymptom.SPRAIN);

        //Assert
        assert (clinic_FIFO.getRadiologyWaitingList().getFirst().equals(A_NAME));
    }

    @Test
    public void givenNothing_whenArriveWithABrokenBone_thenShouldBeFirstInRadiologyWaitingList() {
        //Arrange

        // Act
        clinic_FIFO.triagePatient(A_NAME, A_GRAVITY, VisibleSymptom.BROKEN_BONE);

        //Assert
        assert (clinic_FIFO.getRadiologyWaitingList().getFirst().equals(A_NAME));
    }

//    @Test
//    public void givenNothing_whenPatientArrivesWithNonRadiologySymptom_thenNotIncludedInRadiologyWaitingList() {
//        //Arrange
//
//        // Act
//        clinic_FIFO.triagePatient(A_NAME, A_GRAVITY, A_SYMPTOM);
//
//        //Assert
//        assert (clinic_FIFO.getRadiologyWaitingList().getFirst().equals(A_NAME));
//    }
//    # Is radiology
//    @ParameterizedTest
//    @ValueSource(strings = {"COLD", "FLU", "MIGRAINE"})
//    public void givenNonRadiologySymptomByName_whenPatientArrives_thenNotIncludedInRadiologyWaitingList(String symptomName) {
//        VisibleSymptom symptom = VisibleSymptom.valueOf(symptomName);
//        clinic_FIFO.triagePatient(A_NAME, A_GRAVITY, symptom);
//
//        assert !clinic_FIFO.getRadiologyWaitingList().contains(A_NAME);
//    }

    @Test
    public void givenPatientAndClinicGravity_whenPatientWithGravityAboveThresholdArrives_ThenShouldBeFirstInDoctorWaitingList() {
        //Arrange
        clinic_GRAVITY.triagePatient(A_NAME, A_GRAVITY, VisibleSymptom.MIGRAINE);

        // Act
        clinic_GRAVITY.triagePatient(B_NAME, HIGH_GRAVITY, VisibleSymptom.MIGRAINE);

        //Assert
        assert (clinic_GRAVITY.getDoctorWaitingList().getFirst().equals(B_NAME));
    }

    @Test
    public void givenPatientAndClinicGravity_whenPatientWithGravityBelowThresholdArrives_ThenShouldBeSecondInDoctorWaitingList() {
        //Arrange
        clinic_GRAVITY.triagePatient(A_NAME, A_GRAVITY, VisibleSymptom.MIGRAINE);

        // Act
        clinic_GRAVITY.triagePatient(B_NAME, LOW_GRAVITY, VisibleSymptom.MIGRAINE);

        //Assert
        assert (clinic_GRAVITY.getDoctorWaitingList().get(SECOND_IN_LIST).equals(B_NAME));
    }
    @Test
    public void givenPatientAndClinicGravity_WhenPatientWithRadiologySymptomAndGravityAboveThresholdArrives_ThenShouldBeSecondInRadiologyWaitingList()
    {
        //Arrange
        clinic_GRAVITY.triagePatient(A_NAME, A_GRAVITY, VisibleSymptom.BROKEN_BONE);

        // Act
        clinic_GRAVITY.triagePatient(B_NAME, HIGH_GRAVITY, VisibleSymptom.BROKEN_BONE);

        //Assert
        assert (clinic_GRAVITY.getRadiologyWaitingList().get(SECOND_IN_LIST).equals(B_NAME));
    }


//    @Test
//    public void givenAPatientClinicWithGravity_whenPatientWithGravitySixArrives_ThenShouldNotBetInRadiologyWaitingList() {
//        //Arrange
//
//        // Act
//        clinic_GRAVITY.triagePatient(B_NAME, HIGH_GRAVITY, VisibleSymptom.MIGRAINE);
//
//        //Assert
//        assert (!clinic_GRAVITY.getRadiologyWaitingList().getFirst().doequals(B_NAME));
//    }



//    @Test
//    public void GivenAPatient_WhenMigraine_ShouldbeFirst....
}
