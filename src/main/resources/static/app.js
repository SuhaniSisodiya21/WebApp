// Projects
fetch('/api/projects')
.then(res => res.json())
.then(data => {
    const container = document.getElementById('projectsContainer');
    data.forEach(p => {
        container.innerHTML += `
            <div class="card">
                <img src="${p.imageUrl}">
                <h3>${p.name}</h3>
                <p>${p.description}</p>
            </div>`;
    });
});

// Clients
fetch('/api/clients')
.then(res => res.json())
.then(data => {
    const container = document.getElementById('clientsContainer');
    data.forEach(c => {
        container.innerHTML += `
            <div class="card">
                <img src="${c.imageUrl}">
                <h3>${c.name}</h3>
                <p>${c.description}</p>
                <small>${c.designation}</small>
            </div>`;
    });
});

// Contact
document.getElementById('contactForm').addEventListener('submit', e => {
    e.preventDefault();

    fetch('/api/contact', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            fullName: fullName.value,
            email: email.value,
            mobile: mobile.value,
            city: city.value
        })
    })
    .then(res => res.text())
    .then(alert);
});

// Subscribe
function subscribe() {
    fetch('/api/subscribe', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({ email: subEmail.value })
    })
    .then(res => res.text())
    .then(alert);
}
