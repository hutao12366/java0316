package com.hu.structure;

import com.hu.node.TreeNode;
import com.hu.node.imp.HuffmanTreeTreeNode;
import java.util.*;

/**
 * @author hutao
 */
public class HuffmanCoding
{
    public static void main(String[] args)
    {
        byte[] bytes = "i like like like java do you like a java".getBytes();

        HuffmanCoding huffmanCoding=new HuffmanCoding();
        Map<Byte, String> map = huffmanCoding.huffmanCode(bytes);
        System.out.println(map);
    }


    //   源码-次数-编码   次数-源码

    /**
     * 获取赫夫曼编码
     *
     * @param arr 获取赫夫曼编码
     * @return 赫夫曼编码
     */
    public Map<Byte, String> huffmanCode(byte[] arr)
    {

        // 计算每个byte值出现的次数
        Map<Byte, HuffmanTreeTreeNode> map = wrap(arr);
        Collection<HuffmanTreeTreeNode> values = map.values();
        //构建赫夫曼树
        HuffmanTree huffmanTree = new HuffmanTree();
        TreeNode<Integer> node = huffmanTree.create(new ArrayList<>(values));
        // 创建赫夫曼编码
        Map<Byte, String> codes = new HashMap<>(7);
        this.createHuffmanCoding((HuffmanTreeTreeNode) node, codes, "");
        return codes;
    }


    private Map<Byte, HuffmanTreeTreeNode> wrap(byte[] arr)
    {
        Map<Byte, HuffmanTreeTreeNode> map = new HashMap<>(7);
        for (byte b : arr)
        {
            HuffmanTreeTreeNode integer = map.get(b);
            if (integer != null)
            {
                integer.setData(integer.value() + 1);
            }
            else
            {
                HuffmanTreeTreeNode treeNode = new HuffmanTreeTreeNode();
                treeNode.setData(1);
                treeNode.setKey(b);
                map.put(b, treeNode);
            }
        }
        return map;
    }

    /**
     * 创建赫夫曼编码集合
     *
     * @param huffmanTreeNode 根节点
     * @param codes           集合
     * @param code            “
     */
    private void createHuffmanCoding(HuffmanTreeTreeNode huffmanTreeNode, Map<Byte, String> codes, String code)
    {
        if (huffmanTreeNode != null)
        {
            TreeNode<Integer> right = huffmanTreeNode.right();
            TreeNode<Integer> left = huffmanTreeNode.left();
            if (right == null && left == null)
            {
                codes.put(huffmanTreeNode.getKey(), code);
            }
            else
            {
                // 左边 0
                createHuffmanCoding((HuffmanTreeTreeNode) left, codes, code + "0");
                // 右边 1
                createHuffmanCoding((HuffmanTreeTreeNode) right, codes, code + "1");
            }
        }

    }

}
