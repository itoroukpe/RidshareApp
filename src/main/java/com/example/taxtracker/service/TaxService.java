import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


// --- TaxService.java ---
@Service
public class TaxService {
    public double estimateQuarterlyTax(List<Income> incomes, List<Expense> expenses) {
        double totalIncome = incomes.stream().mapToDouble(Income::getAmount).sum();
        double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();
        return (totalIncome - totalExpenses) * 0.25; // example rate
    }

    public List<String> suggestDeductions(User user) {
        return List.of("Fuel", "Repairs", "Insurance", "Tolls");
    }
}
