class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            /** putIfAbsent
             * 키가 존재하지 않는 경우 생성한 값을 삽입한다.
             * (키가 이미 존재하더라도 객체는 생성되고 사용되지 않고 GC에 의해 처리된다.)
             */

            // map.putIfAbsent(key, new ArrayList<>());
            // map.get(key).add(str);

            /** computeIfAbsent
             * putIfAbsent와 유사하나 가장 큰 차이점은 키가 존재할 때 람다식 자체가 실행되지 않아 불필요한 객체 생성 작업이 발생하지 않는다.
             */
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
