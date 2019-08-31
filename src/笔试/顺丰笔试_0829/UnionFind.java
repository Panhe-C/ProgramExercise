package 笔试.顺丰笔试_0829;

public class UnionFind {
    //定义一个数组，数组下标表示并查集所有元素，对应的值表示元素所属的集合
    private int[] id;
    //数组中包含的元素个数
    private int count;
    public UnionFind(int n) {
        count=n;
        id=new int[n];
    //初始化时，数组的每个元素在不同的集合中
        for(int i=0;i<n;i++) {
            id[i]=i;
        }
    }
    //1.找到某个元素所对应的值，查看元素所属于哪个集合
    int find(int p) {
     if(p<0||p>=count)
        return -1;
     return id[p];
    }
    //2.判断两个元素是否属于同一个集合，即看对应的值是否相等
    boolean isConnected(int p,int q) {
        return find(p)==find(q);
    }
    //3.合并两个元素所在的集合，即连接两个元素
    public void union(int p,int q) {
        //找到第一个元素所在的集合
        int pID=find(p);
        //找到第二个元素所在的集合
        int qID=find(q);
        //如果属于同一个集合，直接返回
        if(pID==qID)
            return;
        //如果不属于，遍历，将pID集合合并到qID
        for(int i=0;i<count;i++) {
            if(id[i]==pID)
                id[i]=qID;
        }
    }
    //4.测试，将数组打印出来
    public void printId() {
        for(int a :id)
            System.out.print(a+" ");
        System.out.println();
    }
}