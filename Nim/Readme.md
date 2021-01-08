The game of Nim, in which the computer plays agains a human opponent.  Players alternately take marbles from a pile.  In each move, a player chooses the number of marbles to take.  The player must take at least one but at most half of the marbles.  The other player's turn follows.  The player who takes the last marble loses.

The logistics:
- The program generates a random int in range 0 - 100 inclusive, to denote the initial size of the pile.
- A random int in range 0-1 is generated to decide if the human or the computer takes the first turn.
- A random int in range 0-1 is generated to decide if the computer plays in the smart or the stupid mode.
- In stupid mode, the computer takes a random legal value of marbles (range 1 - n/2) whenever its turn comes.
- In smart mode the computer takes off enough marbles to make the size of the pile a power or 2 minus 1 (i.e. 3, 7, 15, 31, or 63), which is always a legal move, except at times when the size of the pile is one less than a power of 2.  If that's the case, the computer will make a random legal move.

Caveats:
- The computer won't be beaten in smart mode if it moves first, unless the initial size of the pile is 15, 31, or 63.