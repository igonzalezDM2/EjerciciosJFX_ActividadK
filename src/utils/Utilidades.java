package utils;

import java.util.Arrays;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;

public class Utilidades {
	//CLASE NO INSTANCIABLE
	private Utilidades() {
		throw new UnsupportedOperationException("Clase de utilidad");
	}


	public static BackgroundImage crearFondo(String imagen) {
		return new BackgroundImage(Utilidades.crearImagen(imagen),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(1.0, 1.0, false, false, false, true));
	}
	
	public static void crearNumeroDosDigitos(int numero, ImageView num1, ImageView num2) {
		int n1 = numero / 10;
		int n2 = numero % 10;
		
		num1.setImage(JIKAN.class.getEnumConstants()[n1].getImage());
		num2.setImage(JIKAN.class.getEnumConstants()[n2].getImage());
	}

	public static Image crearImagen(String imagen) {
		return new Image(Utilidades.class.getResourceAsStream("/imagenes/" + imagen));
	}
	
	public static Background getBackground(BackgroundImage... image) {
		return new Background(Arrays.asList(new BackgroundFill(javafx.scene.paint.Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)), Arrays.asList(image));
	}
	
}
