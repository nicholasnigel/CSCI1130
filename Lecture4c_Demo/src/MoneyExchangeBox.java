class MoneyExchangeBox
{
  static double toHKdollar(double USdollar)
  {
    return USdollar * 7.80;
  }

  // your exercise
  // finish a version of box(int width, int height)

  static void box()
  {
    System.out.println("-----------------");
    System.out.println("|               |");
    System.out.println("| US$" + 1 + " = HK$" + toHKdollar(1) + " |");
    System.out.println("|               |");
    System.out.println("-----------------");
  }

  public static void main(String[] args)
  {
    box();
    System.out.println("US$" + 5 + " = HK$" + toHKdollar(5));
  }
}
