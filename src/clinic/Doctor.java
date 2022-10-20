package clinic;

import tools.Utils;

/**
 * @author Andy
 *
 * @version Lab5
 *
 * @see
 */
public class Doctor extends Person{
    String speciality;

    /**
     *
     * @param fullName  this is the fullname of the doctor
     * @param address
     * @param speciality
     */
    public Doctor(String fullName, String address, String speciality) {
        super(fullName, address);
        this.speciality = speciality;
        super.setId(generateId());
    }

    @Override
    public int generateId() {
        return Utils.nextID(100, 999);
    }


    public String getspeciality() {
        return speciality;
    }

    public void setspeciality(String speciality) {
        this.speciality = speciality;
    }

    public String toString() {
        return "|" + " " + id + "     " +
                "|" + " " + fullName + "  " +
                "|" + " " + address + "  " +
                "|" + " " + speciality + "  " +
                '|';
    }
}

