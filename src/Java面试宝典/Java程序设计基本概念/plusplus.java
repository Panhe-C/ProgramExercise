package Java面试宝典.Java程序设计基本概念;

public class plusplus {
    public static void main(String[] args) {

        int i = 0;
        i = i++ + ++ i;//0+2=2

        int j = 0;
        j = ++j + j++ + j++ + j++;//1+1+2+3=7

        int k = 0;
        k = k++ + k++ + k++ + ++k;//0+1+2+4=7
        k = k++ + k++ + k++ + ++k + k++;//0+1+2+4+4=11

        int h = 0;
        h = ++h + ++h;//1+2=3

        int p1=0,p2=0;int q1=0,q2=0;
        q1 = ++ p1;
        q2 = p2++;
    }
}
