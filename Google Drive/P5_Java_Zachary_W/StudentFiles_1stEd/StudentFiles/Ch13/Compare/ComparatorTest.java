import java.util.Arrays;

public class ComparatorTest
{
  public static void main(String[] args)
  {
    Country[] countries =
      { // population is in millions
        new Country("China", 1321),
        new Country("India", 1110),
        new Country("USA", 301),
        new Country("Indonesia", 249),
        new Country("Brazil", 190),
      };

    // Sort by name:
    Arrays.sort(countries);
    System.out.println(Arrays.toString(countries));

    // Sort by population ascending:
    Arrays.sort(countries, new PopulationComparator(true));
    System.out.println(Arrays.toString(countries));

    // Sort by population descending:
    Arrays.sort(countries, new PopulationComparator(false));
    System.out.println(Arrays.toString(countries));
  }
}
