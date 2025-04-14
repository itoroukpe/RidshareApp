// --- IncomeController.java ---
@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired private IncomeRepository incomeRepo;

    @PostMapping("/add")
    public Income addIncome(@RequestBody Income income) {
        return incomeRepo.save(income);
    }

    @GetMapping("/user/{userId}")
    public List<Income> getUserIncome(@PathVariable Long userId) {
        return incomeRepo.findByUserId(userId);
    }
}
