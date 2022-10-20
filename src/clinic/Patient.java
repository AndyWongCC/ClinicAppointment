package clinic;

import tools.Utils;
/**
 * @author Andy
 *
 * @version Lab5
 *
 * @see
 */
public class Patient extends Person{
    String caseDescription;

    public Patient(String fullName, String address, String caseDescription) {
        super(fullName, address);
        this.caseDescription = caseDescription;
        super.setId(generateId());
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    @Override
    public int generateId() {
        return Utils.nextID(100000, 9999999);
    }

    @Override
    public String toString() {
        return "|" + " " + id + "  " +
                "|" + " " + fullName + "  " +
                "|" + " " + address + "  " +
                "|" + " " + caseDescription + "  " +
                '|';
    }
}