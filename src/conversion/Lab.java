package conversion;

import exception.OutOfBoundsException;

public class Lab {
	private double[] lab = new double[3];

	public static final double[] lowerBounds = { 0.0, -128.0, -128.0 };
	public static final double[] upperBounds = { 100.0, 128.0, 128.0 };

	public Lab(double L, double a, double b) {
            lab[0] = L;
            lab[1] = a;
            lab[2] = b;
	}
        
        public double[] getLab() {
            return lab;
        }

	public double getL() {
            return lab[0];
	}

	public double getA() {
            return lab[1];
	}

	public double getB() {
            return lab[2];
	}

	public void trim() throws OutOfBoundsException {
            Boolean trimmed = false;

            for (int i = 0; i < 3; ++i) {
                    if (lab[i] < lowerBounds[i]) {
                            trimmed = true;
                            lab[i] = lowerBounds[i];
                    } else if (lab[i] > upperBounds[i]) {
                            trimmed = true;
                            lab[i] = upperBounds[i];
                    }
            }

            if (trimmed) {
                    throw new OutOfBoundsException(toString());
            }
	}

	public String toString() {
            return String.format("(%.0f, %.0f, %.0f)", lab[0], lab[1], lab[2]);
	}
}