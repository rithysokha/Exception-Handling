//group 8
package Exercise3;

public class Exercise3 {
    public static String hex2Binary (String hexString) throws NumberFormatException {
        //using  condition to set hexString
      if(!hexString.matches("i am ITE student")){
        //if check wrong string that set it will be so Invalid
          throw new NumberFormatException("Invalid hex String ");
      }

      String binaryString = "" ;
      // method count charcter in character , digit as binary
        for (int i = 0; i < hexString.length(); i++) {

            char charctor = hexString.charAt(i);

            int digit = Character.digit(charctor, 16);

            binaryString += String.format("-%08d", digit);
        }
        return binaryString;
    }

    public static void main(String[] args) {
        String hexString = "i am ITE student";
        System.out.println(hex2Binary(hexString));
    }
}
