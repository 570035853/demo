package algorithm.leetcode.Algorithms._101_200._127_WordLadder;


import java.util.*;

/**
 * Created by jialei.zou on 2019/5/26 .
 ref:
 https://leetcode.com/problems/word-ladder/

 Given two words (beginWord and endWord), and a dictionary's word list,
 find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.

 Example 1:
 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]
 Output: 5
 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.


 Example 2:
 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 Output: 0
 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 */
public class WordLadder {

    private HashMap<String, List<String>> map = new HashMap<>();
    private HashMap<String, Boolean> visited = new HashMap<>();
    private int shortest = Integer.MAX_VALUE;
    private boolean find = false;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord==null || endWord==null || beginWord=="" || endWord=="" ||wordList==null|| wordList.size()<1 ){
            return 0;
        }
        if(beginWord.length()!=endWord.length()){
            return 0;
        }
        wordList.add(beginWord);
        initMap(wordList);
        Set set = new HashSet<>();
        set.add(beginWord);
        helper(new LinkedList<List<String>>(), set, beginWord, endWord);
        int result = 0;
        if(find){
            result = shortest;
        }
        shortest = Integer.MAX_VALUE;
        find = false;
        return result;
    }

    public void helper(List<List<String>> result, Set<String> set, String item, String endWorld){
        if(item.equals(endWorld)){
            find = true;
            set.add(endWorld);
            shortest = Math.min(shortest, set.size());
        }
        if(set.size()>=shortest){
            return;
        }
        List<String> list = map.get(item);
        if(list != null && list.size()>0){
            for (String neighbor: list){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    helper(result, set, neighbor, endWorld);
                    set.remove(neighbor);
                }
            }
        }
    }


    private void initMap(List<String> wordList){
        for (String itemFirst: wordList){
            List<String> list = new LinkedList<>();
            for (String itemSecond: wordList){
                if(!itemFirst.equals(itemSecond)){
                    if(distanceOne(itemFirst, itemSecond)){
                        list.add(itemSecond);
                    }
                }
            }
            map.put(itemFirst, list);
        }
    }

    private boolean distanceOne(String first, String second){
        if(first==null || second==null || first=="" || second==""){
            return false;
        }
        if(first.length()!=second.length()){
            return false;
        }
        int count = 0;
        for (int i=0; i<first.length(); i++){
            if(first.charAt(i) != second.charAt(i)){
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return count==1;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
//        System.out.println(wordLadder.ladderLength("hit", "cog",
//                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
//        System.out.println(wordLadder.ladderLength("hit", "cog",
//                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));

//        System.out.println(wordLadder.ladderLength("qa", "sq",
//                new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr",
//                        "ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa",
//                        "yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur",
//                        "rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm",
//                        "rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os",
//                        "uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am",
//                        "ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"))));


        System.out.println(wordLadder.ladderLength("qa", "sq",
                new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr",
                        "uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am",
                        "ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"))));

    }

}
