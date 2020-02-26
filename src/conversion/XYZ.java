package conversion;

import exception.OutOfBoundsException;

public class XYZ {
	private double[] xyz = new double[3];

	public static final double[] lowerBounds = { 0.0, 0.0, 0.0 };
	public static final double[] upperBounds = { 95.047, 100.0, 108.883 };

	public XYZ(double x, double y, double z) {
            xyz[0] = x;
            xyz[1] = y;
            xyz[2] = z;
	}
        
        public double[] getXyz() {
            return xyz;
        }

	public double getX() {
            return xyz[0];
	}

	public double getY() {
            return xyz[1];
	}

	public double getZ() {
            return xyz[2];
	}

	public void trim() throws OutOfBoundsException {
            Boolean trimmed = false;

            for (int i = 0; i < 3; ++i) {
                    if (xyz[i] < lowerBounds[i]) {
                            trimmed = true;
                            xyz[i] = lowerBounds[i];
                    } else if (xyz[i] > upperBounds[i]) {
                            trimmed = true;
                            xyz[i] = upperBounds[i];
                    }
            }

            if (trimmed) {
                    throw new OutOfBoundsException(toString());
            }
	}

	public String toString() {
            return String.format("(%.0f, %.0f, %.0f)", xyz[0], xyz[1], xyz[2]);
	}
}