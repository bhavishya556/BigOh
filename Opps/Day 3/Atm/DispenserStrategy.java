package Atm;
import java.util.Map;
interface DispenserStrategy {
    Map<Integer, Integer> dispense(int amount, Map<Integer, Integer> availableNotes);
}