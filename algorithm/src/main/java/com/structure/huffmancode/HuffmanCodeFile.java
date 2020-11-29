package com.structure.huffmancode;

import java.io.*;
import java.util.Map;

/**
 * 压缩与解压文件测试
 */
public class HuffmanCodeFile {
    private static Map<Byte, String> huffman;
    public static void main(String[] args) {
        File f1 = new File("F:\\课程\\高等数学\\数理统计与概论.pdf");
        File f2 = new File("F:\\课程\\高等数学\\result.zip");
        zipFile(f1,f2);

        File unf1 = new File("F:\\课程\\高等数学\\result.zip");
        File unf2 = new File("F:\\课程\\高等数学\\res.pdf");
        unZipFile(unf1,unf2);

    }

    public static void unZipFile(File inFile,File outFile){
        FileInputStream fs = null;
        ObjectInputStream ois = null;
        FileOutputStream os = null;

        try {
            fs = new FileInputStream(inFile);
            ois = new ObjectInputStream(fs);

            byte[] zipCodes = (byte[]) ois.readObject();

            Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();

            byte[] bytes = HuffmanCode.huffmanUnzip(huffmanCodes,zipCodes);
            os = new FileOutputStream(outFile);
            os.write(bytes);

            System.out.println("unzip success!!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (ois != null) {
                    ois.close();
                }
                if (fs != null) {
                    fs.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    /**
     * 文件压缩
     * @param inFile    需要压缩文件的路径
     * @param outFile   输出文件路径
     */
    public static void zipFile(File inFile,File outFile){
        FileInputStream fs = null;
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            //创建输入流
            fs = new FileInputStream(inFile);
            byte[] b = new byte[fs.available()];
            fs.read(b);
            huffman = HuffmanCode.getHuffmanCodesByBytes(b);
            byte[] zipBytes = HuffmanCode.zip(b,huffman);
            os = new FileOutputStream(outFile);
            //将压缩后的字节码写入文件
            oos = new ObjectOutputStream(os);
            oos.writeObject(zipBytes);
            oos.writeObject(huffman);

            System.out.println("File zip success!!");
        } catch (FileNotFoundException e) {
            System.out.println("error:File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fs != null) {
                    fs.close();
                }
                if (oos != null) {
                    oos.close();
                }
                if (os != null) {
                    os.close();
                }

            } catch (IOException e) {
                System.out.println("error:FileStream close failed!");
                e.printStackTrace();
            }
        }

    }

}
