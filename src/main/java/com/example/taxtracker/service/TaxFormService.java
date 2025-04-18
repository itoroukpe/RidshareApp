@Service
public class TaxFormService {
    public byte[] generateScheduleC(User user, List<Income> incomes, List<Expense> expenses) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);

        doc.add(new Paragraph("Schedule C - Profit or Loss from Business").setBold().setFontSize(16));
        doc.add(new Paragraph("Name: " + user.getEmail()));
        doc.add(new Paragraph("Business Name: Rideshare Activities"));

        double totalIncome = incomes.stream().mapToDouble(Income::getAmount).sum();
        double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();

        doc.add(new Paragraph("Total Income: $" + totalIncome));
        doc.add(new Paragraph("Total Expenses: $" + totalExpenses));
        doc.add(new Paragraph("Net Profit: $" + (totalIncome - totalExpenses)));

        doc.close();
        return outputStream.toByteArray();
    }
}
