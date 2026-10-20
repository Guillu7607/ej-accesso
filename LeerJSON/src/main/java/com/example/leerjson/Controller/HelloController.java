package com.example.leerjson.Controller;

import com.example.leerjson.Model.Pelicula;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private Button bttimp;

    @FXML
    private ListView<Pelicula> listpel;

    @FXML
    private TextField txtdir;

    @FXML
    private TextField txtfec;

    @FXML
    private TextField txtgen;

    @FXML
    private TextField txttit;

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    @FXML
    void onClick(ActionEvent event) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/com/example/leerjson/peliculas.json");
        ArrayList<Pelicula> peliculas =
                JSON_MAPPER.readValue(inputStream,
                        JSON_MAPPER.getTypeFactory().constructCollectionType
                                (ArrayList.class, Pelicula.class));
        ObservableList<Pelicula> peliculas1 = FXCollections.observableArrayList(peliculas);
        listpel.setItems(peliculas1);
        Pelicula pel = new Pelicula(peliculas.size()+1 ,txttit.getText(), txtgen.getText(), txtfec.getText(), txtdir.getText());
        peliculas.add(pel);
        peliculas1.add(pel);
        FileWriter file = new FileWriter("peliculas.json");
        JSON_MAPPER.writeValue(file, peliculas);
    }


}
