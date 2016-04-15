# Numeral rules

This is a brief explanation of the rules used in the formal grammars to parse and convert numerals in different languages to their numeric equivalents.

## Spanish mode

Spanish is a bit weird regarding to numerals (not so much as French, however). There are a few quirks along the way you should take into account.

The first rule is `r0`, which covers the numeral "cero" (0). This numeral may only appear alone.

```
r0 = ('cero')
```

The second rule is `r1`, which covers one-word numerals. These numerals range from "uno" (1) to "veintinueve" (29).

```
r1 = ('uno' | 'dos' | ... | 'veintinueve')
```

The third rule, `r2`, is the first compound rule, as it has a prefix (the tens), and an optional group with a connector ("y") and a suffix (the units). These numerals range from "treinta" (0) to "noventa y nueve" (99).

```
r2 = (('treinta' | ... | 'noventa') ((\s+ 'y' \s+) ('uno' | ... | 'nueve'))?)
```

The fourth rule is straightforward, and covers the numeral "cien" (100). This is also a game-over rule.

```
r3 = ('cien')
```

The fourth rule is the first recursive rule in the set. It has a prefix with the numeral "ciento" (which means 100), and a suffix with either rule `r1` or `r2`. From this point on, numerals are always built upon previous rules. This rule ranges from "ciento uno" (101) to "ciento noventa y nueve" (199).

```
r4 = (('ciento') (\s+ (r1 | r2)))
```

The fifth rule is similar to the previous one, replacing the prefix with a set of hundreds. This rule covers numerals from "doscientos" (200) to "novecientos noventa y nueve" (999).

```
r5 = (('doscientos' | ... | 'novecientos') (\s+ (r1 | r2))?)
```