package clinic;

import appointment.*;
import tools.Utils;

import java.util.ArrayList;
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
public class Clinic {
    private static ArrayList<Patient> patients = new ArrayList<>(); //arraylist for keeping patient data
    private static ArrayList<Doctor> doctors = new ArrayList<>(); //arraylist for keeping doctor data
    private ApManager Ap = ApManager.getInstance(); //appointment manager instance
    private static Clinic clinicInstance = null; //clinic instance

    public Clinic() {}

    public static Clinic getInstance() {
        if (clinicInstance == null) {
            clinicInstance = new Clinic();
        }
        return clinicInstance;
    }


    public static void createPatient() {
        String name, address, caseDesc;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Patient Name: ");
        name = input.nextLine();
        System.out.print("Enter Patient Address: ");
        address = input.nextLine();
        System.out.print("Enter Patient Case: ");
        caseDesc = input.next();
        try {
            Patient patient = new Patient(name, address, caseDesc);
            patients.add(patient);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage()); // gets the message from the exception that is thrown
            System.out.println("Press Enter to Continue...");
            input.nextLine();
            input.nextLine();
        }
    }

    public static void createDoctor() {
        String name, address, specialty;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Doctor Name: ");
        name = input.nextLine();
        System.out.print("Enter Doctor Address: ");
        address = input.nextLine();
        System.out.print("Enter Doctor Specialty: ");
        specialty = input.next();
        try {
            Doctor doctor = new Doctor(name, address, specialty);
            doctors.add(doctor);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage()); // gets the message from the exception that is thrown
            System.out.println("Press Enter to Continue...");
            input.nextLine();
            input.nextLine();
        }
    }

    public static void listPatients() {
        System.out.println("| ID       | Name   | Address   | Case   |");
        System.out.println("-------------------------------------------");
        try {
            for (int i = 0; i < patients.size(); i++) {
                System.out.println(patients.get(i).toString());
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public static void listDoctors(){
        System.out.println("| ID       | Name   | Address   | Speciality   |");
        System.out.println("-------------------------------------------");
        try {
            for (int i = 0; i < doctors.size(); i++) {
                System.out.println(doctors.get(i).toString());
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void createStandard(){
        int patientId, doctorId; String date;
        try {
            Scanner sel = new Scanner(System.in);
            System.out.print("Enter Patient ID: ");
            patientId = Integer.parseInt(sel.nextLine());
            System.out.print("Enter Doctor ID: ");
            doctorId = Integer.parseInt(sel.nextLine());
            System.out.print("Enter appointment date: ");
            date = sel.next();
            Ap.addAppointment(patientId, doctorId, date, AppointmentType.Standard);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println("Press Enter to Continue...");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }
    }

    public void createCOVID(){
        int patientId, doctorId; String date;
        try {
            Scanner sel = new Scanner(System.in);
            System.out.print("Enter Patient ID: ");
            patientId = Integer.parseInt(sel.nextLine());
            System.out.print("Enter Doctor ID: ");
            doctorId = Integer.parseInt(sel.nextLine());
            System.out.print("Enter appointment date: ");
            date = sel.next();
            Ap.addAppointment(patientId, doctorId, date, AppointmentType.COVID);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println("Press Enter to Continue...");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }
    }

    public void cancelAppointment(int appointmentID){
        Ap.cancelAppointment(appointmentID);
    }

    public void printAppointments(){
        Ap.printAppointments();
    }

    /**
     *
     */
    public void cancel(){
        System.out.println("Enter Appointment ID: ");
        Scanner inputID = new Scanner(System.in);
        int appointmentID = Integer.parseInt(inputID.nextLine());
        cancelAppointment(appointmentID);
    }

    public void addDose(){
        int appId;
        String doseDate;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Appointment ID: ");
        try {
            appId = Integer.parseInt(input.nextLine());
            System.out.print("Enter Dose Date: ");
            doseDate = input.next();
            if (!Ap.addDose(appId,doseDate)) {
                System.out.println("Invalid Dose Date");
                System.out.println("Press Enter to Continue...");
                input.nextLine();
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println("Press Enter to Continue...");
            input.nextLine();
        }
    }

    public void addCase(){
        int appId;
        String caseDesc;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Appointment ID: ");
        try {
            appId = Integer.parseInt(input.nextLine());
            System.out.print("Enter Case Description: ");
            caseDesc = input.next();
            if (!Ap.addCase(appId, caseDesc)) {
                System.out.println("Invalid Case Description");
                System.out.println("Press Enter to Continue...");
                input.nextLine();
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println("Press Enter to Continue...");
            input.nextLine();
        }
    }




    public void runClinic() {
        System.out.println("Welcome to FIT2099 Clinic App");
        Scanner input = new Scanner(System.in);
        int selection;
        do {
            selection = tools.MenuInput.menuItem();
            switch (selection) {
                case 1:
                    createPatient();
                    break;
                case 2:
                    createDoctor();
                    break;
                case 3:
                    listPatients();
                    break;
                case 4:
                    listDoctors();
                    break;
                case 5:
                    createCOVID();
                    break;
                case 6:
                    addDose();
                    break;
                case 7:
                    createStandard();
                    break;
                case 8:
                    addCase();
                    break;
                case 9:
                    printAppointments();
                    break;
                case 10:
                    cancel();
                    break;
                case 11:
                    break;
            }
        } while (selection != 11);
        System.out.println("Thank you for visiting FIT2099 Clinic App");
        System.exit(0);
    }
}