package com.company;

import java.util.ArrayList;

public class BSTRee {
        Node Root = null;

        public void traverse(Node Root)
        {
            ArrayList<Node> q = new ArrayList<>();
            ArrayList<Node> r = new ArrayList<>();
            q.add(Root);
            while(!q.isEmpty())
            {
                Node node = q.get((0));
                q.remove(node);

                if(node.Left != null)
                {
                    q.add(node.Left);
                }
                if(node.Right != null){
                    q.add(node.Right);
                }
                r.add(node);
            }
            r.forEach((T) -> {
                System.out.println(T.Data.ac_debt + " " + T.Data.surname);
            });
        }

        void insert(Student key) {
            Root = insertRecursive(Root, key);
        }

        private Node insertRecursive(Node cur, Student St){
            if(cur == null){
                return new Node (St);
            }
            if(St.ac_debt < cur.Data.ac_debt){
                cur.Left = insertRecursive(cur.Left, St);
                cur = rotateRight(cur);
            }
            else{
                cur.Right = insertRecursive(cur.Right, St);
                cur = rotateLeft(cur);
            }
            return cur;
        }

        private Node rotateLeft(Node cur){
            Node temp = cur.Right;
            cur.Right = temp.Left;
            temp.Left = cur;
            cur = temp;
            return cur;
        }

        private Node rotateRight(Node cur){
            Node temp = cur.Left;
            cur.Left = temp.Right;
            temp.Right = cur;
            cur = temp;
            return cur;
        }

        public Node search(Node root, double key)
        {
            if (root==null || root.Data.ac_debt == key)
                return root;
            if (key < root.Data.ac_debt){
                return search(root.Left, key);
            }
            return search(root.Right, key);
        }
    }
