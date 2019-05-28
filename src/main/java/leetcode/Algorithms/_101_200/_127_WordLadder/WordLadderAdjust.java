package leetcode.Algorithms._101_200._127_WordLadder;

import java.util.*;

/**
 * Created by jialei.zou on 2019/5/26 .
 */
public class WordLadderAdjust {

    private HashMap<String, List<String>> map = new HashMap<>();
    private HashMap<String, Boolean> visited = new HashMap<>();
    private int shortest = 0;
    private boolean find = false;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null|| wordList.size()<1 ){
            return 0;
        }
        if(beginWord.length()!=endWord.length()){
            return 0;
        }
        wordList.add(beginWord);
        initMap(wordList);
        helper(beginWord, endWord);
        int result =0 ;
        if(find) {result = shortest;}
        shortest = 0;
        return result;
    }



    public void helper(String beginWord, String endWorld){
        int result = 1;
        List<String> neighbors = map.get(beginWord);
        visited.put(beginWord, true);
        Queue<String> queue= new LinkedList<>(neighbors);
        while (queue !=null && queue.size()>0){
            int size = queue.size();
            result++;
            for (int i=0; i<size; i++){
                String item = queue.poll();
                visited.put(item, true);
                if(item.equals(endWorld)){
                    find = true;
                    shortest = result;
                    return;
                }else {
                    List<String> itemNeighbor = map.get(item);
                    if(itemNeighbor != null && itemNeighbor.size()>0){
                        for (int j=0; j<itemNeighbor.size(); j++){
                            if(!visited.containsKey(itemNeighbor.get(j))){
                                queue.offer(itemNeighbor.get(j));
                            }
                        }
                    }
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
        WordLadderAdjust wordLadder = new WordLadderAdjust();
        System.out.println(wordLadder.ladderLength("hit", "cog",
                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
        System.out.println(wordLadder.ladderLength("hit", "cog",
                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"))));

        System.out.println(wordLadder.ladderLength("qa", "sq",
                new ArrayList<>(Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr",
                        "ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa",
                        "yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur",
                        "rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm",
                        "rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os",
                        "uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am",
                        "ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"))));



    }
}
