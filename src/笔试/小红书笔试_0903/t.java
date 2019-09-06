package 笔试.小红书笔试_0903;

public class t {
    public static void main(String[] args) {
        String s = "asf<<<dfdf<dfd<";
        while(s.contains('<' +"")) {
            s = rel(s);
        }
        System.out.println(s);
    }
    public static String rel(String str){
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == '<')
                str = str.replace(str.substring(i-1,i+1),"");
        }
        System.out.println(str);
        return str;
    }
}
