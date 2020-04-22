package algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 贪婪算法
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
//        创建广播电台
        Map<String, HashSet<String>> broadcast = new HashMap<>();
        HashSet<String> v1 = new HashSet<>();
        v1.add("北京");
        v1.add("上海");
        v1.add("天津");
        broadcast.put("k1",v1);

        HashSet<String> v2 = new HashSet<>();
        v2.add("广州");
        v2.add("北京");
        v2.add("深圳");
        broadcast.put("k2",v2);

        HashSet<String> v3 = new HashSet<>();
        v3.add("成都");
        v3.add("上海");
        v3.add("杭州");
        broadcast.put("k3",v3);

        HashSet<String> v4 = new HashSet<>();
        v4.add("上海");
        v4.add("天津");
        broadcast.put("k4",v4);

        HashSet<String> v5 = new HashSet<>();
        v5.add("杭州");
        v5.add("大连");
        broadcast.put("k5",v5);


        //创建 allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建 ArrayList 存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和当前没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义 maxKey 保存在一次遍历过程中，能够覆盖最大未覆盖地区对应的电台的 key
        String maxKey = null;
        //如果 maxKey 不为 null 则会加入到 selects 中
        while (allAreas.size() != 0) {
            maxKey = null;
            //allAreas 不为 0 ，表示还没有覆盖到所有的地区
            for (String key : broadcast.keySet()) {
                tempSet.clear();
                tempSet.addAll(broadcast.get(key));
                //求取交集，将结果赋值给 tempSet
                tempSet.retainAll(allAreas);

                //得到一次遍历的 maxKey  tempSet.size() > broadcast.get(maxKey).size() 体现了贪婪
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcast.get(maxKey).size())) {
                    maxKey = key;
                }
            } //end for
            if (maxKey != null) {
                selects.add(maxKey);
                //将 maxKey 指向的广播电台覆盖的地区，从 allAreas 中去掉
                allAreas.removeAll(broadcast.get(maxKey));
            }
        } //end while


        // [k1,k2,k3,k5]
        System.out.println("得到的结果："+ selects);


    }


}
