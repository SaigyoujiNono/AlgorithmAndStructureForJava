package com.structure.tree;

import lombok.Data;

/**
 * 构建一颗huffman树
 */
public class HuffmanTree {
    int[] arr = {5,9,18,25,29,35,45,54,64,84,111};





    public static void createHuffmanTree(){

    }



    @Data
    private class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
