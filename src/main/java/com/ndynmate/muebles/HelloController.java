package com.ndynmate.muebles;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;

import java.util.ArrayList;

public class HelloController {
    @FXML
    public Button btnInsertar;
    @FXML
    public TextField txtPrecio;
    @FXML
    public TextField txtMaterial;
    @FXML
    public TextField txtTipo;
    @FXML
    public TextField txtId;
    @FXML
    public Button btnModificar;
    @FXML
    public Button btnEliminar;
    @FXML
    public TableView<Mueble> tblView;
    @FXML
    public TableColumn<Mueble, Integer> tblID;
    @FXML
    public TableColumn<Mueble, String> tblTipo;
    @FXML
    public TableColumn<Mueble, String> tblMaterial;
    @FXML
    public TableColumn<Mueble, Integer> tblPrecio;
    @FXML
    public TextField txtBuscar;
    @FXML
    public Button btnBuscar;

    public void initialize() {
        mostrarMuebles();
    }

    public void mostrarMuebles() {
        ObservableList<Mueble> muebles = tblView.getItems();

        tblID.setCellValueFactory(new PropertyValueFactory<Mueble, Integer>("id"));
        tblTipo.setCellValueFactory(new PropertyValueFactory<Mueble, String>("tipo"));
        tblMaterial.setCellValueFactory(new PropertyValueFactory<Mueble, String>("material"));
        tblPrecio.setCellValueFactory(new PropertyValueFactory<Mueble, Integer>("precio"));

        tblView.setItems(muebles);

        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        ArrayList<Mueble> mueblesList = (ArrayList<Mueble>) s.createQuery("from Mueble").list();
        s.getTransaction().commit();
        s.close();
        muebles.addAll(mueblesList);
    }

    public void onClickInsertar(ActionEvent actionEvent) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        Mueble m = new Mueble();
        m.setTipo(txtTipo.getText());
        m.setMaterial(txtMaterial.getText());
        m.setPrecio(Integer.parseInt(txtPrecio.getText()));
        s.save(m);
        s.getTransaction().commit();
        s.close();
        limpiarCampos();
        mostrarMuebles();
    }

    public void onClickEliminar(ActionEvent actionEvent) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        Mueble m = new Mueble();
        m.setId(Integer.parseInt(txtId.getText()));
        s.delete(m);
        s.getTransaction().commit();
        s.close();
        limpiarCampos();
        mostrarMuebles();
    }

    public void onClickModificar(ActionEvent actionEvent) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        Mueble m = new Mueble();
        m.setId(Integer.parseInt(txtId.getText()));
        m.setTipo(txtTipo.getText());
        m.setMaterial(txtMaterial.getText());
        m.setPrecio(Integer.parseInt(txtPrecio.getText()));
        s.update(m);
        s.getTransaction().commit();
        s.close();
        limpiarCampos();
        mostrarMuebles();
    }

    public void limpiarCampos() {
        txtPrecio.setText("");
        txtMaterial.setText("");
        txtTipo.setText("");
        tblView.getItems().clear();
    }

    public void callBackClickOnTable(javafx.scene.input.MouseEvent mouseEvent) {
        Mueble m = tblView.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(m.getId()));
        txtTipo.setText(m.getTipo());
        txtMaterial.setText(m.getMaterial());
        txtPrecio.setText(String.valueOf(m.getPrecio()));
    }

    public void onClickBuscar(ActionEvent actionEvent) {
        Session s = HibernateUtil.openSession();
        s.beginTransaction();
        ArrayList<Mueble> mueblesList = (ArrayList<Mueble>) s.createQuery(
                "from Mueble where tipo like '%" + txtBuscar.getText() + "%' " +
                        "or material like '%" + txtBuscar.getText() + "%' " +
                        "or precio like '%" + txtBuscar.getText() + "%'").list();
        s.getTransaction().commit();
        s.close();
        txtBuscar.setText("");
        tblView.getItems().clear();
        tblView.getItems().addAll(mueblesList);
    }
}





