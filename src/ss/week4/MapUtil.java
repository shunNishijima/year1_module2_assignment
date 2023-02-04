package ss.week4;

import java.util.*;

public class MapUtil {


    //@ensures \result == (\forall K key1,key2; map.containsKey(key1)&&map.containsKey(key2)&&key1!=key2;map.get(key1)!=map.get(key2));
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        boolean isoneonone = true;
        for (K key1:map.keySet()){
            for (K key2: map.keySet()){
                if(key1!=key2&&map.get(key1) == map.get(key2)){
                    isoneonone = false;
                }
            }
        }
        return isoneonone;
    }

    //@ensures (\forall V value; map.containsValue(value); (\exists K key ;map.containsKey(key);map.get(key) == value));
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        int issubjective = 0;
        for (int i=0; i<range.size(); i++) {
            for (K key : map.keySet()) {
                if (range.toArray()[i].equals(map.get(key))) {
                    issubjective++;
                    break;
                }
            }
        }
        return issubjective == range.size();
    }
    //@ensures (\forall K key;map.containsKey(key); (\result.get(map.get(key))==key) );
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V,Set<K>> inversemap = new HashMap<>();
        for (K key : map.keySet()){
            if (inversemap.containsKey(map.get(key))) {
                inversemap.get(map.get(key)).add(key);
            } else {
                inversemap.put(map.get(key), new HashSet<>(List.of(key)));
            }
        }
        return inversemap;
    }

    //@ensures (\forall K key;map.containsKey(key); (\result.get(map.get(key))==key));
    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V,K> newmap = new HashMap<>();
         if(!map.isEmpty()&&isOneOnOne(map)&&isSurjectiveOnRange(map,new HashSet<>(map.values()))){
             for (K key : map.keySet()){
                 newmap.put(map.get(key),key);
             }
         }
         return newmap;
    }
    //@ensures (\forall V value;f.containsValue(value)&&g.containsKey(value);f.values()==g.keySet());
    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        if(f.isEmpty()) {
            return true;
    }else {
            Set<V> setf = new HashSet<>(f.values());
            Set<V> setfsub = new HashSet<>(f.values());
            Set<V> setg = new HashSet<>(g.keySet());
            setf.removeAll(setg);
            setg.removeAll(setfsub);

            return setf.size()==setg.size();
        }

    }

    //@ensures (\forall K key;f.containsKey(key);\result.get(key)==g.get(f.get(key)));
    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        if (compatible(f, g)) {
            Map<K, W> newmap = new HashMap<>();

            for(K key: f.keySet()){
                for(V value:g.keySet()){
                    if(f.get(key).equals(value)){
                        newmap.put(key,g.get(value));
                    }
                }
            }
            return newmap;
        } else {
            return null;
        }
    }
}