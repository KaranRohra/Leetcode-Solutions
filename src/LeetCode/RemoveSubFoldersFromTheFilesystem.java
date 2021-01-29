package LeetCode;

import java.util.*;

public class RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        System.out.println(new Solution1233().removeSubfolders(new String[]{
                "/a","/a/b","/c/d","/c/d/e","/c/f"
        }));
    }
}
//https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
class Solution1233 {// 71 ms
    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        int n = folder.length;
        for (int i = 0; i < n; ) {
            String x = folder[i];
            while (i < n && equals(x, folder[i])) {
                i++;
                //System.out.println(i);
            }
            //System.out.println(i);
            res.add(x);
        }
        return res;
    }

    private boolean equals(String x, String y) {
        if (x.equals(y))
            return true;

        int n = x.length(), m = y.length();
        if (m < n)
            return false;
        return x.equals(y.substring(0, n)) && y.charAt(n) == '/';
    }
}