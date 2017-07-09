

package mate.dart;

/**
 *
 * @author Panatha
 */


public class ThrowEvent
{
  private String result;
  private boolean allDarts;

  public ThrowEvent(String paramString)
  {
    this(paramString, false);
  }

  public ThrowEvent(String paramString, boolean paramBoolean)
  {
    this.allDarts = paramBoolean;
    if (paramString.contains("x"))
      this.result = paramString;
    else
      this.result = (paramString + "x1");
  }

  public String getResult()
  {
    return this.result;
  }

  public int getNum()
  {
    return Integer.parseInt(this.result.split("x")[0]);
  }

  public int getCount()
  {
    return Integer.parseInt(this.result.split("x")[1]);
  }

  public int getPointsCount()
  {
    return getNum() * getCount();
  }

  public boolean isDouble()
  {
    if (this.allDarts)
      return true;
    String[] arrayOfString = this.result.split("x");
    return Integer.parseInt(arrayOfString[1]) == 2;
  }

  public boolean isAllDarts()
  {
    return this.allDarts;
  }

  public String toString()
  {
    return "Result: " + this.result + ", allInOne: " + this.allDarts;
  }
}

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.ThrowEvent
 * JD-Core Version:    0.6.2
 */