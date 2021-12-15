package com.ndynmate.muebles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

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
    }
}