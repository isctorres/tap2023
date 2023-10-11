package com.example.tap2023.components;

import com.example.tap2023.modelos.CategoriasDAO;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

public class ButtonCell extends TableCell<CategoriasDAO,String> {
    private Button btnCelda;
    public ButtonCell(){
        btnCelda = new Button("Editar");
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty ){
            this.setGraphic(btnCelda);
        }
    }
}
