package se.edument.recap.chat;

/**
 * Created by Tim on 2015-05-23.
 */
public class Participant {
    private String ip;
    private String handle;
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "Participant{" +
                "ip='" + ip + '\'' +
                ", handle='" + handle + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}  // end class Participant
