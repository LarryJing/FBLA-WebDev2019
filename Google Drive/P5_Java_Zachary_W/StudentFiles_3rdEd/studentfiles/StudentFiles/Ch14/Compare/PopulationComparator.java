// Comparator for Country objects based on population

import java.util.Comparator;

public class PopulationComparator implements Comparator<Country>
{
  private boolean ascending;

  // Constructors
  public PopulationComparator() { ascending = true; }
  public PopulationComparator(boolean ascend) { ascending = ascend; }

  public int compare(Country country1, Country country2)
  {
    int diff = country1.getPopulation() - country2.getPopulation();
    if (ascending)
      return diff;
    else
      return -diff;
  }
}

