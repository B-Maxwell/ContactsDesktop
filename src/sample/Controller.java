package sample;
import javafx.scene.control.Alert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField email;

    @FXML
    TextField phone;

    public void addItem(){
        if (!name.getText().isEmpty() && !email.getText().isEmpty() && !phone.getText().isEmpty()) {
            Contact contact = new Contact(name.getText(),phone.getText(),email.getText());
            contacts.add(contact);
            name.setText("");
            phone.setText("");
            email.setText("");

        } else {
        //Display Alert Message informing user to complete all fields
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Contact information not added!");
        alert.setContentText("Please complete all fields");
        alert.showAndWait();
        }

    }

    public void removeItem(){
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);

    }



}
