package dijkstras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JasonZh on 2017/11/3.
 * 狄克斯特拉算法 (加权图中查找最短路径)
 */
public class DijkstrasAlgorithm {

    // 图
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    // 处理过的节点
    private static List<String> processed = new ArrayList<>();

    /**
     * 查找最便宜且没有处理过的节点
     */
    private static String findLowestCostNode(Map<String, Double> costs) {
        Double lowestCost = Double.POSITIVE_INFINITY;
        String lowestCostNode = null;

        for (Map.Entry<String, Double> entry : costs.entrySet()) {
            // 查找最便宜且没有处理过的节点
            if (lowestCost > entry.getValue() && !processed.contains(entry.getKey())) {
                lowestCost = entry.getValue();
                lowestCostNode = entry.getKey();
            }
        }

        return lowestCostNode;
    }


    public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("c", 1.0);
        graph.get("a").put("fin", 4.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        // 添加一个c节点
        graph.put("c", new HashMap<>());
        graph.get("c").put("fin", 1.0);

        graph.put("fin", new HashMap<>());

        // the costs table
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);

        // the parents table
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);   //


        String node = findLowestCostNode(costs);
        while (node != null) {
            Double cost = costs.get(node);

            // 遍历该节点所有邻居
            Map<String, Double> neighbors = graph.get(node);
            for (String n : neighbors.keySet()) {
                double newCost = cost + neighbors.get(n);
                // 如果通过当前节点的父节点node到这个节点n的花费更低的话，更新costs[n]和parents[n]
                if (costs.get(n) == null || newCost < costs.get(n)) {
                    // 更新到此节点n的花费
                    costs.put(n, newCost);
                    // This node becomes the new parent for this neighbor
                    parents.put(n, node);
                }
            }

            // Mark the node as processed
            processed.add(node);

            // 获取下一个最便宜的节点，循环
            node = findLowestCostNode(costs);
        }


        System.out.println("Cost from the start to each node:");
        System.out.println(costs); // { a: 5, b: 2, fin: 6 }


    }

}
