document.addEventListener('DOMContentLoaded', function() {
    // добавляем event listener кнопке "Add a task"
    document.querySelector('.btnAddTask').addEventListener('click', addTask);
});

function addTask() {
    // извлекаю task input и selected category
    var taskInput = document.getElementById('task-input').value;
    var selectedCategory = document.getElementById('selectedImportance').value;

    // проверяем если task input пустой
    if (taskInput.trim() === "") {
        alert("Please enter a task.");
        return;
    }

    // создаем task element
    var taskElement = document.createElement('li');
    taskElement.textContent = taskInput;

    // добавляем задачу в нужный квадрант
    var quadrantTasks = document.getElementById(selectedCategory + 'Tasks');
    quadrantTasks.appendChild(taskElement);

    // очищаем поле ввода задачи (task input field)
    document.getElementById('task-input').value = '';
}