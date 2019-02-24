import java.util.Calendar;
import java.util.GregorianCalendar;

/*
  Written as part of

  Java Methods A & AB: Object-Oriented Programming and Data Structures
  by Maria Litvin and Gary Litvin
  Skylight Publishing 2006, ISBN 0-9727055-7-0.

  EasyDate provides a simple representation of a date with month, day, year
  fields.  EasyDate objects are immutable.

  Example:
  =======

    EasyDate today = new EasyDate();
    System.out.println("Today is " + today);
  
    EasyDate tomorrow = today.add(1);
    EasyDate yesterday = today.add(-1);
  
    int yr = today.getYear();
    System.out.println(yr + " is a leap year? This is " +
                                     EasyDate.isLeapYear(yr));
  
    EasyDate myBirthday = new EasyDate(bDayMonth, bDayDay, yr); 
  
    if (today.equals(myBirthday))
      System.out.println("Today is my birthday");
    else if (yesterday.equals(myBirthday))
      System.out.println("My birthday was yesterday");
    else
    {
      if (myBirthday.compareTo(today) < 0)
        myBirthday = new EasyDate(bDayMonth, bDayDay, yr + 1);
      System.out.println(today.daysTo(myBirthday) +
                     " days are left until my next birthday");
    }
*/

public class EasyDate implements Comparable<EasyDate>
{
  private int month;
  private int day;
  private int year;

  //  Number of milliseconds in 24 hours:
  public static final long MILLIS_DAY = 24L * 3600 * 1000;

  // Returns true if year is a leap year; otherwise returns false.
  // Precondition: 1600 <= year <= 2100
  public static boolean isLeapYear(int year)
  {
    return (new GregorianCalendar()).isLeapYear(year);
  }

  // Constructs an EasyDate with month, day, and year values
  // for the current date.
  public EasyDate()
  {
    Calendar calendar = new GregorianCalendar();
    month = calendar.get(Calendar.MONTH) + 1;
    day = calendar.get(Calendar.DATE);
    year = calendar.get(Calendar.YEAR);
  }

  // Constructs an EasyDate with month, day, and year equal to
  // given values.
  public EasyDate(int month, int day, int year)
  {
    this.month = month;
    this.day = day;
    this.year = year;
  }

  // Constructs an EasyDate equal to other.
  public EasyDate(EasyDate other)
  {
    this.month = other.getMonth();
    this.day = other.getDay();
    this.year = other.getYear();
  }

  // Returns the month of this EasyDate ( 1 - 12)
  public int getMonth()
  {
    return month;
  }

  // Returns the day of this EasyDate
  public int getDay()
  {
    return day;
  }

  // Returns the year of this EasyDate
  public int getYear()
  {
    return year;
  }

  // Returns a new EasyDate that is numDays later
  // (or, if numDays is negative, earlier) than this.
  public EasyDate add(int numDays)
  {
    Calendar calendar = new GregorianCalendar(year, month - 1, day);    
    calendar.add(Calendar.DATE, numDays);
    return new EasyDate(calendar.get(Calendar.MONTH) + 1,
             calendar.get(Calendar.DATE), calendar.get(Calendar.YEAR));
  }

  // Returns the number of days from this date to other.
  public int daysTo(EasyDate other)
  {
    Calendar calendar = new GregorianCalendar(other.getYear(),
                                        other.getMonth() - 1, other.getDay());
    long ms = calendar.getTimeInMillis();
    calendar = new GregorianCalendar(year, month - 1, day);
    ms -= calendar.getTimeInMillis();
    return (int)(Math.round((double)ms / MILLIS_DAY));
  }

  // Returns true if obj represents the same date as this, false otherwise
  public boolean equals(Object obj)
  {
    if (obj == null)
      return false;
    EasyDate other = (EasyDate)obj;
    return month == other.getMonth() && day == other.getDay() && year == other.getYear();
  }

  // Returns the number of days from other to this.
  public int compareTo(EasyDate other)
  {
    return other.daysTo(this);
  }


  // Returns this date as a string in the mm/dd/yyyy format
  public String toString()
  {
    return String.format("%02d/%02d/%02d", month, day, year);
  }
}
