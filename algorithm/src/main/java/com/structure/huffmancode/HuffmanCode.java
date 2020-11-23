package com.structure.huffmancode;

import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String content= "Headless recorder is a Chrome extension that records your browser interactions and generates a Puppeteer or Playwright script. Install it from the Chrome Webstore. Don't forget to check out our sister project theheadless.dev, the open source knowledge base for Puppeteer and Playwright.";
        byte contentByte[] = content.getBytes();
        System.out.println(contentByte.length);
        List<Node> nodes = getNodes(contentByte);
        Node node = createHuffmanTree(nodes);
        System.out.println(node);
//        node.preOrder();
//        System.out.println(node);
    }

    //获取权值
    public static List<Node> getNodes(byte bytes[]){
        List<Node> nodes = new ArrayList<>(27);
        Map<Byte,Integer> counts= new HashMap<>();
        Integer count;
        for (byte b: bytes) {
            count = counts.get(b);
            if (null == count){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }

        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    /**
     * 创建一个huffman树
     * @param nodes   传入一个数组
     * @return  返回一个根节点
     */
    public static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.getCount() + rightNode.getCount());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

}
