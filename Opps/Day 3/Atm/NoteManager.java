package Atm;

import java.util.*;

class NoteManager {
    private final Map<Integer, Integer> notes = new HashMap<>();
    private final DispenserStrategy dispenser;

    public NoteManager(DispenserStrategy dispenser) {
        this.dispenser = dispenser;
    }

    public void addDenomination(int denomination) {
        notes.putIfAbsent(denomination, 0);
    }

    public void topUp(int denomination, int count) {
        notes.put(denomination, notes.getOrDefault(denomination, 0) + count);
    }

    public void withdraw(int amount) {
        int total = getTotalAmount();
        if (amount > total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        if (!isAmountValid(amount)) {
            System.out.println("Error: Amount must be a multiple of available denominations.");
            return;
        }

        Map<Integer, Integer> result = dispenser.dispense(amount, notes);
        if (result == null) {
            System.out.println("Error: Cannot dispense requested amount with available notes.");
            return;
        }

        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            notes.put(entry.getKey(), notes.get(entry.getKey()) - entry.getValue());
        }

        System.out.println("withdraw:");
        result.forEach((k, v) -> System.out.println("₹" + k + " x " + v));
    }

    public void showBalance() {
        System.out.println("ATM Balance:");
        notes.forEach((k, v) -> System.out.println("₹" + k + " x " + v));
        System.out.println("Total: ₹" + getTotalAmount());
    }

    private int getTotalAmount() {
        return notes.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();
    }

    private boolean isAmountValid(int amount) {
        return notes.keySet().stream().anyMatch(d -> amount % d == 0 || amount >= d);
    }

    public void demonetize(int denomination) {
        notes.remove(denomination);
        System.out.println(" ₹" + denomination + " notes removed from circulation.");
    }
}