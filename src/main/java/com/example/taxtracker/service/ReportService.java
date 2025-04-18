import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class ReportService {
    public byte[] generateTaxReport(User user, List<Income> incomes, List<Expense> expenses) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Tax Summary Report").setBold().setFontSize(18));
        document.add(new Paragraph("User: " + user.getEmail()));

        double totalIncome = incomes.stream().mapToDouble(Income::getAmount).sum();
        double totalExpenses = expenses.stream().mapToDouble(Expense::getAmount).sum();
        double netProfit = totalIncome - totalExpenses;

        document.add(new Paragraph("Total Income: $" + totalIncome));
        document.add(new Paragraph("Total Expenses: $" + totalExpenses));
        document.add(new Paragraph("Net Profit: $" + netProfit));

        document.add(new Paragraph("\n--- Income Details ---"));
        for (Income i : incomes) {
            document.add(new Paragraph(i.getDate() + " - " + i.getSource() + ": $" + i.getAmount()));
        }

        document.add(new Paragraph("\n--- Expense Details ---"));
        for (Expense e : expenses) {
            document.add(new Paragraph(e.getDate() + " - " + e.getCategory() + ": $" + e.getAmount()));
        }

        document.close();
        return outputStream.toByteArray();
    }
}
