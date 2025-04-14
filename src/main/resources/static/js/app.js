// --- app.js (expense tracking logic added) ---

document.getElementById('expenseForm').addEventListener('submit', async function(e) {
  e.preventDefault();
  const formData = new FormData(e.target);
  const expense = Object.fromEntries(formData);
  expense.user = { id: 1 }; // assuming user is logged in with id 1

  const res = await fetch('/api/expense/add', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(expense)
  });

  const saved = await res.json();
  alert('Expense added: $' + saved.amount);
  e.target.reset();
  loadExpenses();
});

async function loadExpenses() {
  const res = await fetch('/api/expense/user/1');
  const expenses = await res.json();
  const list = document.getElementById('expenseList');
  list.innerHTML = '';
  expenses.forEach(exp => {
    const li = document.createElement('li');
    li.textContent = `${exp.category}: $${exp.amount} - ${exp.description}`;
    list.appendChild(li);
  });
}

window.onload = loadExpenses;
