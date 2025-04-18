@Service
public class Form1099Service {
    public byte[] generate1099Form(User user, List<Income> incomes) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document doc = new Document(pdf);

        doc.add(new Paragraph("Form 1099-NEC").setBold().setFontSize(16));
        doc.add(new Paragraph("Payer: Rideshare Platform"));
        doc.add(new Paragraph("Recipient: " + user.getEmail()));

        double total = incomes.stream().mapToDouble(Income::getAmount).sum();
        doc.add(new Paragraph("Nonemployee compensation: $" + total));

        doc.close();
        return outputStream.toByteArray();
    }
}
