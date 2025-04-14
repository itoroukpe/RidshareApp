@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @Autowired private ExpenseRepository expenseRepo;

    @PostMapping("/add")
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseRepo.save(expense);
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getUserExpenses(@PathVariable Long userId) {
        return expenseRepo.findByUserId(userId);
    }
}
