package interview.LRUCache;

public class Test {

    public static void main(String[] args) {
        LRUCache<Integer> cache = new LRUCache<>(5);

        cache.add("liuxiaoguo", new Integer("101"));
        cache.add("fengbo", new Integer("102"));
        cache.add("luzhengqiao", new Integer("103"));
        cache.add("fuxuezhou", new Integer("104"));
        cache.add("houweiwei", new Integer("105"));
        cache.print(cache.head);
        cache.add("zoujialei", new Integer("106"));
        cache.print(cache.head);
        cache.get("luzhengqiao");
        cache.print(cache.head);

    }
}
