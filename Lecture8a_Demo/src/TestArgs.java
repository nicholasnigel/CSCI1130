class TestArgs {
  public static void main(String[] args) {
    System.out.println("There are " + args.length + " arguments:");
    int i;
    for (i = 0; i < args.length; i++)
      System.out.println(args[i]);
  }
}
