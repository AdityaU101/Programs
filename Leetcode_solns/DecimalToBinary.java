public class DecimalToBinary {
    public static void main(String[] args) {
    
        // decimal number 
        int decimal = 91;
        
        // convert decimal to binary
        String binary = Integer.toBinaryString(decimal);
        System.out.println(decimal + " in decimal = " + binary + " in binary.");
      }
}
