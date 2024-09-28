document.addEventListener('DOMContentLoaded', function () {
    loadTasks();
    setMinDate();
});

document.getElementById('add-btn').addEventListener('click', addTask);

function setMinDate() {
    const today = new Date().toISOString().split('T')[0]; // Get today's date in YYYY-MM-DD format
    document.getElementById('date-input').setAttribute('min', today); // Set as minimum date for input
}

function addTask() {
    const todoInput = document.getElementById('todo-input');
    const dateInput = document.getElementById('date-input');
    const startTimeInput = document.getElementById('start-time-input');
    const endTimeInput = document.getElementById('end-time-input');
    
    const todoText = todoInput.value.trim();
    const todoDate = dateInput.value;
    const startTime = startTimeInput.value;
    const endTime = endTimeInput.value;

    if (todoText === '' || todoDate === '' || startTime === '' || endTime === '') {
        alert("Please fill in all fields: task, date, start time, and end time.");
        return;
    }

    const today = new Date().toISOString().split('T')[0];
    if (todoDate < today) {
        alert("The selected date is in the past. Please choose a valid date.");
        return;
    }

    if (startTime >= endTime) {
        alert("The end time must be later than the start time.");
        return;
    }

    const todoList = document.getElementById('todo-list');
    const li = document.createElement('li');
    li.textContent = todoText;

    const dateDisplay = document.createElement('span');
    dateDisplay.className = 'date-display';
    dateDisplay.textContent = ` (Due: ${todoDate} from ${startTime} to ${endTime})`;
    li.appendChild(dateDisplay);

    addTaskButtons(li);
    todoList.appendChild(li);

    // Clear input fields
    todoInput.value = '';
    dateInput.value = '';
    startTimeInput.value = '';
    endTimeInput.value = '';

    saveTasks();
}

function addTaskButtons(li) {
    const editBtn = document.createElement('button');
    editBtn.innerHTML = '<i class="fas fa-edit"></i>';
    editBtn.classList.add('edit-btn');
    editBtn.onclick = function () {
        editTask(li);
    };

    const completeBtn = document.createElement('button');
    completeBtn.innerHTML = '<i class="fas fa-check"></i>';
    completeBtn.classList.add('complete-btn');
    completeBtn.onclick = function () {
        toggleCompleteTask(li);
    };

    const deleteBtn = document.createElement('button');
    deleteBtn.innerHTML = '<i class="fas fa-trash-alt"></i>';
    deleteBtn.classList.add('delete-btn');
    deleteBtn.onclick = function () {
        li.remove();
        saveTasks();
    };

    li.appendChild(editBtn);
    li.appendChild(completeBtn);
    li.appendChild(deleteBtn);
}

function editTask(li) {
    const todoText = prompt("Edit your task:", li.firstChild.textContent);
    const newDate = prompt("Edit the date (YYYY-MM-DD):", li.querySelector('.date-display').textContent.split(' ')[1]);
    const newStartTime = prompt("Edit the start time (HH:MM):", li.querySelector('.date-display').textContent.split(' ')[3].split('to')[0].trim());
    const newEndTime = prompt("Edit the end time (HH:MM):", li.querySelector('.date-display').textContent.split(' ')[3].split('to')[1].trim());

    if (todoText !== null && newDate !== null && newStartTime !== null && newEndTime !== null) {
        li.firstChild.textContent = todoText;
        li.querySelector('.date-display').textContent = ` (Due: ${newDate} from ${newStartTime} to ${newEndTime})`;
        saveTasks();
    }
}

function toggleCompleteTask(li) {
    li.classList.toggle('completed');
    saveTasks();
}

function saveTasks() {
    const tasks = [];
    document.querySelectorAll('#todo-list li').forEach(task => {
        tasks.push({
            text: task.firstChild.textContent,
            date: task.querySelector('.date-display').textContent.split(' ')[1],
            startTime: task.querySelector('.date-display').textContent.split(' ')[3].split('to')[0].trim(),
            endTime: task.querySelector('.date-display').textContent.split(' ')[3].split('to')[1].trim(),
            completed: task.classList.contains('completed')
        });
    });
    localStorage.setItem('tasks', JSON.stringify(tasks));
}

function loadTasks() {
    const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
    tasks.forEach(task => {
        const li = document.createElement('li');
        li.textContent = task.text;

        const dateDisplay = document.createElement('span');
        dateDisplay.className = 'date-display';
        dateDisplay.textContent = ` (Due: ${task.date} from ${task.startTime} to ${task.endTime})`;
        li.appendChild(dateDisplay);

        if (task.completed) {
            li.classList.add('completed');
        }

        addTaskButtons(li);
        document.getElementById('todo-list').appendChild(li);
    });
}
