const API_URL = "http://localhost:9090/expenses";

function saveExpense() {
    let id = document.getElementById("expenseId").value;
    let title = document.getElementById("title").value;
    let category = document.getElementById("category").value;
    let amount = document.getElementById("amount").value;

    let data = { title, category, amount };

    if (id === "") {
        // CREATE
        fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data)
        }).then(loadExpenses);

    } else {
        // UPDATE
        fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(data)
        }).then(() => {
            document.getElementById("expenseId").value = "";
            loadExpenses();
        });
    }

    clearForm();
}

function loadExpenses() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            let list = document.getElementById("expenseList");
            list.innerHTML = "";
            data.forEach(exp => {
                let li = document.createElement("li");
                li.innerHTML = `
                    ${exp.id} | ${exp.title} | ${exp.category} | ₹${exp.amount}
                    <button class="action-btn" onclick="editExpense(${exp.id},'${exp.title}','${exp.category}',${exp.amount})">Edit</button>
                    <button class="delete-btn" onclick="deleteExpense(${exp.id})">Delete</button>
                `;
                list.appendChild(li);
            });
        });
}

function editExpense(id, title, category, amount) {
    document.getElementById("expenseId").value = id;
    document.getElementById("title").value = title;
    document.getElementById("category").value = category;
    document.getElementById("amount").value = amount;
}

function deleteExpense(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    }).then(loadExpenses);
}

function clearForm() {
    document.getElementById("title").value = "";
    document.getElementById("category").value = "";
    document.getElementById("amount").value = "";
}
S