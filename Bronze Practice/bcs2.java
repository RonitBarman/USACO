
// CS90 final class


// Welcome to CS90!

// balancing: due today
// measurement: not collected for HW
// outofplace: due next class


// bcs
// http://www.usaco.org/index.php?page=viewproblem2&cpid=640


/* ANALYSIS


4 3     4x4 grids       3 broken pieces


####          ***#        Original "piece" # 0
#..# - BP#3 = *..#        UL # [0,0]
#.##          *.##       Leftover has UL # [0,3]
....          ....

.#..    ...#       Broken piece #1
.#.. => ...#          move 2 right  (+2 cols)
##..    ..##        UL # [0,1]
....    ....

####      BP #2
##..        [0,0]   shift nowhere and it works!
#..#                     (oops, doesn't match)
####

....    ###.  BP #3
.### => #...        move up 1 and left 1  (-1 and -1)
.#..    #...    UL # [1,1]
.#..    ....


....
##.#     #15
#..#
#.##


brute force:
for every piece out of the 10, that could be the first of two correct pieces ("piece A") - 10
  try all possible shifted locations of chosen piece - 64
    do the shift for 64 cells
    
    try every piece out of 9 remaining, that could be piece B - 9
      try all poss shifted locs for piece B - 64
        do the shift for 64 cells of piece B - 64
        
        check combination of 2 BP grids against OP - 3*64
        
total: 10*64*(64 + 9*64*(64+3*64)) = 94,412,800
    

*/

import java.util.*;
import java.io.*;

public class bcs2 {
  static int n;
  
  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new File("bcs.in"));
    n = in.nextInt();
    // TODO: read in all pieces, including "original piece"
    in.close();

    int[] result = {0,0};
    
    // TODO: pick first and second pieces, check their alignments
    //   and overlaps to see if they account for all #s in original
    
    Arrays.sort(result);
    PrintWriter out = new PrintWriter(new File("bcs.out"));
    // TODO: print results in correct format
    out.close();
  }
  
  // represents an nxn piece
  static class Piece {
    int[][] grid;
    
    // these vars track the min and max row and cols "used" by #s within
    //   this piece, making it easy to determine if a piece can be shifted
    //   by any amount without moving #s out of bounds
    // NOT USED by a "remainder" piece which will never be shifted, except
    //   for minR which is still used to find the "key #" in the remainder
    int maxR = -1, minR = n, maxC = -1, minC = n;
    
    // this tracks the column index of the leftmost # that is on the top
    //   row that contains any #s (minR), which could be called the "key #"
    int ulCol = -1;
    
    // this constructor reads n lines from the scanner, which must have
    //   n characters each, and translates #s to 1s and .s to 0s in a
    //   grid pattern
    Piece(Scanner in) {
      grid = new int[n][n];
      for (int r = 0; r < n; r++) {
        String line = in.next();
        for (int c = 0; c < n; c++) {
          char symbol = line.charAt(c);
          
          if (symbol == '#') {
            grid[r][c] = 1;
            maxR = Math.max(maxR, r);
            minR = Math.min(minR, r);
            maxC = Math.max(maxC, c);
            minC = Math.min(minC, c);
          }
          else {
            grid[r][c] = 0;
          }
        }
      }
      ulCol = findULCol();
    }
    
    // constructor helper function
    //   this finds the column number of the leftmost # in the
    //   uppermost row of this piece's grid, using minR as that row index
    // returns -1 if minR >= n (indicating an empty grid) or
    //   if no # is found in that row (invalid data!)
    int findULCol() {
      if (minR >= n) return -1;
      
      // TODO: return actual position
      
      return -1;
    }
    
    // this constructor creates a "remainder piece" by storing a grid
    //   it locates the key, upperleftmost # but does not find all
    //   mins and maxes since they are not used on the remainder
    Piece(int[][] grid) {
      this.grid = grid;
      
      // finds upperleftmost # 
      boolean found = false;
      for (int r = 0; r < n && !found; r++) {
        for (int c = 0; c < n && !found; c++) {
          if (grid[r][c] == 1) {
            minR = r;
            ulCol = c;
            found = true;
          }
        }
      }
    }
    
    // produces a "remainder" piece by taking this piece and seeing
    //   what would be left over if all the #s/1s in the other piece
    //   were removed
    // returns null if, at any point, a #/1 occurs in the other piece
    //   and there is a ./0 in this piece, since that cell CANNOT have a
    //   # removed!
    Piece without(Piece other) {
      int[][] result = new int[n][n];
      
      // TODO: double loop to visit each cell
      // TODO: subtract to find the correct value (0 representing . or
      //   1 representing #) in each cell, return null if any cell
      //   results in -1
      
      
      // use constructor to "bundle" this into a working piece
      return new Piece(result);
    }
    
    // return true if it is possible to shift this piece by a difference
    //   of dr rows and dc columns (either or both could be negative)
    //   without shifting and #s out of the bounds of the grid
    boolean canShift(int dr, int dc) {
      // TODO: determine if the given shift is possible
      //    hint: use min & max data
      
      return true;
    }

    // change the position of every # in this cell by dr rows and
    //   dc columns. leave 0s representing empty .s in the "new" rows and
    //   cols that "shift into" the grid at the ends
    // also update mins & maxes accordingly
    // because this process would be a mess to try to "undo", canShift
    //   MUST be called before calling this function - it will not handle
    //   shifting #s out of bounds well!
    void doShift(int dr, int dc) {
      // TODO: shift rows
      // TODO: shift cols
      // TODO: update mins, maxes, and ulCol data to account for shift
    }
    
    boolean isEqual(Piece other) {
      return Arrays.deepEquals(this.grid, other.grid);
    }
    
    // returns whether or not this "piece" actually contains any filled
    //   cells
    boolean isEmpty() {
      return minR >= n;
      // minR should be a relatively small number. If it's actually
      //   greater than the maximum possible row index, then there must
      //   not be any #s in this Piece at all.
    }
    
    void printOut() {
      // TODO (optional): complete this for debugging?
      //   note I don't recommend toString since grid has multiple lines
    }
  }
}


