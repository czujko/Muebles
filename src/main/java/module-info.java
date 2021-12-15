module com.ndynmate.muebles {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires java.persistence;

    opens com.ndynmate.muebles to javafx.fxml;
    exports com.ndynmate.muebles;
}