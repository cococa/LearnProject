package com.cocoa.tree.binary;

import com.cocoa.weixin.AppType;
import org.jetbrains.annotations.NotNull;


public class TreeNode<T extends Comparable> {

    T val;

    TreeNode(T val) {
        this.val = val;
    }

    TreeNode<T> left;
    TreeNode<T> right;


   static class Obj implements Comparable{
        String name;

        public Obj(String name) {
            this.name = name;
        }

       @Override
       public int compareTo(@NotNull Object o) {
           return 0;
       }
   }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(new Obj("123"));

    }



}
