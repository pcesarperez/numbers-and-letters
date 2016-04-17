# Numbers and Letters

## What the hell is this?

This is a library to perform conversions between numerals and their numeric equivalents. That's it.

For example:

* "Treinta y tres" should be converted into 33 (Spanish).
* "Thirty-three" should be converted into 33 (English).
* "Trente-trois" should be converted into 33 (French).
* "Drei und dreißig" should be converted into, guess what? That's right, 33 (German).

## Work in progress

This is a highly experimental project, and thus, is not ready for public consumption. Yet.

I am Spanish, so I am building Spanish mode first. The library performs conversion from "cero" (0) to "novecientos noventa y nueve" (999), for now.

But I'm planning for the future. That's what I would like to achieve:

1. Expand the range of accepted Spanish numerals to:
	- Thousands. For example "mil" (1000), "tres mil uno" (3001) or "dos mil cuatrocientos cincuenta y ocho" (2458).
	- Millions, then. You get the idea.
2. Add an English mode, using [short scale](https://en.wikipedia.org/wiki/Long_and_short_scales), up to millions.
3. Add a French mode, using long scale, up to millions.
4. Expand the range of accepted Spanish numerals to weird numbers in the long scale, like "millardos" (10<sup>9</sup>).
5. Expand the range of accepted numerals in the rest of languages, according to their own scale.

## How to build the library

The building system is based on Gradle. Through the `build.gradle` script, two versions of the assembly are created, one with debug symbols and the other without them.

In order to build the library, you just need to navigate to the project folder and run:

```
$ gradle
```

The `.jar` files are placed under the folders `[dist/debug]` and `[dist/release]`.

## How to install the library in your local Maven repository

If you have a local maven repository, you can install the library there, using:

```
$ gradle publishToMavenLocal
```

These are the Maven coordinates of the library, which you can see in the `build.properties` file:

* Group: `com.adastrafork`
* Artifact: `numbers-and-letters`
* Version: 1.0

## How to test the library

I have included a `main ( )` method in a class `Test` to perform quick and dirty tests, although I will include unit tests, eventually (did I already say that this is a work in progress?).

To run the test, just navigate to the project folder and:

```
$ java -cp "dist/debug/numbers-and-letters-1.0.jar:lib/antlr-runtime-4.5.3.jar" com.adastrafork.numbersandletters.es.Test "{spanishNumeral}"
```

Where `{spanishNumeral}` is whatever Spanish numeral you want to convert (for example, "ciento noventa y nueve"), within the [0, 999] range. Don't forget the double quotes!

Note you have to download and place the [ANTLR4 runtime JAR](http://mvnrepository.com/artifact/org.antlr/antlr4-runtime/4.5.3) in any accesible location (folder `[lib]` below the project root folder, in this case).

## How to use the library

To use the library, you just have to import it into your project, either directly or using Maven/Gradle, along with the following dependency:

* Group: `org.antlr`
* Artifact: `antlr4-runtime`
* Version: 4.5.3

Then, you have to instantiate the class `SpanishNumeralsToNumbersConverter`, which has a public method named `convertNumeralToNumber ( )`.

For instance:

```Java
SpanishNumeralsToNumbersConverter numeralsConverter = new SpanishNumeralsToNumbersConverter ( );

try {
	System.out.println (numeralsConverter.convertNumeralToNumber ("novecientos noventa y nueve"));
} catch (UnrecognizedNumeralException e) {
	e.printStackTrace ( );
}
```

When the parser encounters a syntax error, it throws an `UnrecognizedNumeralException` and aborts the parsing process, thus capturing invalid numerals.