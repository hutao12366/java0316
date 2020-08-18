package com.hu.node.imp;

import com.hu.node.TreeNode;

/**
 * @author hutao
 */
public class HuffmanTreeTreeNode implements TreeNode<Integer>, Comparable<HuffmanTreeTreeNode>
{

    private Integer data;
    private Byte key;
    private String code;
    private TreeNode<Integer> left;
    private TreeNode<Integer> right;
    private TreeNode<Integer> parent;


    public HuffmanTreeTreeNode(Integer i)
    {
        this.data = i;
    }

    public HuffmanTreeTreeNode()
    {

    }

    @Override
    public String toString()
    {
        return data + "";
    }

    @Override
    public int compareTo(HuffmanTreeTreeNode o)
    {
        return this.data - o.data;
    }

    @Override
    public TreeNode<Integer> left()
    {
        return this.left;
    }

    @Override
    public TreeNode<Integer> right()
    {
        return this.right;
    }

    @Override
    public TreeNode<Integer> parent()
    {
        return this.parent;
    }

    @Override
    public Integer value()
    {
        return this.data;
    }

    public Integer getData()
    {
        return data;
    }

    public void setData(Integer data)
    {
        this.data = data;
    }

    public TreeNode<Integer> getLeft()
    {
        return left;
    }

    public void setLeft(TreeNode<Integer> left)
    {
        this.left = left;
    }

    public TreeNode<Integer> getRight()
    {
        return right;
    }

    public void setRight(TreeNode<Integer> right)
    {
        this.right = right;
    }

    public TreeNode<Integer> getParent()
    {
        return parent;
    }

    public void setParent(TreeNode<Integer> parent)
    {
        this.parent = parent;
    }

    public Byte getKey()
    {
        return key;
    }

    public void setKey(Byte key)
    {
        this.key = key;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}
