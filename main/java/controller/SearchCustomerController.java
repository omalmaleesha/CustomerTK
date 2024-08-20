package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import model.Customer;
import java.util.List;

public class SearchCustomerController {

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

    private List<Customer> customerList = DBConnection.getInstance().getConnection();

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String searchResult = txtSearch.getText();
        Customer customer = findResult(searchResult);
        setResutls(customer);
    }


    public Customer findResult(String searchText){
        Customer customer = null;
        for (Customer obj : customerList) {
            if (searchText.equals(obj.getId())) {
                customer = obj;
                break;
            }
        }
        return customer;
    }
    public void setResutls(Customer customer){
        txtId.setText(customer.getId());
        txtName.setText(customer.getName());
        txttitle.setValue(customer.getTitle());
        txtAddress.setText(customer.getAddress());
        txtNumber.setText(customer.getNumber());
        txtDOB.setValue(customer.getDob());
    }
    @FXML
    void btnViewOnAction(ActionEvent event) {

    }

}
