package conversion;

import exception.OutOfBoundsException;
import javafx.scene.paint.Color;

public class RGB {
	private double[] rgb = new double[3];

	public static final double[] lowerBounds = { 0.0, 0.0, 0.0 };
	public static final double[] upperBounds = { 255.0, 255.0, 255.0 };

	public RGB(double r, double g, double b) {
            rgb[0] = r;
            rgb[1] = g;
            rgb[2] = b;
	}
        
        public RGB(Color color) {
            rgb[0] = 255 * color.getRed();
            rgb[1] = 255 * color.getGreen();
            rgb[2] = 255 * color.getBlue();
        }
        
        public double[] getRgb() {
            return rgb;
        }

	public double getR() {
            return rgb[0];
	}

	public double getG() {
            return rgb[1];
	}

	public double getB() {
            return rgb[2];
	}

	public void trim() throws OutOfBoundsException {
            Boolean trimmed = false;

            for (int i = 0; i < 3; ++i) {
                    if (rgb[i] < lowerBounds[i]) {
                            trimmed = true;
                            rgb[i] = lowerBounds[i];
                    } else if (rgb[i] > upperBounds[i]) {
                            trimmed = true;
                            rgb[i] = upperBounds[i];
                    }
            }

            if (trimmed) {
                    throw new OutOfBoundsException(toString());
            }
	}

	public String toString() {
            return String.format("(%.0f, %.0f, %.0f)", rgb[0], rgb[1], rgb[2]);
	}
}