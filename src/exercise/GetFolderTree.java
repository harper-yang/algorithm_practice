package exercise;

import java.util.HashMap;
import java.util.Map;

public class GetFolderTree {

    public static class Node {
        public String name;
        public Map<String, Node> nextMap;

        public Node(String name) {
            this.name = name;
            nextMap = new HashMap<>();
        }
    }

    public static void print(String[] stringPaths) {
        if (stringPaths == null || stringPaths.length == 0) {
            return;
        }
        Node head = generateFolderTree(stringPaths);
        printProcess(head, 0);
    }

    // 生成前缀树
    private static Node generateFolderTree(String[] stringPaths) {
        Node head = new Node(""); // 创建头节点
        for (String path : stringPaths) {
            String[] folderPath = path.split("\\\\");
            Node cur = head;
            // 处理每一个文件夹链条
            for (String folder : folderPath) {
                if (!cur.nextMap.containsKey(folder)) {
                    cur.nextMap.put(folder, new Node(folder));
                }
                cur = cur.nextMap.get(folder);
            }
        }
        return head;
    }

    // 按照深度优先遍历打印前缀树
    public static void printProcess(Node node, int level) {
        if (level != 0) {
            // 打印节点
            System.out.println(get2nSpace(level, node.name));
        }
        for (Node nextNode : node.nextMap.values()) {
            printProcess(nextNode, level + 1);
        }
    }

    private static String get2nSpace(int n, String name) {
        return "  ".repeat(Math.max(0, n - 1)).concat(name);
    }

    public static void main(String[] args) {
        String str = "a\\b\\c";
        String str2 = "b\\c\\d";
        String str3 = "a\\m\\n";
        print(new String[]{str,str2, str3});
    }
}
