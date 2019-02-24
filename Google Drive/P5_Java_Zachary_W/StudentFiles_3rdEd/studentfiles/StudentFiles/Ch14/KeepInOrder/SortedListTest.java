public class SortedListTest
{
  public static void main(String[] args)
  {
    SortedWordList names1 = new SortedWordList(12);
    names1.add("Barb");
    names1.add("Ellen");
    names1.add("Dan");
    names1.add(1, "Connie");
    names1.add(0, "Aaron");
//  names1.add(1, "Aaron");
    names1.add(5, "Frank");
    System.out.println("names1 = " + names1);

    System.out.println("set(0, \"Amy\") (was " + names1.set(0, "Amy") + ")");
//  System.out.println("set(2, \"Ellen\") (was " + names1.set(2, "Ellen") + ")");
    System.out.println("set(4, \"Ellen\" (was " + names1.set(4, "Ellen") + ")");
    System.out.println("set(4, \"Evan\") (was " + names1.set(4, "Evan") + ")");
    System.out.println("names1 = " + names1);

    System.out.println("contains(\"Amy\") = " + names1.contains("amy") +
          " indexOf(\"Amy\") = " + names1.indexOf("amy"));
    System.out.println("contains(\"Ben\") = " + names1.contains("ben") +
          " indexOf(\"Ben\") = " + names1.indexOf("ben"));
    System.out.println("contains(\"Dan\") = " + names1.contains("dan") +
          " indexOf(\"Dan\") = " + names1.indexOf("dan"));


    SortedWordList names2 = new SortedWordList();
    names2.add("Aaron");
    names2.add("Claire");
    names2.add("Fiona");
    names2.add("Gina");
    names2.add("Ben");
    names2.add("Debby");
    names2.add("Eve");
    names2.add("Aaron");
    names2.add("Claire");
    names2.add("Gina");
    names2.add("Amy");
    names2.add("Frank");
    names2.add("Connie");

    System.out.println("names2 = " + names2);
  }
}
