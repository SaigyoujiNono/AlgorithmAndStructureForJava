package com.structure.huffmancode;

import java.util.*;

public class HuffmanCode {

    //尝试用一个变量记录最后一个补零个数
    private static final int[] mod = {0};

    private static Map<Byte, String> huffman;    //编码表

    public static void main(String[] args) throws Exception {
        String content = "JiN4NURFRTsmI3g0RTBEOyYjeDU5MUE7JiN4NUY5NzsmI3g0RTg2Ow==";
        huffman = getHuffmanCodes(content);
        System.out.println(huffman);
//        byte[] by = zip(content.getBytes(),huffmanCodes);
        byte[] by = zip(content.getBytes());
        byte[] res =huffmanUnzip(huffman,by);
        System.out.println("压缩前-> "+Arrays.toString(content.getBytes()));
        System.out.println("解压后-> "+Arrays.toString(res));
    }

    public static byte[] zip(byte[] bytes){
        byte[] result = zip(bytes,huffman);
        return result;
    }

    //huffman解压
    public static byte[] huffmanUnzip(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);  //==1,0
            stringBuilder.append(byteToBitString(!flag, b));
        }
//        System.out.println(byteToBitString(false, huffmanBytes[huffmanBytes.length - 1]));
//        System.out.println("zip 压缩后的数据-> "+stringBuilder);
        //解码,反向编码表
        Map<String, Byte> map = reverseMap(huffmanCodes);

        //根据编码扫描到对应的ASCLL码对应的字符
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length()-mod[0]; ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
//                if (count<stringBuilder.length()){
//                    break;
//                }
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }

        byte b[] = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;

    }

    /**
     * 将字符串的长度转换成8的倍数
     * @param str
     * @return
     */
    public static String to8(String str){
        int size = str.length();
        mod[0] = 8-(size%8);
        String bu = "";
        for (int i = 0; i < mod[0]; i++) {
            bu+=0;
        }
        str+=bu;
        return str;
    }

    //转化二进制
    private static String byteToBitString(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            if (str.length() == 8){
                return str;
            }else {
                int adds = 8-str.length();  //给最后一个str前边补足0
                for (int i = 0; i < adds; i++) {
                    str = "0"+str;
                }
                return str;
            }

        }
    }

    /**
     * @param bytes        原始数组的字符串对应的byte
     * @param huffmanCodes 生成的Huffman编码map
     * @return 返回Huffman编码处理后的byte[] 每个byte 8 位
     * huffmanCodesBytes[0] = 10101000(补码) => byte10101000=> 10101000-1 =>10100111(补码) => 11011000(原码)
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        //先创建一个字符串
        StringBuilder res = new StringBuilder();
        //遍历字符串数组bytes
        for (byte b : bytes) {
            res.append(huffmanCodes.get(b));    //res = 8356
        }
        res = new StringBuilder(to8(res.toString()));
//        System.out.println("zip 压缩前的数据-> "+res);
        //求bytes数组长度
        int len = (res.length() + 7) / 8; //len = 1045
//        for (int i = 0; i < res.length()%8; i++) {
//            res.append("0");
//        }
        //创建存储压缩后的byte数组
        byte[] huffmanBytes = new byte[len];  //先声明一个结果集
//        huffmanBytes[huffmanBytes.length-1] = (byte)(res.length()%8);
        for (int i = 0, index = 0; i < res.length(); i += 8, index++) {//因为是每8位对应一个byte
            String strByte;
            if (i + 8 > res.length()) {//当到最后的时候可能发生越界
                strByte = res.substring(i);
            } else {
                strByte = res.substring(i, i + 8);
            }
            huffmanBytes[index] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanBytes;
    }

    /**
     * 将传入的node节点的所有叶子节点的huffman编码存放到huffmanCodes集合
     *
     * @param node 传入节点
     * @param code 路径：左子节点 0 ，右子节点1
     * @param str  用来拼接路径
     */
    public static void getHuffmanCodes(Node node, String code, StringBuilder str, Map<Byte, String> huffmanCodes) {
        if (node == null) {
            return;
        }
        StringBuilder str2 = new StringBuilder(str);
        str2.append(code);
        //判断当前node是叶子节点还是非叶子节点
        if (null == node.getVal()) {//非叶子节点
            getHuffmanCodes(node.getLeft(), "0", str2, huffmanCodes);
            getHuffmanCodes(node.getRight(), "1", str2, huffmanCodes);
        } else {  //叶子节点
            //就表示找到了某个叶子节点的最后
            huffmanCodes.put(node.getVal(), str2.toString());
        }
    }

    /**
     * 传入一个字符串，获取字符串返回的huffman编码表
     * @param str
     * @return
     */
    public static Map<Byte,String> getHuffmanCodes(String str){
        //先将传入的字符串转成byte数组
        return getHuffmanCodesByBytes(str.getBytes());
    }


    /**
     * 传入一个byte数组，返回一个Huffman编码表
     * @param bytes
     * @return
     */
    public static Map<Byte,String> getHuffmanCodesByBytes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        Integer count;
        for (byte b : bytes) {
            count = counts.get(b);
            if (null == count) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

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

        //Huffman编码表
        Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
        getHuffmanCodes(nodes.get(0), "", new StringBuilder(), huffmanCodes);
        return huffmanCodes;
    }

    //反转一个hashMap
    public static Map<String,Byte> reverseMap(Map<Byte,String> map){
        Map<String,Byte> tMap = new HashMap<>();
        for (Map.Entry<Byte,String> entry : map.entrySet()) {
            tMap.put(entry.getValue(),entry.getKey());
        }
        return tMap;
    }



}
