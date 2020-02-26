# Color Converter
In this repo you can find sources for a simple JavaFX app that converts colors between RGB, XYZ, and Lab.

## Structure
- [ConverterApp](src/ui/ConverterApp.java) is the main class of this app. It creates the user interface and handles user input.
  - [controlStyle.css](src/ui/controlStyle.css) stores custom styles for JavaFX controls.
- [Converter](src/conversion/Converter.java) is the class that handles conversion between formats.
- [RGB](src/conversion/RGB.java), [XYZ](src/conversion/XYZ.java), and [Lab](src/conversion/Lab.java) are classes for storing colors.
- [OutOfBoundsException](src/exception/OutOfBoundsException.java) is an exception that occurs when a color is not representable in some format.
