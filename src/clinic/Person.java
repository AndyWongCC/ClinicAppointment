package clinic;
/**
 * @author Andy
 *
 * @version Lab5
 *
 * @see
 */
abstract class Person {
    String fullName;
    String address;
    int id;



    public Person(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract int generateId();

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}