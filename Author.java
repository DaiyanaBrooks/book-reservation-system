
public class Author {
    //declaring public and private variables
    private String firstName;
    private String lastName;

    public Author() {
        this.firstName = "";
        this.lastName = "";
    }
    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //getters and setters
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

    public String toString(){

        return firstName + " " + lastName;

    }
}
