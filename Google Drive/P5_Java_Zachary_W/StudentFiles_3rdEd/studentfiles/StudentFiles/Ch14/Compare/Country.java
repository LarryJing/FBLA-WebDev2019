public class Country implements Comparable<Country>
{
  private String name;
  private int population;

  public Country(String nm) { name = nm; population = 0; }
  public Country(String nm, int pop) { name = nm; population = pop; }
  public String getName() { return name; }
  public int getPopulation() { return population; }

  public boolean equals(Object other)
  {
    if (other != null)
      return name.equals(((Country)other).getName());
    else
      return false;
  }

  public int compareTo(Country other)
  {
    return name.compareTo(other.getName());
  }

  public String toString()
  {
    return name + ": " + population;
  }
}
