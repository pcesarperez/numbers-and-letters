# Numeral rules

This is a brief explanation of the rules used in the formal grammars to parse and convert numerals in different languages to their numeric equivalents.

## Spanish mode

Spanish is a bit weird regarding to numerals (not so much as French, however). There are a few quirks along the way you should take into account.

The first rule is `r0`, which covers the numeral "cero" (0). This numeral may only appear alone.

```
r0 = ('cero');
```

The second rule is `r1`, which covers one-word numerals ranging from from "uno" (1) to "nueve" (9).

```
r1 = ('uno' | 'dos' | ... | 'nueve');
```

The third rule is `r2`, which contains the rest of one-word numerals from "diez" (10) to "veintinueve" (29).

```
r2 = ('diez' | 'once' | ... | 'veintinueve');
```

The fourth rule, `r3`, is the first composite rule, as it has a prefix (the tens), and an optional group with a connector ("y") and a suffix (the rule `r1`, which contains the units). These numerals range from "treinta" (0) to "noventa y nueve" (99).

```
r3 = (tens (WHITESPACES 'y' WHITESPACES r1)?);
tens = ('treinta' | 'cuarenta' | ... | 'noventa');
```

The fifth rule is straightforward, and covers the numeral "cien" (100). This is also a game-over rule, like `r0`.

```
r4 = ('cien')
```

The sixth rule is another composite rule. It has a prefix with the numeral "ciento" (which means 100 although it never may appear alone), and a suffix with rule `r1`, `r2` or `r3`. From this point on, numerals are always built upon previous rules. This rule ranges from "ciento uno" (101) to "ciento noventa y nueve" (199).

```
r5 = ('ciento' WHITESPACES (r1 | r2 | r3));
```

The seventh and last rule is similar to the previous one, replacing the prefix with a set of hundreds. This rule covers numerals from "doscientos" (200) to "novecientos noventa y nueve" (999).

```
r6 = (hundreds (WHITESPACES (r1 | r2 | r3))?);
hundreds = ('doscientos' | 'trescientos' | ... | 'novecientos');
```

## English mode

Not there yet...

## French mode

Not there yet...

## German mode

Not there yet...