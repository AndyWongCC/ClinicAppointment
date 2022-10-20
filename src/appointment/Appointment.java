package appointment;

import tools.Utils;
/**
 * @author Andy
 *
 * @version Lab5
 *
 * @see
 */
public abstract class Appointment {
    int appointmentID; //appointment ID
    int patientID; //patient ID
    int doctorID; //doctor ID
    String date; //date of appointment
    AppointmentType appointmentType; //enum covid/standard

    public Appointment(int appointmentID, int patientID, int doctorID, String date, AppointmentType appointmentType) throws Exception {
        this.appointmentID = appointmentID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        if (setDate(date) == false) {
            throw new Exception("Invalid Date");
        }
        this.appointmentType = appointmentType;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public int getPatientID() {
        return patientID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public String getDate() {
        return date;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public boolean setDate(String date){
        boolean check = false;
        if (Utils.checklength(date, 10, 10)) {
            check = true;
            this.date = date;
        }
        return check;
    }
    public abstract String getInfo();
    public abstract void addInfo(String info);
    public abstract boolean getCheck();
}
