package 笔试.汇顶笔试_0826;

//Man

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Scanner;

public class one {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        byte[] toEncode = str.getBytes("utf-8");
//        String encode = Base64.getMimeEncoder().encodeToString(toEncode);
        String encode = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));

        System.out.println(encode   );
    }
}
