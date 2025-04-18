@Service
public class AIOptimizationService {
    public List<String> generateRecommendations(List<Expense> expenses, List<Income> incomes) {
        double incomeTotal = incomes.stream().mapToDouble(Income::getAmount).sum();
        double fuel = expenses.stream().filter(e -> e.getCategory().equalsIgnoreCase("fuel")).mapToDouble(Expense::getAmount).sum();
        double insurance = expenses.stream().filter(e -> e.getCategory().equalsIgnoreCase("insurance")).mapToDouble(Expense::getAmount).sum();

        List<String> recommendations = new ArrayList<>();
        if (fuel / incomeTotal > 0.3) {
            recommendations.add("Consider optimizing routes or using a more fuel-efficient vehicle.");
        }
        if (insurance / incomeTotal > 0.2) {
            recommendations.add("Explore options for lower insurance rates.");
        }
        recommendations.add("Keep consistent records for faster tax filing.");
        return recommendations;
    }
}
