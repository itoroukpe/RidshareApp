@RestController
@RequestMapping("/api/report")
public class ReportController {
    @Autowired private UserRepository userRepo;
    @Autowired private IncomeRepository incomeRepo;
    @Autowired private ExpenseRepository expenseRepo;
    @Autowired private ReportService reportService;

    @GetMapping("/pdf/{userId}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long userId) throws IOException {
        User user = userRepo.findById(userId).orElseThrow();
        List<Income> incomes = incomeRepo.findByUserId(userId);
        List<Expense> expenses = expenseRepo.findByUserId(userId);

        byte[] pdf = reportService.generateTaxReport(user, incomes, expenses);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("tax-report.pdf").build());

        return ResponseEntity.ok().headers(headers).body(pdf);
    }
}
