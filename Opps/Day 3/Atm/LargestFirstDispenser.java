package Atm;
import java.util.*;
class LargestFirstDispenser implements DispenserStrategy {
    public Map<Integer, Integer> dispense(int amount, Map<Integer, Integer> availableNotes) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        List<Integer> sortedDenominations = new ArrayList<>(availableNotes.keySet());
        Collections.sort(sortedDenominations, Collections.reverseOrder());

        for (int denom : sortedDenominations) {
            int count = Math.min(amount / denom, availableNotes.get(denom));
            if (count > 0) {
                result.put(denom, count);
                amount -= denom * count;
            }
        }

        if (amount != 0) return null; // Cannot dispense requested amount
        return result;
    }
}