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

I am Spanish, so I am building Spanish mode first. The library performs conversion from "cero" (0) to "noventa y nueve" (99), for now.

But I'm planning for the future. That's what I would like to achieve:

1. Expand the range of accepted Spanish numerals to:
	- Hundreds. For example, "cien" (100), "trescientos" (300) or "ochocientos cuarenta y uno" (841).
	- Thousands. For example "mil" (1000), "tres mil uno" (3001) or "dos mil cuatrocientos cincuenta y ocho" (2458).
	- Millions. Well, you get the idea.
2. Add an English mode, using [short scale](https://en.wikipedia.org/wiki/Long_and_short_scales), up to millions.
3. Add a French mode, using long scale, up to millions.
4. Expand the range of accepted Spanish numerals to weird numbers in the long scale, like "millardos" (10<sup>9</sup>).
5. Expand the range of accepted numerals in the rest of languages, according to their own scale.

## How to build the library

I have includes two sets of artifacts to build the project (Ant and Maven), but in fact, I'm using just one: Ant.

Let me explain... I come from the Eclipse world, and I am starting to code in IntelliJ Idea. I have several projects in Eclipse where I keep the dependencies with Maven, using a lightweight POM, but the real building takes place through Ant, using a full-fledged `build.xml` file and the library [`maven-ant-tasks`](https://maven.apache.org/ant-tasks/index.html).

So, in order to build the library, you just need to navigate to the project folder and run:

```
$ ant
```

The building process creates three versions of the library, aimed to three different deployment environments... Anyway, it does not make much sense, so I will stick with two versions, one with debug symbols and no optimizations, and other without debug symbols and optimizations.

The `.jar` files are placed under the folder `[dist\]`, anyway.

On second thought, all of this is a bit messy. I'll do a clean-up in the near future.

## How to install the library in your local Maven repository

If you have a local maven repository, you can install the library there, using:

```
$ ant mvn-install
```

These are the Maven coordinates of the library, which you can see in the `build.properties` file:

* Group: com.adastrafork
* Artifact: numbers-and-letters
* Version: 1.0

## How to test the library

I have included a `main ( )` method in a class `Test` to perform quick and dirty tests, although I will include unit tests, eventually (did I already say that this is a work in progress?).

To run the test, just navigate to the project folder and:

```
$ java -cp dist/DES/numbers-and-letters-1.0.jar com.adastrafork.numbersandletters.es.Test
```

## How to use the library

To use the library, you just have to import it into your project, either directly or using Maven.

Then, you have to instantiate the class `SpanishNumeralsToNumbersConverter`, which has a public method named `convertNumeralToNumber ( )`.

For instance:

```Java
SpanishNumeralsToNumbersConverter numeralsConverter = new SpanishNumeralsToNumbersConverter ( );

try {
    System.out.println (numeralsConverter.convertNumeralToNumber ("noventa y nueve"));
} catch (UnrecognizedNumeralException e) {
    e.printStackTrace ( );
}
```

As you can see, when you try to convert an invalid numeral, the method throws an `UnrecognizedNumeralException`.