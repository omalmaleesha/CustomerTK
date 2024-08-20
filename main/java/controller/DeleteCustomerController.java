package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.util.List;

public class DeleteCustomerController {

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

    private Customer customerSearched =  null;
    private List<Customer> customerList = DBConnection.getInstance().getConnection();
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        customerList.remove(customerSearched);
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtDOB.setValue(null);
        txttitle.setValue(null);
        txtNumber.clear();
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
    void btnSearchOnAction(ActionEvent event) {
        String searchText = txtSearch.getText();
        SearchCustomerController obj = new SearchCustomerController();
        Customer customer = obj.findResult(searchText);
        customerSearched = customer;
        System.out.println(customer);
        setResults(customer);
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {

    }

}
