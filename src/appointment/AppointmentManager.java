package appointment;

public interface AppointmentManager {
    void addAppointment(int patientId,int doctorId,String date, AppointmentType appType);
    void cancelAppointment(int appointmentId);
    void printAppointments();
}

