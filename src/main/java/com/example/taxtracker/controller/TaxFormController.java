@RestController
@RequestMapping("/api/forms")
public class TaxFormController {
    @Autowired private UserRepository userRepo;
    @Autowired private IncomeRepository incomeRepo;
    @Autowired private ExpenseRepository expenseRepo;
    @Autowired private TaxFormService taxFormService;

    @GetMapping("/schedule-c/{userId}")
    public ResponseEntity<byte[]> downloadScheduleC(@PathVariable Long userId) throws IOException {
        User user = userRepo.findById(userId).orElseThrow();
        List<Income> incomes = incomeRepo.findByUserId(userId);
        List<Expense> expenses = expenseRepo.findByUserId(userId);
        byte[] pdf = taxFormService.generateScheduleC(user, incomes, expenses);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("schedule-c.pdf").build());

        return ResponseEntity.ok().headers(headers).body(pdf);
    }
}
