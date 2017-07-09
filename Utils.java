

package mate.dart.utils;

/**
 *
 * @author Panatha
 */


import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

public class Utils
{
  private static final Map<String, String[]> mapCheckout = new HashMap();

  public static Font getBigFont()
  {
    return new Font("Helvetica", 1, 64);
  }

  public static Font getNormalFont()
  {
    return new Font("Helvetica", 1, 32);
  }

  public static Font getSmallFont()
  {
    return new Font("Helvetica", 1, 16);
  }

  public static String[] getCheckout(String paramString)
  {
    return (String[])mapCheckout.get(paramString);
  }

  static
  {
    mapCheckout.put("170", new String[] { "T20 + T20 + BULL" });
    mapCheckout.put("169", null);
    mapCheckout.put("168", null);
    mapCheckout.put("167", new String[] { "T20 + T19 + BULL" });
    mapCheckout.put("166", null);
    mapCheckout.put("165", null);
    mapCheckout.put("164", new String[] { "T20 + T18 + BULL", "T19 + T19 + BULL" });
    mapCheckout.put("163", null);
    mapCheckout.put("162", null);
    mapCheckout.put("161", new String[] { "T20 + T17 + BULL" });
    mapCheckout.put("160", new String[] { "T20 + T20 + D20" });
    mapCheckout.put("159", null);
    mapCheckout.put("158", new String[] { "T20 + T20 + D19" });
    mapCheckout.put("157", new String[] { "T20 + T19 + D20" });
    mapCheckout.put("156", new String[] { "T20 + T20 + D18" });
    mapCheckout.put("155", new String[] { "T20 + T19 + D19" });
    mapCheckout.put("154", new String[] { "T20 + T18 + D20" });
    mapCheckout.put("153", new String[] { "T20 + T19 + D18" });
    mapCheckout.put("152", new String[] { "T20 + T20 + D16" });
    mapCheckout.put("151", new String[] { "T20 + T17 + D20" });
    mapCheckout.put("150", new String[] { "T20 + T18 + D18", "T20 + T20 + D15" });
    mapCheckout.put("149", new String[] { "T20 + T19 + D16" });
    mapCheckout.put("148", new String[] { "T20 + T20 + D14" });
    mapCheckout.put("147", new String[] { "T20 + T17 + D18" });
    mapCheckout.put("146", new String[] { "T20 + T18 + D16" });
    mapCheckout.put("145", new String[] { "T20 + T15 + D20", "T20 + T20 + T12" });
    mapCheckout.put("144", new String[] { "T20 + T20 + D12" });
    mapCheckout.put("143", new String[] { "T20 + T17 + D16" });
    mapCheckout.put("142", new String[] { "T20 + T14 + D20", "T20 + BULL + D16" });
    mapCheckout.put("141", new String[] { "T20 + T15 + D18", "T20 + T19 + D12" });
    mapCheckout.put("140", new String[] { "T20 + T16 + D16", "T20 + T20 + D10" });
    mapCheckout.put("139", new String[] { "T20 + T13 + D20", "T20 + T19 + D11" });
    mapCheckout.put("138", new String[] { "T20 + T16 + D15", "T20 + T18 + D12" });
    mapCheckout.put("137", new String[] { "T18 + T17 + D16", "T20 + T20 + D8" });
    mapCheckout.put("136", new String[] { "T20 + T20 + D8" });
    mapCheckout.put("135", new String[] { "T20 + T13 + D18", "T20 + 25 + BULL" });
    mapCheckout.put("134", new String[] { "T20 + T14 + D16" });
    mapCheckout.put("133", new String[] { "T20 + T19 + D8" });
    mapCheckout.put("132", new String[] { "T20 + T16 + D12", "T19 + 25 + BULL" });
    mapCheckout.put("131", new String[] { "T20 + T13 + D16" });
    mapCheckout.put("130", new String[] { "T20 + T18 + D8", "T20 + 20 + BULL" });
    mapCheckout.put("129", new String[] { "T19 + T16 + D12", "T20 + T19 + D6" });
    mapCheckout.put("128", new String[] { "T20 + T20 + D4", "T18 + T18 + D10" });
    mapCheckout.put("127", new String[] { "T20 + T17 + D8" });
    mapCheckout.put("126", new String[] { "T19 + 19 + BULL", "T19 + T19 + D6" });
    mapCheckout.put("125", new String[] { "T20 + T19 + D4", "BULL + 25 + BULL" });
    mapCheckout.put("124", new String[] { "T20 + T16 + D8", "T20 + 14 + BULL" });
    mapCheckout.put("123", new String[] { "T20 + T13 + D12", "T19 + 16 + BULL" });
    mapCheckout.put("122", new String[] { "T18 + 18 + BULL" });
    mapCheckout.put("121", new String[] { "T19 + 14 + BULL", "T18 + T17 + D8" });
    mapCheckout.put("120", new String[] { "T20 + 20 + D20" });
    mapCheckout.put("119", new String[] { "T20 + 19 + D20", "T19 + T12 + D13" });
    mapCheckout.put("118", new String[] { "T20 + 18 + D20" });
    mapCheckout.put("117", new String[] { "T20 + 17 + D20" });
    mapCheckout.put("116", new String[] { "T20 + 16 + D20" });
    mapCheckout.put("115", new String[] { "T20 + 15 + D20", "T19 + 18 + D20" });
    mapCheckout.put("114", new String[] { "T20 + 14 + D20" });
    mapCheckout.put("113", new String[] { "T20 + 13 + D20", "T19 + 16 + D20" });
    mapCheckout.put("112", new String[] { "T20 + 12 + D20", "T20 + 20 + D16" });
    mapCheckout.put("111", new String[] { "T20 + 19 + D16", "T19 + 14 + D20" });
    mapCheckout.put("110", new String[] { "T20 + 10 + D20", "T18 + 16 + D20" });
    mapCheckout.put("109", new String[] { "T19 + 12 + D20", "T20 + 17 + D16" });
    mapCheckout.put("108", new String[] { "T20 + 16 + D16" });
    mapCheckout.put("107", new String[] { "T19 + 10 + D20", "T20 + 15 + D16" });
    mapCheckout.put("106", new String[] { "T20 + 10 + D18" });
    mapCheckout.put("105", new String[] { "T20 + 13 + D16", "T19 + 16 + D16" });
    mapCheckout.put("104", new String[] { "T20 + 12 + D16" });
    mapCheckout.put("103", new String[] { "T19 + 10 + D18", "T20 + 11 + D16" });
    mapCheckout.put("102", new String[] { "T20 + 10 + D16" });
    mapCheckout.put("101", new String[] { "T17 + 10 + D20", "T19 + 12 + D16" });
    mapCheckout.put("100", new String[] { "T20 + D20" });
    mapCheckout.put("99", new String[] { "D19 + 10 + D16" });
    mapCheckout.put("98", new String[] { "T20 + D19", "T18 + 12 + D16" });
    mapCheckout.put("97", new String[] { "T19 + D20" });
    mapCheckout.put("96", new String[] { "T20 + D18" });
    mapCheckout.put("95", new String[] { "T19 + D19", "T20 + 3 + D16" });
    mapCheckout.put("94", new String[] { "T18 + D20" });
    mapCheckout.put("93", new String[] { "T19 + D18" });
    mapCheckout.put("92", new String[] { "T20 + D16" });
    mapCheckout.put("91", new String[] { "T17 + D20" });
    mapCheckout.put("90", new String[] { "T20 + D15", "T18 + D18" });
    mapCheckout.put("89", new String[] { "T19 + D16" });
    mapCheckout.put("88", new String[] { "T20 + D14", "T16 + D20" });
    mapCheckout.put("87", new String[] { "T17 + D18" });
    mapCheckout.put("86", new String[] { "T18 + D16" });
    mapCheckout.put("85", new String[] { "T19 + D14", "T15 + D20" });
    mapCheckout.put("84", new String[] { "T20 + D12", "T16 + D18" });
    mapCheckout.put("83", new String[] { "T17 + D16" });
    mapCheckout.put("82", new String[] { "BULL + D16", "T14 + D20" });
    mapCheckout.put("81", new String[] { "T15 + D18" });
    mapCheckout.put("80", new String[] { "T16 + D16" });
    mapCheckout.put("79", new String[] { "T19 + D11", "T13 + D20" });
    mapCheckout.put("78", new String[] { "T18 + D12" });
    mapCheckout.put("77", new String[] { "T15 + D12" });
    mapCheckout.put("76", new String[] { "T20 + D8" });
    mapCheckout.put("75", new String[] { "T17 + D12", "T13 + D18" });
    mapCheckout.put("74", new String[] { "T14 + D16" });
    mapCheckout.put("73", new String[] { "T19 + D8" });
    mapCheckout.put("72", new String[] { "T20 + D6", "T16 + D12" });
    mapCheckout.put("71", new String[] { "T13 + D16" });
    mapCheckout.put("70", new String[] { "T18 + D8" });
    mapCheckout.put("69", new String[] { "T11 + D18", "19 + BULL" });
    mapCheckout.put("68", new String[] { "T20 + D4" });
    mapCheckout.put("67", new String[] { "T17 + D8" });
    mapCheckout.put("66", new String[] { "BULL + D8", "T10 + D18" });
    mapCheckout.put("65", new String[] { "25 + D20", "T19 + D4" });
    mapCheckout.put("64", new String[] { "T16 + D8" });
    mapCheckout.put("63", new String[] { "T17 + D6", "T13 + D12" });
    mapCheckout.put("62", new String[] { "T10 + D16" });
    mapCheckout.put("61", new String[] { "T15 + D8" });
    mapCheckout.put("60", new String[] { "20 + D20" });
    mapCheckout.put("59", new String[] { "19 + D20" });
    mapCheckout.put("58", new String[] { "18 + D20" });
    mapCheckout.put("56", new String[] { "16 + D20" });
    mapCheckout.put("57", new String[] { "17 + D20" });
    mapCheckout.put("55", new String[] { "15 + D20" });
    mapCheckout.put("54", new String[] { "14 + D20" });
    mapCheckout.put("53", new String[] { "13 + D20" });
    mapCheckout.put("52", new String[] { "12 + D20" });
    mapCheckout.put("51", new String[] { "19 + D16" });
    mapCheckout.put("50", new String[] { "18 + D16", "T10 + D20" });
    mapCheckout.put("49", new String[] { "17 + D16" });
    mapCheckout.put("48", new String[] { "16 + D16" });
    mapCheckout.put("47", new String[] { "15 + D16" });
    mapCheckout.put("46", new String[] { "14 + D16" });
    mapCheckout.put("45", new String[] { "13 + D16" });
    mapCheckout.put("44", new String[] { "12 + D16" });
    mapCheckout.put("43", new String[] { "11 + D16" });
    mapCheckout.put("42", new String[] { "10 + D16" });
    mapCheckout.put("41", new String[] { "9 + D16" });
  }
}

/* Location:           C:\Users\Panatha\Desktop\jdartscorer0.3.jar
 * Qualified Name:     mate.dart.utils.Utils
 * JD-Core Version:    0.6.2
 */