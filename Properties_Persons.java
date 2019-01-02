package GUI.PracticeTesting;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Properties_Persons {
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getFirstName() {
        return firstName.get();
    }


    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
