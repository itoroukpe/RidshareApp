import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.taxtracker.model.User;
import com.example.taxtracker.model.Income;
import com.example.taxtracker.model.Expense;



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
