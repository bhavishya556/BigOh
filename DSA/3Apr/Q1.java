import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        String str1 = "AB";
        String str2 = "CD";

      //  get all pairs
        ArrayList<String> allPairs = findAllPairs(str1 + str2);

        ArrayList<String> validInterleavings = filterValidInterleavings(allPairs, str1, str2);

       //print
        for (String pair : validInterleavings) {
            System.out.println(pair);
        }
        System.out.println("Total Valid Interleavings: " + validInterleavings.size());
    // System.out.println(isValidInterleaving("BACDEFGH",str1,str2));
    }

    public static ArrayList<String> findAllPairs(String str) {
        ArrayList<String> result = new ArrayList<>();
        generatePermutations(str, "", result);
        return result;
    }

    private static void generatePermutations(String str, String current, ArrayList<String> result) {
        if (str.isEmpty()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            generatePermutations(str.substring(0, i) + str.substring(i + 1), current + str.charAt(i), result);
        }
    }

    public static ArrayList<String> filterValidInterleavings(ArrayList<String> list, String str1, String str2) {
        ArrayList<String> filteredList = new ArrayList<>();

        for (String s : list) {
            if (isValidInterleaving(s, str1, str2)) {
                filteredList.add(s);
            }
        }
        return filteredList;
    }

    private static boolean isValidInterleaving(String s, String s1, String s2) {
        int index1 = 0, index2 = 0;
    
        for (char c : s.toCharArray()) {
            if (index1 < s1.length() && c == s1.charAt(index1)) {
                index1++; 
            } else if (index2 < s2.length() && c == s2.charAt(index2)) {
                index2++; 
            } else {
                return false;  
            }
        }
        return index1 == s1.length() && index2 == s2.length();
    }
    
}
