package utils;

import javafx.scene.image.Image;

/**
 * ENUMERADO CON LAS HORAS ORDENADAS
 */
public enum JIKAN {
	REI(Utilidades.crearImagen("ZERO.png")),
	ICHI(Utilidades.crearImagen("ONE.png")),
	NI(Utilidades.crearImagen("TWO.png")),
	SAN(Utilidades.crearImagen("THREE.png")),
	SHI(Utilidades.crearImagen("FOUR.png")),
	GO(Utilidades.crearImagen("FIVE.png")),
	ROKU(Utilidades.crearImagen("SIX.png")),
	SHICHI(Utilidades.crearImagen("SEVEN.png")),
	HACHI(Utilidades.crearImagen("EIGHT.png")),
	KYUU(Utilidades.crearImagen("NINE.png")),
	;
	
	private Image img;
	private JIKAN(Image imeeji) {
		this.img = imeeji;
	}
	public Image getImage() {
		return img;
	}
}
