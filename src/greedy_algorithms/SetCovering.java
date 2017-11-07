package greedy_algorithms;

import java.util.*;

/**
 * Created by JasonZh on 2017/11/7.
 * 贪婪算法（集合覆盖问题）
 */
public class SetCovering {

    public static void main(String[] args) {

        Set<String> statesNeeded = new HashSet(Arrays.asList("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
        Map<String, Set<String>> stations = new LinkedHashMap<>();

        stations.put("kone", new HashSet<>(Arrays.asList("id", "nv", "ut")));
        stations.put("ktwo", new HashSet<>(Arrays.asList("wa", "id", "mt")));
        stations.put("kthree", new HashSet<>(Arrays.asList("or", "nv", "ca")));
        stations.put("kfour", new HashSet<>(Arrays.asList("nv", "ut")));
        stations.put("kfive", new HashSet<>(Arrays.asList("ca", "az")));

        Set<String> finalStations = new HashSet<String>();

        while (!statesNeeded.isEmpty()) {
            String bestStation = null;
            Set<String> statesCovered = new HashSet<>();

            for (Map.Entry<String, Set<String>> station : stations.entrySet()) {
                Set<String> covered = new HashSet<>(statesNeeded);
                // 交集
                covered.retainAll(station.getValue());

                if (covered.size() > statesCovered.size()) {
                    bestStation = station.getKey();
                    statesCovered = covered;
                }

                // JAVA8语法，去除对应元素
                statesNeeded.removeIf(statesCovered::contains);

                if (bestStation != null) {
                    finalStations.add(bestStation);
                }

            }

        }

        System.out.println(finalStations); // [ktwo, kone, kthree, kfive]

    }


}
