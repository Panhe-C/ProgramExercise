package 算法经典问题;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        PriorityQueue<Person> priorityQueue1 = new PriorityQueue<>();
//
//        priorityQueue.offer(10);
//        priorityQueue.offer(9);
//        priorityQueue.offer(2);
//        priorityQueue.offer(1);
//        priorityQueue.offer(11);
//        priorityQueue.offer(24);
//
//        Iterator iterator = priorityQueue.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
        HashMap<String, Map<String,Integer>> graph = new HashMap<>();


        //构建图的关系
        graph.put("A", new HashMap<String,Integer>(){{ put("B",5);put("C",1);}});
        graph.put("B", new HashMap<String,Integer>(){{ put("A",5);put("C",2);put("D",1);}});
        graph.put("C", new HashMap<String,Integer>(){{ put("A",1);put("B",2);put("D",4);put("E",8);}});
        graph.put("D", new HashMap<String,Integer>(){{ put("B",1);put("C",4);put("E",3);put("F",6);}});
        graph.put("E", new HashMap<String,Integer>(){{ put("C",8);put("D",3);}});
        graph.put("F", new HashMap<String,Integer>(){{ put("D",6);}});

        System.out.println(graph.get("A").get("B"));

    }


    public static void Dijkstra(HashMap<String,Map<String,Integer>> graph, String startNode){
        PriorityQueue<Map<Integer,String>> queue = new PriorityQueue<>();

        queue.offer(new HashMap<Integer, String>() {{ put(0, startNode); }});



        Map<String,Integer> distance = init_distance(graph,startNode);
        List<String> seen = new ArrayList<>();//把点拿出队列后才会认为被搜寻过

        Map<String,String> parent = new HashMap<>();//用来存储路径中某一个节点的上一个节点
        parent.put(startNode,null);

        int dist = 0;

        while (queue.peek()!=null){

            Map<Integer, String> pair = queue.poll();
            Set<Integer> keys = pair.keySet();

            Integer key = keys.iterator().next();

            String vertax = pair.get(key);
            distance.put(pair.get(key), key);
            seen.add(vertax);

            dist = key;


            Set<String> nodes = graph.keySet();
            for (String node:nodes) {
                if(!seen.contains(vertax)){
                    if(dist + graph.get(vertax).get(node) < distance.get(node)){
                        queue.offer(new HashMap<Integer, String>() {{ put(distance.get(node), node); }});
                        parent.put(node,vertax);
                        distance.put(node,graph.get(vertax).get(node));
                    }
                }
            }

//            return parent,distance;


        }


    }

    public static Map<String,Integer> init_distance(HashMap<String,Map<String,Integer>> graph,String startNode){
        Map<String,Integer> distance = new HashMap<>();
        distance.put(startNode,0);

        for (String vertex:graph.keySet()){
            if(vertex != startNode){
                distance.put(vertex,Integer.MAX_VALUE);
            }
        }

        return distance;
    }



}

