public class Roman_to_Integer {
  public int romanToInt(String s) {
    int result = 0;

    StringBuilder roman = new StringBuilder(s);
    while (roman.length() != 0) {

      char current = roman.charAt(0);
      if (roman.length() > 1) {
        char next = roman.charAt(1);
        boolean match = true;

        String stringBuilder = String.valueOf(current)
            + next;
        switch (stringBuilder){
          case "IV" -> result += 4;
          case "IX" -> result += 9;
          case "XL" -> result += 40;
          case "XC" -> result += 90;
          case "CD" -> result += 400;
          case "CM" -> result += 900;
          default -> match = false;
        }

        if (match) {
          roman.delete(0,2);
          continue;
        }
      }

      switch (current) {
        case 'I' -> result += 1;
        case 'V' -> result += 5;
        case 'X' -> result += 10;
        case 'L' -> result += 50;
        case 'C' -> result += 100;
        case 'D' -> result += 500;
        case 'M' -> result += 1000;
      }
      roman.delete(0,1);
    }


    return result;
  }

  public int romanToInt_v2(String s){
    int result = 0;
    int previous, current;
    previous = current = getValue(s.charAt(0));
    for(int i = 1; i < s.length(); i++) {
      current = getValue(s.charAt(i));
      if (current > previous) {
        result -= previous;
      } else {
        result += previous;
      }
      previous = current;
    }
    return result + current;
  }

  private int getValue(char c) {
    int result = 0;
    switch (c) {
      case 'I' -> result = 1;
      case 'V' -> result = 5;
      case 'X' -> result = 10;
      case 'L' -> result = 50;
      case 'C' -> result = 100;
      case 'D' -> result = 500;
      case 'M' -> result = 1000;
    }
    return result;
  }

}
