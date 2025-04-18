// ===== DOM-Ready Initialization =====
document.addEventListener('DOMContentLoaded', () => {
  const registerForm = document.getElementById('registerForm');
  if (registerForm) {
    registerForm.addEventListener('submit', async function (e) {
      e.preventDefault();
      const formData = new FormData(e.target);
      const user = Object.fromEntries(formData);

      const response = await fetch('/api/profile/setup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user)
      });

      const result = await response.json();
      alert('User registered: ' + result.email);
    });
  }

  const expenseForm = document.getElementById('expenseForm');
  if (expenseForm) {
    expenseForm.addEventListener('submit', async function (e) {
      e.preventDefault();
      const formData = new FormData(e.target);
      const expense = Object.fromEntries(formData);
      expense.user = { id: 1 }; // Simulated user ID

      const res = await fetch('/api/expense/add', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(expense)
      });

      const saved = await res.json();
      alert('Expense added: $' + saved.amount);
      e.target.reset();
      loadExpenses();
    });
  }

  if (document.getElementById('expenseList')) {
    loadExpenses();
  }

  if (document.getElementById('driverList')) {
    loadDrivers();
  }
});

// ===== Load Expenses =====
async function loadExpenses() {
  const res = await fetch('/api/expense/user/1');
  const expenses = await res.json();
  const list = document.getElementById('expenseList');
  if (!list) return;

  list.innerHTML = '';
  expenses.forEach(exp => {
    const li = document.createElement('li');
    li.textContent = `${exp.category}: $${exp.amount} - ${exp.description}`;
    list.appendChild(li);
  });
}

// ===== Fleet Dashboard =====
async function loadDrivers() {
  const res = await fetch('/api/fleet/drivers?ownerEmail=owner@example.com');
  const drivers = await res.json();
  const list = document.getElementById('driverList');
  if (!list) return;

  list.innerHTML = '';
  drivers.forEach(driver => {
    const li = document.createElement('li');
    li.textContent = `${driver.email} (${driver.id})`;
    li.onclick = () => loadDriverSummary(driver.id);
    list.appendChild(li);
  });
}

async function loadDriverSummary(driverId) {
  const res = await fetch(`/api/fleet/summary/${driverId}`);
  const summary = await res.json();
  const view = document.getElementById('driverSummary');
  if (!view) return;

  view.innerHTML = `
    <p>Total Income: $${summary.totalIncome}</p>
    <p>Total Expenses: $${summary.totalExpenses}</p>
    <p>Net Profit: $${summary.netProfit}</p>
  `;
}

// ===== IRS Forms Download =====
function downloadScheduleC() {
  window.open('/api/forms/schedule-c/1', '_blank');
}

function download1099() {
  window.open('/api/forms/1099/1', '_blank');
}

// ===== Stripe Subscription Checkout =====
function subscribeNow() {
  fetch('/api/subscription/checkout')
    .then(res => res.json())
    .then(data => {
      window.location.href = data.url;
    })
    .catch(err => {
      alert('Error starting subscription checkout.');
      console.error('Subscription error:', err);
    });
}

// ===== AI Tax Optimization Tips =====
function loadAITips() {
  const list = document.getElementById('aiTips');
  if (!list) return;

  list.innerHTML = '<li>Loading tips...</li>';

  fetch('/api/ai/recommendations/1')
    .then(res => res.json())
    .then(tips => {
      list.innerHTML = '';
      tips.forEach(tip => {
        const li = document.createElement('li');
        li.textContent = tip;
        list.appendChild(li);
      });
    })
    .catch(err => {
      list.innerHTML = '<li style="color:red;">Failed to load AI tips.</li>';
      console.error('Failed to load AI tips:', err);
    });
}

// ===== AI Chatbot Widget =====
function sendChatMessage(msg) {
  const reply = aiBot(msg);
  const chatBox = document.getElementById('chatBox');
  const userLine = document.createElement('p');
  userLine.textContent = '👤 ' + msg;
  const botLine = document.createElement('p');
  botLine.textContent = '🤖 ' + reply;
  chatBox.append(userLine, botLine);
}

function aiBot(message) {
  message = message.toLowerCase();
  if (message.includes('deduction')) return 'Track your expenses daily to maximize deductions!';
  if (message.includes('mileage')) return 'Use GPS-based tracking for accurate mileage logs.';
  return 'How can I assist with your tax needs today?';
}

function downloadScheduleC() {
  window.open('/api/forms/schedule-c/1', '_blank');
}

function download1099() {
  window.open('/api/forms/1099/1', '_blank');
}

