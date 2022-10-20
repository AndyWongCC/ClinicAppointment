package appointment;

import appointment.Appointment;
import appointment.AppointmentType;
/**
 * @author Andy
 *
 * @version Lab5
 *
 * @see
 */
public class Standard extends Appointment {
    private String caseDesc;  //caseDescription of standard appointment

    public Standard(int appointmentID, int patientId, int doctorId, String date, AppointmentType appType) throws Exception {
        super(appointmentID, patientId, doctorId, date, appType);
        this.caseDesc = "";
    }

    public String getInfo() {
        return caseDesc;
    }

    @Override
    public void addInfo(String info) {
        caseDesc += info;
    }

    @Override
    public boolean getCheck() {
        return true;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc;
    }

    @Override
    public String toString(){
        return "|" + super.appointmentID + " | " + "case Desc: " + getInfo() + "|";
    }

}

