document.addEventListener('DOMContentLoaded', function() {
    // добавляем event listener кнопке "Add a task"
    document.querySelector('.btnAddTask').addEventListener('click', addTask);
});

<<<<<<< HEAD
const joke = document.querySelector('.joke__text');
const jokeBtn = document.querySelector('.btnGetJoke');
const affirmation = document.querySelector('.affirmation__text');
const affirmationBtn = document.querySelector('.btnGetAffirmation');

function jokeApiReq () {
    fetch("https://v2.jokeapi.dev/joke/Miscellaneous?blacklistFlags=religious,political,racist", {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => response.json())
    .then(data => {   
        joke.textContent = data.joke;
    })
    .catch(error => {
        console.error(error);
        joke.textContent = `Server is not responding: ${error.message}`;
    });
    }
    
    
    function affirmationApiReq () {
        fetch("https://type.fit/api/quotes", {
        method: "GET",
        headers: {
            "Accept": "application/json"
        }
    })
    .then(response => response.json())
    .then(data => {   
        const randomIndex = Math.floor(Math.random() * data.length);
        const randomQuote = data[randomIndex].text;
        affirmation.textContent = randomQuote;
    })
    .catch(error => {
        console.error(error);
        affirmation.textContent = `Server is not responding: ${error.message}`;
    });
    }
    
    jokeBtn.addEventListener('click', event => {
        event.preventDefault();
        jokeApiReq();
    })
    
=======
>>>>>>> branch1
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
<<<<<<< HEAD
    

    affirmationBtn.addEventListener('click', event => {
        event.preventDefault();
        affirmationApiReq();
    })
=======

>>>>>>> branch1
    // очищаем поле ввода задачи (task input field)
    document.getElementById('task-input').value = '';
}