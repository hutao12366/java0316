package com.hu.node;

import java.util.function.Consumer;

/**
 * @author hutao
 */
public interface TreeNode<T>
{
    /**
     * 左节点
     *
     * @return 左节点
     */
    TreeNode<T> left();

    /**
     * 右节点
     *
     * @return 右节点
     */
    TreeNode<T> right();

    /**
     * 父节点
     *
     * @return 父节点
     */
    TreeNode<T> parent();

    /**
     * 值
     *
     * @return 值
     */
    T value();


    /**
     * 前序遍历
     *
     * @param consumer 打印
     */
    default void preorderTraversal(Consumer<T> consumer)
    {

        consumer.accept(this.value());
        if (this.left() != null)
        {
            this.left()
                    .preorderTraversal(consumer);
        }
        if (this.right() != null)
        {
            this.right()
                    .preorderTraversal(consumer);
        }

    }


    /**
     * 中序遍历
     *
     * @param consumer 中序遍历
     */
    default void inOrderTraversal(Consumer<T> consumer)
    {


        if (this.left() != null)
        {
            this.left()
                    .preorderTraversal(consumer);
        }
        consumer.accept(this.value());
        if (this.right() != null)
        {
            this.right()
                    .preorderTraversal(consumer);
        }

    }

}
