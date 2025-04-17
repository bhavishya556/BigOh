package Atm;
public class ATM {
    public static void main(String[] args) {
        NoteManager noteManager = new NoteManager(new LargestFirstDispenser());

        // Initial denominations
        noteManager.addDenomination(100);
        noteManager.addDenomination(200);
        noteManager.addDenomination(500);
        noteManager.addDenomination(2000);
        noteManager.addDenomination(5000);

        // Top up
        noteManager.topUp(2000, 2); // ₹40,000
        noteManager.topUp(500, 2);   // ₹1000
        noteManager.topUp(5000, 1);   // ₹1000
        noteManager.showBalance();

        // Withdraw test cases
        noteManager.withdraw(2500); // Should use ₹2000 x 1 + ₹200 x 1 + ₹100 x 1
        noteManager.showBalance();

        // Test demonetization
        // noteManager.demonetize(2000);
        // noteManager.addDenomination(5000);
        // noteManager.topUp(5000, 10); // Add new currency
        // noteManager.withdraw(10000); // Should use ₹5000 x 2
        // noteManager.showBalance();
    }
}
