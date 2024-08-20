package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateCustomerController implements Initializable {

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private DatePicker txtDOB;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private ChoiceBox<String> txttitle;

    private Customer customerSearched;
    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String searchText = txtSearch.getText();
        SearchCustomerController obj = new SearchCustomerController();
        Customer customer = obj.findResult(searchText);
        customerSearched = customer;
        System.out.println(customer);
        setResults(customer);
    }

    private void setResults(Customer customer) {
        txtId.setText(customer.getId());
        txtName.setText(customer.getName());
        txttitle.setValue(customer.getTitle());
        txtAddress.setText(customer.getAddress());
        txtNumber.setText(customer.getNumber());
        txtDOB.setValue(customer.getDob());
    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {
        customerSearched.setId(txtId.getText());
        customerSearched.setName(txtName.getText());
        customerSearched.setTitle(txttitle.getValue());
        customerSearched.setNumber(txtNumber.getText());
        customerSearched.setAddress(txtAddress.getText());
        customerSearched.setDob(txtDOB.getValue());

        System.out.println(customerSearched);

    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr");
        titles.add("Mrs");
        txttitle.setItems(titles);
    }
}
