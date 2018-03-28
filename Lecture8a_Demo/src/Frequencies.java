class Frequencies {
  /* The Frequencies Program      by J M Bishop Dec 1996
   * -----------------------      Java 1.1
   *                              updated May 2000
   * Counts the frequencies of scores from 0 to 19.
   * Tested by generating random numbers.
   * Illustrates simple array handling
   */

  Frequencies () {

    int maxscore = 20;
    int scoreFreqs [] = new int [maxscore];
    int score;

    for (int i=0; i < 100; i++) {
        score = (int) (Math.random() * maxscore);
        scoreFreqs[score] ++;
    }

    System.out.println("Table of Score Frequencies\n"+
                       "==========================\n\n"+
                       "  Score  occurred");
    for (int i = 0; i<maxscore; i++) {
      System.out.println(Stream.format(i, 6) +
                         Stream.format(scoreFreqs[i], 6));
    }
  }

  public static void main (String [] args) {
    new Frequencies ();
  }
}
