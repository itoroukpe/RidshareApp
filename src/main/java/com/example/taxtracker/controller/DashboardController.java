@GetMapping("/dashboard")
public String showDashboard(HttpSession session, Model model) {
    model.addAttribute("userEmail", session.getAttribute("userEmail"));
    model.addAttribute("premium", session.getAttribute("premium"));
    return "dashboard";
}
