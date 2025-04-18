import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/fleet")
public class FleetController {
    @Autowired private UserRepository userRepository;
    @Autowired private IncomeRepository incomeRepository;
    @Autowired private ExpenseRepository expenseRepository;

    @GetMapping("/drivers")
    public List<User> getFleetDrivers(@RequestParam String ownerEmail) {
        // For demo purposes: Fetch all drivers in the system
        return userRepository.findAll().stream()
                .filter(u -> u.getRole().equals("DRIVER"))
                .collect(Collectors.toList());
    }

    @GetMapping("/summary/{driverId}")
    public Map<String, Object> getDriverSummary(@PathVariable Long driverId) {
        List<Income> incomes = incomeRepository.findByUserId(driverId);
        List<Expense> expenses = expenseRepository.findByUserId(driverId);

        double totalIncome = incomes.stream().mapToDouble(Income::getAmount).sum();
        double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();
        double netProfit = totalIncome - totalExpenses;

        Map<String, Object> summary = new HashMap<>();
        summary.put("totalIncome", totalIncome);
        summary.put("totalExpenses", totalExpenses);
        summary.put("netProfit", netProfit);
        return summary;
    }
}
