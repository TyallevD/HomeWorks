//запрос количества коробок у пользователя
let numBoxes;
while (true) {
    numBoxes = prompt("Введите количество контейнеров от 5 до 1000");
    if (numBoxes == null) {
        alert("Ввод отменён");
        break;
    }
    if (!isNaN(Number(numBoxes))) {
        if (numBoxes < 5) {
            numBoxes = 5;
        } else if (numBoxes > 1000) {
            numBoxes = 1000;
        }
        break;
    }
}
//добавление в статус стартового значения коробок
let status = document.querySelector('.status');
status.innerText = 'Осталось коробок: ' + numBoxes;

//запрос таймера у пользователя
let timerInput;
let timerValue;
while (true) {
    timerInput = prompt(`Введите время игры:
        1 = 1 min
        2 = 2 min
        3 = 5 min
        4 = 10 min`);
    if (timerInput == null) {
        alert("Ввод отменён");
        break;
    }
    switch (timerInput) {
        case '1':
            timerValue = 60 * 1000;
            break;
        case '2':
            timerValue = 2 * 60 * 1000;
            break;
        case '3':
            timerValue = 5 * 60 * 1000;
            break;
        case '4':
            timerValue = 10 * 60 * 1000;
            break;
    }
    if (timerInput == '1' || timerInput == '2' || timerInput == '3' || timerInput == '4') {
        break;
    }
}

//добавление события для удаления коробок при клике 
let container = document.querySelector('.container');
container.addEventListener('mousedown', boxClickRemove);

//создание коробок после старта
for (let i = 1; i <= numBoxes; i++) {
    let box = document.createElement('div');
    box.className = 'box';
    box.style.backgroundColor = randomColor();
    box.innerText = parseInt(i);

    //добавление на экран
    container.appendChild(box);

    //определение позиции
    let position = randomPosition(box);
    box.style.top = position.top + 'px';
    box.style.left = position.left + 'px';
    box.dataset.direction = randomDirection();
}

//добавление таймера
let timer = document.querySelector('.timer');
timer.innerText = 'Времени осталось: ' + beautifulTimer(timerValue);

//запуск игрового времени
gameTime = setInterval(() => {
    timerValue -= 1000;
    timer.innerText = 'Времени осталось: ' + beautifulTimer(timerValue);
    //если пользователь ничего не ввёл - остановка игры, появление кнопки перезапуска
    if (numBoxes==null || timerValue==NaN){
        clearInterval(gameTime);
        clearInterval(boxMove);
        container.removeEventListener('mousedown', boxClickRemove);
        createReloadButton();
    }
    //если пользователь успел уничтожить все коробки - победа, остановка игры и появление кнопки перезапуска
    if (numBoxes == 0) {
        status.innerText = 'Победа!'
        clearInterval(gameTime);
        clearInterval(boxMove);
        container.removeEventListener('mousedown', boxClickRemove);
        createReloadButton();
    }
    //если пользователь не успел уничтожить все коробки - поражение, остановка игры и появление кнопки перезапуска
    if (timerValue == 0) {
        status.innerText = 'Поражение! Осталось коробок: ' + numBoxes;
        clearInterval(gameTime);
        clearInterval(boxMove);
        container.removeEventListener('mousedown', boxClickRemove);
        createReloadButton();
    }
}, 1 * 1000);

//движение коробок
let boxSpeed = 4; // скорость в пикселях
boxMove = setInterval(() => {
    moveBoxes();
}, 30);

//функция удаления коробок при нажатии
function boxClickRemove(event) {
    if (event.target.className == 'box') {
        event.target.remove();
        numBoxes--;
        status.innerText = 'Осталось коробок: ' + numBoxes;
    }
};

//функция задания рандомного цвета для коробок
function randomColor() {
    let r = Math.floor(Math.random() * 256);
    let g = Math.floor(Math.random() * 256);
    let b = Math.floor(Math.random() * 256);
    return `rgb(${r}, ${g}, ${b})`
}

//функция форматирования таймера
function beautifulTimer(timerValue) {
    let minutes = Math.floor(timerValue / 60000);
    let seconds = Math.floor((timerValue % 60000) / 1000);
    let secondsFormat = seconds < 10 ? '0' + seconds : seconds;
    return minutes + ":" + secondsFormat;
}

//функциоя c определением случайного направления движения
function randomDirection() {
    let directions = ['upright', 'downright', 'upleft', 'downleft'];
    return directions[Math.floor(Math.random() * directions.length)];
}

//функция определения случайного положения коробок
function randomPosition(box) {
    let container = document.querySelector('.container');

    let containerWidth = container.clientWidth;
    let containerHeight = container.clientHeight;

    let boxtWidth = box.offsetWidth;
    let boxHeight = box.offsetHeight;

    let randomX = Math.floor(Math.random() * (containerWidth - boxtWidth));
    let randomY = Math.floor(Math.random() * (containerHeight - boxHeight));

    return { top: randomY, left: randomX };
}

//функция движения коробок
function moveBoxes() {
    document.querySelectorAll('.box').forEach(box => {
        let X = parseInt(box.style.left);
        let Y = parseInt(box.style.top);

        let direction = box.dataset.direction;

        //определение направления
        switch (direction) {
            case 'upright':
                X += boxSpeed;
                Y -= boxSpeed;
                break;
            case 'upleft':
                X -= boxSpeed;
                Y -= boxSpeed;
                break;
            case 'downright':
                X += boxSpeed;
                Y += boxSpeed;
                break;
            case 'downleft':
                X -= boxSpeed;
                Y += boxSpeed;
                break;
        }

        let boxRect = box.getBoundingClientRect();
        let boxWidth = boxRect.width;
        let boxHeight = boxRect.height;

        //Движение по оси X с изменением направлений
        if (X < 0 && box.dataset.direction == 'upleft') {
            X = 0;
            box.dataset.direction = 'upright';
        } else if (X < 0 && box.dataset.direction == 'downleft') {
            X = 0;
            box.dataset.direction = 'downright';
        }
        else if (X + boxWidth > window.innerWidth && box.dataset.direction == 'upright') {
            X = window.innerWidth - boxWidth;
            box.dataset.direction = 'upleft';
        }
        else if (X + boxWidth > window.innerWidth && box.dataset.direction == 'downright') {
            X = window.innerWidth - boxWidth;
            box.dataset.direction = 'downleft';
        }

        //Движение по оси Y с изменением направлений
        if (Y < 0 && box.dataset.direction == 'upright') {
            Y = 0;
            box.dataset.direction = 'downright';
        } else if (Y < 0 && box.dataset.direction == 'upleft') {
            Y = 0;
            box.dataset.direction = 'downleft';
        }
        else if (Y + boxHeight + 110 > window.innerHeight && box.dataset.direction == 'downright') {
            Y = window.innerHeight - boxHeight - 110;
            box.dataset.direction = 'upright';
        } else if (Y + boxHeight + 110 > window.innerHeight && box.dataset.direction == 'downleft') {
            Y = window.innerHeight - boxHeight - 110;
            box.dataset.direction = 'upleft';
        }

        //движение по X и Y
        box.style.left = `${X}px`;
        box.style.top = `${Y}px`;
    });
}

//кнопка рестарта
function createReloadButton() {
    let reloadButton = document.createElement('button');
    reloadButton.tagName = 'button';
    reloadButton.innerText = "Начать заново";
    container.appendChild(reloadButton);

    reloadButton.addEventListener('click', () => {
        location.reload();
    });
}