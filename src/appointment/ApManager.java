package appointment;

import tools.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * @author Andy
 *
 * @version Lab5
 *
 * @see
 */
public class ApManager implements AppointmentManager {

    private Map<Integer, Appointment> appointments = new HashMap<>(); //map
    private static ApManager apInstance = null; //instance


    private ApManager() {};    // private empty constructor

    public static ApManager getInstance() {
        if (apInstance == null) {
            apInstance = new ApManager();
        }
        return apInstance;
    }
    @Override
    public void addAppointment(int patientId, int doctorId, String date, AppointmentType appType) {
        int appointmentID = Utils.nextID(1000000, 9999999);

        try {
            if (appType == AppointmentType.Standard) {
                Standard appointment = new Standard(appointmentID, patientId, doctorId, date, appType);
                appointments.put(appointmentID, appointment);
            } else if (appType == AppointmentType.COVID) {
                COVID appointment = new COVID(appointmentID, patientId, doctorId, date, appType);
                appointments.put(appointmentID, appointment);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Press Enter to Continue...");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }
    }

//    Object firstKey = appointments.keySet().toArray()[0];
//    Object valueForFirstKey = appointments.get(firstKey);
    /**
     * @param appID, date
     *
     * @return check
     *
     * @exception true
     *
     * @throws
     */
    public boolean addDose(int appID, String date){
        boolean check = false;
        if (appointments.get(appID).getCheck()){
        if (Utils.checklength(date, 10, 10)) {
            check = true;
            appointments.get(appID).addInfo(date);
        }}
        return check;
    }
    /**
     * @param appID, caseDescription
     *
     * @return check
     *
     * @exception true
     *
     * @throws
     */
    public boolean addCase(int appID, String caseDescription){
        boolean check = false;
        if (Utils.checklength(caseDescription, 5, 15)) {
            check = true;
            appointments.get(appID).addInfo(caseDescription);
        }
        return check;
    }



    @Override
    public void cancelAppointment(int appointmentId) { appointments.remove(appointmentId); }

    @Override
    public void printAppointments() {
        System.out.println("| ID         | Appointment |");
        for (Appointment appointment : appointments.values()) {
            System.out.println(appointment.toString());
        }
    }

}
