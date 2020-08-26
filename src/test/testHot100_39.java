package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testHot100_39 {
    //leetcode submit region begin(Prohibit modification and deletion)
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if(candidates==null||candidates.length==0){
                return res;
            }
            Arrays.sort(candidates);
            backTrack(res,new ArrayList<>(),target,0,candidates);
            return res;

        }
        //参数分别是需要返回的结果，当前已经拼凑的元素，还剩余需要平凑的元素之和，目前是在可选数组的哪一个位置，可选数组的集合
//    private void backTrack(List<List<Integer>> res,List<Integer> cur,int target,int index,int[] candidates){
//        if(target==0){
//            res.add(new ArrayList<>(cur));
//            return;
//        }
//        //这里回溯的过程i的起始位置要根据当前的索引来定，因为不是全排序，如果已经重复用完了，不用回头去考虑不再以前的
//        for(int i=index;i<candidates.length;i++){
//            //先判断当前遍历的元素是否超过了target，若是直接跳过
//            if(candidates[i]>target){
//                continue;
//            }
//            List<Integer> list = new ArrayList<>(cur);
//            list.add(candidates[i]);
//            //这里索引的位置还是i是因为可以考虑不断重复
//            backTrack(res,list,target-candidates[i],i,candidates);
//        }
//    }
        void  backTrack(List<List<Integer>> res, List<Integer> cur, int target, int index, int[] candidates){
            if(target==0){
                res.add(new ArrayList<>(cur));
                return;
            }
            for(int i=index;i<candidates.length;i++){
                if(target<candidates[i]){
                    continue;
                }
                cur.add(candidates[i]);
                backTrack(res,cur,target-candidates[i],i,candidates);
                cur.remove(cur.size()-1);
            }
        }

}
