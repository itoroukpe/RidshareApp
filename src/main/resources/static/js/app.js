// --- app.js ---
document.getElementById('registerForm').addEventListener('submit', async function(e) {
  e.preventDefault();
  const formData = new FormData(e.target);
  const user = Object.fromEntries(formData);

  const response = await fetch('/api/profile/setup', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(user)
  });
  const result = await response.json();
  alert('User registered: ' + result.email);
});
