# Changelog

## 15/04/2016 v1.0 RC2

Well, I threw most of the previous work through the window.

The first thing I have changed is the building system. I confess I am in love with the Ant + Maven mix of the previous version, but, being honest, this is a rather weird approach.

I am using this mix in my daytime job, but I am a bit unconfortable with it. The last version of the Maven Ant Tasks library (2.1.3) was packaged on 05/09/2012, and although is a fairly robust piece of code, is a bit outdated.

Then came Gradle. It's been a while since I started reading about it, with the secret and dirty desire of changing the build scripts in all my projects.

So, here we go. This is my first implementation of a Gradle build script, and it has been a rough one. Gradle is not ready to perform certain tasks out-of-the-box, like packaging two different assemblies depending on the inclusion of debug symbols (to my knowledge, at least).

But, you know, Gradle is, in fact, build upon Groovy. And this makes possible to do a bit of tweaking to get the results you want.

The second thing I changed was the conversion engine. The first version covered numerals from "cero" (0) to "noventa y nueve" (99). The rules needed to recognize these numerals were labeled from `r0` to `r2`, and these were plain rules, with no recursion at all.

However, when I started working on the firs recursive rule, `r4` (`r3` was a simple one, with the numeral "cien", this is, 100), problems arise.

Java does not permit recursive regular expressions, unlike other languages like Perl or C#. This was a major drawback, because I relied on named groups to recognize the sub-patterns from which I could build the numeric equivalents of the numeral expression.

I flirted with the idea of using standard, numbered groups, but imagine a rule like this:

```
r8 = (((r1b | r2a | r3a | r4a | r5a | r6a) WHITESPACES) (millones) ((WHITESPACES) (r1 | r2 | r3 | r4 | r5 | r6))?)
```

This rule, once unfolded, has several dozens of lines, full of parens and repeating numeral strings. I am pretty good at regular expressions, but this is unmanageable, to say the least.

Wandering through StackOverflow, I realized I have been creating a formal grammar to construct numeral expressions in Spanish the whole time. And there is a fantastic tool which is perfect regarding to parser/lexer generation based on formal grammars: [ANTLR](http://www.antlr.org/).

There is a lot to do, though. This version covers numerals from "cero" (0) to "novecientos noventa y nueve" (999), but the treatment of ill-formed numerals is non-existent. That's the next step (and extending the range of accepted numerals also).

## 02/04/2016 v1.0 RC1

This is the first version of the library.

The library covers Spanish numerals from "cero" (0) to "noventa y nueve" (99), and it uses regular expression matching to determine which rules are fired upon a given numeral.

The accepted range uses plain rules, mostly, and just one composite rule, but things are starting to get funny from this point on.

The project is compiled using Ant mixed with [Maven Ant Tasks](http://maven.apache.org/ant-tasks/), combining the low-level power of Ant with the capability to use Maven repositories to download the required dependencies.