package com.hu.structure;

import com.hu.node.TreeNode;
import com.hu.node.imp.HuffmanTreeTreeNode;

import java.util.*;

/**
 * @author hutao
 */
public class HuffmanTree
{

    /**
     * 创建赫夫曼树
     *
     * @param collect 创建赫夫曼树
     */
    public TreeNode<Integer> create(List<TreeNode<Integer>> collect)
    {

        // 长度不够
        if (collect.size() < 2)
        {
            return null;
        }
        collect.sort(Comparator.comparingInt(TreeNode::value));
        int i = 0;
        for (; i < collect.size() - 1; i++)
        {
            //创建父节点
            HuffmanTreeTreeNode huffmanTreeNode = new HuffmanTreeTreeNode(collect.get(i)
                    .value() + collect.get(i + 1)
                    .value());
            // 左节点
            huffmanTreeNode.setLeft(collect.get(i));
            // 右节点
            huffmanTreeNode.setRight(collect.get(i + 1));
            // 把父节点插入有序集合
            insert(collect, huffmanTreeNode, i);
        }
        return collect.get(i);
    }


    private void insert(List<TreeNode<Integer>> collect, TreeNode<Integer> node, int start)
    {
        int i = start;
        // 寻找插入的位置
        for (; i < collect.size() - 1; i++)
        {
            if (node.value() > collect.get(i + 1)
                    .value())
            {
                //条件不符，把右边一个元素左移
                collect.set(i, collect.get(i + 1));
            }
            else
            {
                // 位置找到结束循环
                break;
            }
        }

        // 判断插入位置是否有变化
        if (start != i)
        {
            // 找到位置插入
            collect.set(i, node);
        }
    }


}
