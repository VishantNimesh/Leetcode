class Solution {
    public boolean isvowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch =='o' || ch == 'u') return true;
        return false;
    }
    public String sortVowels(String s) {
        ArrayList<Character> arr= new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(isvowel(ch)) arr.add(ch);
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(!isvowel(ch)) sb.append(ch);
            else sb.append(arr.removeFirst());
        }
        return sb.toString();
    }
}