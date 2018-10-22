# Changelog

## 22/10/2018 v1.0RC9

This is a minor release, which includes the creation of a wrapper task in the Gradle build file. Gradle does not need to be installed in the development system anymore.

## 21/10/2018 v1.0RC8

I finally managed to get rid of the fucking `NullPointerException` I had when doing something like this:

```java
System.out.println (converter.convertNumeralToNumber ("five"));
```

The exception apparently came from the `EOF` token I added to the main rule (`numeralExpression`). That built-in token gave coherence to the set of rules, at the cost of the aforementioned exception.

After trying several alternatives, I found a solution, albeit by pure luck, it seems. This was the original method to visit the nodes of the main rule:
```java
public Integer visitNumeralExpression (SpanishNumeralsParser.NumeralExpressionContext ctx) {
    return super.visitNumeralExpression (ctx);
}
```

If I get rid of the terminal node (EOF, in fact), parsing the subtree, everything is fine.

```java
public Integer visitNumeralExpression (SpanishNumeralsParser.NumeralExpressionContext ctx) {
    return super.visit (ctx.children.get (0));
}
```

One more step towards glory!

## 20/10/2018 v1.0RC7

Well, I have added English numerals to the mix, including unit tests. I have also improved the code generation from ANTLR grammars, further smoothing out the handling of parser/lexer files.

However, there are corner cases that I cannot test properly. For example, the string "twenty zero" is valid (!) and yields a result of 20. In fact, the string "twenty motherfuckers" will yield the same result. I suspect that I am not handling whitespaces quite right, so further investigation is required.

## 20/10/2018 v1.0RC6

I have almost ready the remaining grammars (English, French and German), but in doing so, I realized that the Spanish grammar could be rewritten to take advantage of rule reusing, thus getting rid of the `units` ancillary rule.

The grammar file `SpanishGrammar.g4` has been rewritten from scratch, and I have been tinkering with the build script to segregate debug and release tasks. There are a number of issues regarding Gradle/IntelliJ Idea integration, but they are not pretty high in my list of concerns right now.

## 28/09/2018 v1.0RC5

A bit of tidying up, including...

* Removing the `Test` class.
* Adding JUnit dependencies to the Gradle build file.
* Removing the `SpanishNumeralRule` class.
* Reordering the packages.
* Creating packages for the future English, German and French converters.
* Creating a base interface which every converter should stick to.

## 27/09/2018 v1.0RC4

It's been a long time...

Yeah, two and a half years without a single commit. But hey, still alive and kicking.

I have added the long overdue unit tests, so there's no need for a `Test` class. However, the class is still included and mentioned in the `README.md` file, but I'll leave that for the next RC.

I have been thinking about the scope of the library. I intended to create a full-fledged numerals converter in the long scale, but, on second thought, I prefer to release numerals conversion up to 999 in several languages (Spanish, English, French and German) to begin with. So that's the roadmap, for now.

## 17/04/2016 v1.0RC3

Almost done!

The one thing that the previous version lacked of, was proper error handling.

I found this fantastic answer about [handling errors in ANTLR4](http://stackoverflow.com/a/26573239/4491468), and used it, line by line. It worked like a charm, because the idea here was to abort the parsing process as soon as any kind of error arose, either lexical or syntactic.

So, when you try to convert an invalid Spanish numeral, like "noventa y **foo**" or "cuarenta**aaa**", the converter throws an `UnrecognizedNumeralException` which, itself, contains an internal `ParseCancellationException` with information about the point in the numeral expression where the process stopped.

In the road to version 1.0 final, the only thing that remains is expanding the accepted range of Spanish numerals to, say, quintillions (in the [long scale](https://en.wikipedia.org/wiki/Long_and_short_scales)), one release candidate at a time.

## 15/04/2016 v1.0RC2

Well, I threw most of the previous work through the window.

The first thing I have changed is the building system. I confess I am in love with the Ant + Maven mix of the previous version, but, being honest, this is a rather weird approach.

I am using this mix in my daytime job, but I am a bit uncomfortable with it. The last version of the Maven Ant Tasks library (2.1.3) was packaged on 05/09/2012, and although is a fairly robust piece of code, is a bit outdated.

Then came Gradle. It's been a while since I started reading about it, with the secret and dirty desire of changing the build scripts in all my projects.

So, here we go. This is my first implementation of a Gradle build script, and it has been a rough one. Gradle is not ready to perform certain tasks out-of-the-box, like packaging two different assemblies depending on the inclusion of debug symbols (to my knowledge, at least).

But, you know, Gradle is, in fact, built upon Groovy. And this makes possible to do a bit of tweaking to get the results you want.

The second thing I changed was the conversion engine. The first version covered numerals from "cero" (0) to "noventa y nueve" (99). The rules needed to recognize these numerals were labeled from `r0` to `r2`, and these were plain rules, with no recursion at all.

However, when I started working on the firs recursive rule, `r4` (`r3` was a simple one, with the numeral "cien", this is, 100), problems arise.

Java does not permit recursive regular expressions, unlike other languages like Perl or C#. This was a major drawback, because I relied on named groups to recognize the sub-patterns from which I could build the numeric equivalents of the numeral expression.

I flirted with the idea of using standard, numbered groups, but imagine a rule like this:

```
r8: (((r1b | r2a | r3a | r4a | r5a | r6a) WHITESPACES) (millones) ((WHITESPACES) (r1 | r2 | r3 | r4 | r5 | r6))?);
```

This rule, once unfolded, has several dozens of lines, full of parentheses and repeating numeral strings. I am pretty good at regular expressions, but this is unmanageable, to say the least.

Wandering through StackOverflow, I realized I have been creating a formal grammar to construct numeral expressions in Spanish the whole time. And there is a fantastic tool which is perfect regarding to parser/lexer generation based on formal grammars: [ANTLR](http://www.antlr.org/).

There is a lot to do, though. This version covers numerals from "cero" (0) to "novecientos noventa y nueve" (999), but the treatment of ill-formed numerals is non-existent. That's the next step (and extending the range of accepted numerals also).

## 02/04/2016 v1.0RC1

This is the first version of the library.

The library covers Spanish numerals from "cero" (0) to "noventa y nueve" (99), and it uses regular expression matching to determine which rules are fired upon a given numeral.

The accepted range uses plain rules, mostly, and just one composite rule, but things are starting to get funny from this point on.

The project is compiled using Ant mixed with [Maven Ant Tasks](http://maven.apache.org/ant-tasks/), combining the low-level power of Ant with the capability to use Maven repositories to download the required dependencies.