package removeSubFoldersfromtheFilesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    //80ms solution , beat 30%
    public List<String> removeSubfolders(String[] folder) {
        Node root = new Node();
        for(String s : folder){
            addToTrie(s, root);
        }

        List<String> result = new ArrayList<>();
        for(String key : root.children.keySet()){
            updateResult(root.children.get(key), "/"+key, result);
        }
        return result;
    }

    private void updateResult (Node node, String path, List<String> result){
        if(node.isLeaf){
            result.add(path);
            return;
        }else{
            for(String key : node.children.keySet()){
                updateResult(node.children.get(key), path+"/"+key, result);
            }
        }
    }

    private void addToTrie(String s, Node root) {
        String[] paths = s.split("/");
        addPath(root, paths, 1);
    }

    private void addPath(Node root, String[] path, int index) {
        Node nextNode = root.children.get(path[index]);
        if(nextNode == null){
            nextNode = new Node();
            root.children.put(path[index], nextNode);
        }
        if(nextNode.isLeaf){
            return;
        }
        if(index < path.length-1)
            addPath(nextNode, path, index+1);
        else{
            nextNode.isLeaf = true;
        }
    }

    private static class Node {
        private Map<String, Node> children = new HashMap<>();
        private boolean isLeaf = false;
        Node(){}
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String[] folders ={"/a","/a/b","/c/d","/c/d/e","/c/f"};
        s.removeSubfolders(folders);
    }
}
