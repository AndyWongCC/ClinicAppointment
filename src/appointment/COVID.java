package appointment;



import java.util.ArrayList;

/**
 * @author Andy
 *
 * @version Lab5
 *
 * @see
 */
public class COVID extends Appointment {
    private ArrayList<String> Doses = new ArrayList<>(); //Dose of Covid appointment

    public COVID(int appointmentID, int patientId, int doctorId, String date, AppointmentType appType) throws Exception {
        super(appointmentID, patientId, doctorId, date, appType);
    }

    @Override
    public String getInfo(){
        String dosesDates = "";
        for (String doses : Doses) {
            dosesDates += doses + ", ";
        }
        return dosesDates;
    }

    @Override
    public void addInfo(String info) {
        Doses.add(info);
    }

    @Override
    public boolean getCheck() {
        boolean flag = false;
        if(Doses.size() <= 4){
            flag = true;
        }
        return flag;
    }

    @Override
    public String toString(){
        return "|" + super.appointmentID + " | " + "doses= " + getInfo() + "|";
    }

}
