package conversion;

import exception.OutOfBoundsException;

import java.util.Scanner;

public class Converter {

    static class Helpers {
        public static double rgbToXyz(double x) {
            if (x >= 0.0405) {
                    x = (x + 0.055) / 1.055;
                    return Math.pow(x, 2.4);
            } else {
                    return x / 12.92;
            }
        }

        public static double xyzToRgb(double x) {
            if (x >= 0.0031308) {
                    x = Math.pow(x, 1.0 / 2.4);
                    return 1.055 * x - 0.055;
            } else {
                    return x * 12.92;
            }
        }

        public static double xyzToLab(double x) {
            if (x >= 0.008856) {
                    return Math.pow(x, 1.0 / 3);
            } else {
                    return 7.787 * x + 16.0 / 116;
            }
        }

        public static double labToXyz(double x) {
            if (Math.pow(x, 3) >= 0.008856) {
                    return Math.pow(x, 3);
            } else {
                    return (x - 16.0 / 116) / 7.787;
            }
        }
    }

    private static Scanner sc = new Scanner(System.in);

    public static XYZ convertRGBtoXYZ(RGB rgb) {
        double rn = Helpers.rgbToXyz(rgb.getR() / 255) * 100;
        double gn = Helpers.rgbToXyz(rgb.getG() / 255) * 100;
        double bn = Helpers.rgbToXyz(rgb.getB() / 255) * 100;

        double x = 0.412453 * rn + 0.357580 * gn + 0.180423 * bn;
        double y = 0.212671 * rn + 0.715160 * gn + 0.072163 * bn;
        double z = 0.019334 * rn + 0.119193 * gn + 0.950227 * bn;

        XYZ xyz = new XYZ(x, y, z);
        return xyz;
    }

    public static RGB convertXYZtoRGB(XYZ xyz) {
        double rn = ( 3.2406 * xyz.getX() - 1.5372 * xyz.getY() - 0.4986 * xyz.getZ()) * 0.01;
        double gn = (-0.9689 * xyz.getX() + 1.8758 * xyz.getY() + 0.0415 * xyz.getZ()) * 0.01;
        double bn = ( 0.0557 * xyz.getX() - 0.2040 * xyz.getY() + 1.0570 * xyz.getZ()) * 0.01;

        double r = Helpers.xyzToRgb(rn) * 255;
        double g = Helpers.xyzToRgb(gn) * 255;
        double b = Helpers.xyzToRgb(bn) * 255;

        RGB rgb = new RGB(r, g, b);
        return rgb;
    }

    public static Lab convertXYZtoLab(XYZ xyz) {
        double L = 116 * Helpers.xyzToLab(xyz.getY() / 100) - 16;
        double a = 500 * (Helpers.xyzToLab(xyz.getX() / 95.047) - Helpers.xyzToLab(xyz.getY() / 100));
        double b = 200 * (Helpers.xyzToLab(xyz.getY() / 100) - Helpers.xyzToLab(xyz.getZ() / 108.883));

        Lab lab = new Lab(L, a, b);
        return lab;
    }

    public static XYZ convertLabToXYZ(Lab lab) {
        double x = Helpers.labToXyz(lab.getA() / 500 + (lab.getL() + 16) / 116) * 95.047;
        double y = Helpers.labToXyz((lab.getL() + 16) / 116) * 100; // ?
        double z = Helpers.labToXyz((lab.getL() + 16) / 116 - lab.getB() / 200) * 108.883;

        XYZ xyz = new XYZ(x, y, z);
        return xyz;
    }
}