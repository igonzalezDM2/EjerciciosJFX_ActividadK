package application;
	
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import utils.JIKAN;
import utils.Utilidades;


public class Main extends Application {
	
	private final Calendar cal = Calendar.getInstance();
	private BorderPane root;
	//ImageViews de los elementos de hora, minuto, segundo
	private ImageView h1, h2, m1, m2, s1, s2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = new BorderPane();
			dibujarElementos();
			Timer reloxo = new Timer("reloxo");
			reloxo.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					//Cada segundo obtengo la fecha y saco sus números dividiendo entre 10 (cociente y resto)
					cal.setTime(new Date());
					Utilidades.crearNumeroDosDigitos(cal.get(Calendar.HOUR_OF_DAY), h1, h2);
					Utilidades.crearNumeroDosDigitos(cal.get(Calendar.MINUTE), m1, m2);
					Utilidades.crearNumeroDosDigitos(cal.get(Calendar.SECOND), s1, s2);
				}
			}, 0, 1000);
			
			
			//LE PONGO LAS DIMENSIONES DE LA IMAGEN, PORQUE SI NO NO CUADRO EL FONDO NI POR CASUALIDAD...
			Scene scene = new Scene(root,480,412);
			primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/imagenes/reloj.png")));
			primaryStage.setTitle("RELOJ");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Dibuja el reloj en un grid
	 */
	private void dibujarElementos() {
		root.setBackground(Utilidades.getBackground(Utilidades.crearFondo("fondoReloj.png")));
		GridPane gpReloj = new GridPane();
		gpReloj.setAlignment(Pos.CENTER);
		
		HBox hourBox = new HBox();
		GridPane.setRowIndex(hourBox, 0);
		GridPane.setColumnIndex(hourBox, 0);
		h1 = new ImageView(JIKAN.REI.getImage());
		h2 = new ImageView(JIKAN.REI.getImage());
		hourBox.getChildren().addAll(h1, h2);
		
		Label separador = new Label(":");
		separador.setFont(new Font(40));
		separador.setTextFill(Color.RED);
		GridPane.setRowIndex(separador, 0);
		GridPane.setColumnIndex(separador, 1);
		
		HBox minuteBox = new HBox();
		GridPane.setRowIndex(minuteBox, 0);
		GridPane.setColumnIndex(minuteBox, 2);
		m1 = new ImageView(JIKAN.REI.getImage());
		m2 = new ImageView(JIKAN.REI.getImage());
		minuteBox.getChildren().addAll(m1, m2);
		
		Label separador2 = new Label(":");
		separador2.setFont(new Font(40));
		separador2.setTextFill(Color.RED);
		GridPane.setRowIndex(separador2, 0);
		GridPane.setColumnIndex(separador2, 3);
		
		HBox secondBox = new HBox();
		GridPane.setRowIndex(secondBox, 0);
		GridPane.setColumnIndex(secondBox, 4);
		s1 = new ImageView(JIKAN.REI.getImage());
		s2 = new ImageView(JIKAN.REI.getImage());
		secondBox.getChildren().addAll(s1, s2);
		
		gpReloj.getChildren().addAll(hourBox, separador, minuteBox, separador2, secondBox);
		
		
		root.setCenter(gpReloj);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
