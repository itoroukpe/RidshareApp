import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/ai")
public class AIOptimizationController {
    @Autowired private ExpenseRepository expenseRepo;
    @Autowired private IncomeRepository incomeRepo;
    @Autowired private AIOptimizationService aiService;

    @GetMapping("/recommendations/{userId}")
    public List<String> getTaxOptimizationTips(@PathVariable Long userId) {
        List<Income> incomes = incomeRepo.findByUserId(userId);
        List<Expense> expenses = expenseRepo.findByUserId(userId);
        return aiService.generateRecommendations(expenses, incomes);
    }
}
