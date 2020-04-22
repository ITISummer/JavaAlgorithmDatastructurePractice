package practice.lanqiao.lanqiao_practice_system.基础练习;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * input:
 * 2
 * 39
 * 123ABC
 * output:
 * 71
 * 4435274
 * //1. hex to binary
 * //2. add "00" or "0"
 * //3. binary to oct
 * //4. remove the heading zero
 */
public class 十六转八进制 {
    public static void main(String[] args) throws IOException {
        String[] hexMapping = {
                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
        };
        Map<String, String> octMapping = new HashMap<>();
        octMapping.put("000", "0");
        octMapping.put("001", "1");
        octMapping.put("010", "2");
        octMapping.put("011", "3");
        octMapping.put("100", "4");
        octMapping.put("101", "5");
        octMapping.put("110", "6");
        octMapping.put("111", "7");


        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
//		consuming the <enter> from input above
//        input.nextLine();

		StringBuilder hex2Bin;
		String hexString = "";

		for (int i = 0; i < n; i++) {

            hex2Bin = new StringBuilder("");
            hexString = input.next();
            // hex to bin
            int hexLen = hexString.length();
            for (int j = 0; j < hexLen; j++) {
                if (hexString.charAt(j) > '9') {
                    hex2Bin.append(hexMapping[hexString.charAt(j) - 'A' + 10]);
                } else {
                    hex2Bin.append(hexMapping[hexString.charAt(j) - '0']);
                }
            } //end for

            // add "00" or "0"
            int len = hex2Bin.length();
            if (len % 3 == 1) {
                hex2Bin.insert(0, "00");
            } else if (len % 3 == 2) {
                hex2Bin.insert(0, "0");
            }

            // bin to oct
            int newLen = hex2Bin.length();
            String temp = "";
            for (int j = 0; j < newLen; j += 3) {
                temp = octMapping.get(hex2Bin.substring(j, j + 3));
                if ((j == 0 && temp.equals("0")) || (j == 3 && temp.equals("0"))) {
                    continue;
                }
				System.out.print(temp);
            } //end for
        }//end for
        input.close();
    }
}
