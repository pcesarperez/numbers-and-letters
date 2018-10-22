# Numbers and Letters 1.0RC9

## What the hell is this?

This is a library to perform conversions between numerals and their numeric equivalents. That's it.

For example:

* "Treinta y tres" should be converted into 33 (Spanish).
* "Thirty-three" should be converted into 33 (English).
* "Trente-trois" should be converted into 33 (French).
* "Drei und dreißig" should be converted into, guess what? That's right, 33 (German).

## Work in progress

This is a highly experimental project, and thus, is not ready for public consumption. Yet.

The library performs the following conversions, for now:

* **Spanish**: from "cero" (0) to "novecientos noventa y nueve" (999).
* **English**: from "zero" (0) to "nine hundred and ninety-nine" (999).

However, I'm planning for the future. That's what I would like to achieve:

1. Expand the range of accepted Spanish numerals to:
    - Thousands. For example "mil" (1000), "tres mil uno" (3001) or "dos mil cuatrocientos cincuenta y ocho" (2458).
    - Millions, then. You get the idea.
2. Add an English mode, using [short scale](https://en.wikipedia.org/wiki/Long_and_short_scales), up to millions.
3. Add a French mode, using long scale, up to millions.
4. Add a German mode, using long scale, up to millions.
4. Expand the range of accepted Spanish numerals to weird numbers in the long scale, like "millardos" (10<sup>9</sup>).
5. Expand the range of accepted numerals in the rest of languages, according to their own scale.

## How to build the library

The building system is based on Gradle. Through the `build.gradle` script, two versions of the assembly are created, one with debug symbols and the other without them.

In order to build the library, you just need to navigate to the project folder and run:

```bash
$ gradle
```

The `.jar` files are placed under the folders `[dist/debug]` and `[dist/release]`.

## How to install the library in your local Maven repository

If you have a local maven repository, you can install the library there, using:

```bash
$ gradle publishToMavenLocal
```

These are the Maven coordinates of the library, which you can see in the `build.properties` file:

* Group: `com.adastrafork`
* Artifact: `numbers-and-letters`
* Version: 1.0RC9

## How to use the library

To use the library, you just have to import it into your project, either directly or using Maven/Gradle, along with the following dependency:

* Group: `org.antlr`
* Artifact: `antlr4-runtime`
* Version: 4.5.3

Then, you have to create an instance of the corresponding converter class, which has a public method named `convertNumeralToNumber ( )`.

When the parser encounters a syntax error, it throws an `UnrecognizedNumeralException` and aborts the parsing process, thus capturing invalid numerals.

### Spanish numerals converter

```java
SpanishNumeralsToNumbersConverter numeralsConverter = new SpanishNumeralsToNumbersConverter ( );

try {
    System.out.println (numeralsConverter.convertNumeralToNumber ("novecientos noventa y nueve"));
} catch (UnrecognizedNumeralException e) {
    e.printStackTrace ( );
}
```

### English numerals converter

```java
EnglishNumeralsToNumbersConverter numeralsConverter = new EnglishNumeralsToNumbersConverter ( );

try {
    System.out.println (numeralsConverter.convertNumeralToNumber ("nine hundred and ninety-nine"));
} catch (UnrecognizedNumeralException e) {
    e.printStackTrace ( );
}
```