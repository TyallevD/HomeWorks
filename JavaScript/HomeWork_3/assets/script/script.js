/*
1) при старте запрашивается количество коробок +
2) при старте запрашивается время на игру +
3) на экране создается то количество коробок, что ввел пользователь (минимум 5, максимум 1000):
- коробки с разным номером (от 1 до введенного количества) +
- коробки с разным цветом +
- коробки двигаются "хаотично" -
4) расcчитывается время на выполнения +-
5) после старта начинается обратный отсчет:
 - если пользователь успел уничтожить все коробки - время останавливается, отображается статус "победа" +-
 - если пользователь не успел уничтожить все коробки - время останавливается, коробки останавливаются, отображается статус "поражение" +-
*/

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
container.addEventListener('click', boxClickRemove);

//создание коробок после старта
for (let i = 1; i <= numBoxes; i++) {
    let box = document.createElement('div');
    box.className = 'box';
    box.style.backgroundColor = randomColor();
    box.innerText = parseInt(i);

    //todo создать рандомное появление на экране
    container.appendChild(box);

    let position = randomPosition(box);
    box.style.top = position.top + 'px';
    box.style.left = position.left + 'px';
}

//добавление таймера
let timer = document.querySelector('.timer');
timer.innerText = 'Времени осталось: ' + beautifulTimer(timerValue);

//запуск игрового времени
gameTime = setInterval(() => {
    timerValue -= 10000; //todo пока ускорение нужно значение 1000
    timer.innerText = 'Времени осталось: ' + beautifulTimer(timerValue);
    if (numBoxes == 0) {
        status.innerText = 'Победа!'
        clearInterval(gameTime);
        // clearInterval(boxMove);
        container.removeEventListener('click', boxClickRemove);
    }
    if (timerValue == 0) {
        status.innerText = 'Поражение! Осталось коробок: ' + numBoxes;
        clearInterval(gameTime);
        // clearInterval(boxMove);
        container.removeEventListener('click', boxClickRemove);
    }
}, 1 * 1000);

//движение коробок
let boxSpeed = 30; // скорость в пикселях за шаг
// boxMove = setInterval(moveBoxes(), 30);

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

function beautifulTimer(timerValue) {
    let minutes = Math.floor(timerValue / 60000);
    let seconds = Math.floor((timerValue % 60000) / 1000);
    let secondsFormat = seconds < 10 ? '0' + seconds : seconds;
    return minutes + ":" + secondsFormat;
}

function randomDirection() {
    let directions = ['down', 'up', 'left', 'right'];
    return directions[Math.floor(Math.random() * directions.length)];
}

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
//осталось прописать:
//движени в рамках .container


// function moveBoxes() {
//     let containerRect = container.getBoundingClientRect();

//     document.querySelectorAll('.box').forEach(box => {
//         let posX = parseInt(box.style.left);
//         let posY = parseInt(box.style.top);

//         // Получаем или создаём направление для кубика
//         if (!box.dataset.direction) {
//             box.dataset.direction = randomDirection();
//         }

//         let direction = box.dataset.direction;
//         console.log(direction);

//         // Обновляем координаты в зависимости от направления
//         switch (direction) {
//             case 'up':
//                 posY -= boxSpeed;
//                 break;
//             case 'down':
//                 posY += boxSpeed;
//                 break;
//             case 'left':
//                 posX -= boxSpeed;
//                 break;
//             case 'right':
//                 posX += boxSpeed;
//                 break;
//         }

//         // Проверяем выход за границы и меняем направление при столкновении
//         let boxRect = box.getBoundingClientRect();
//         let boxWidth = boxRect.width;
//         let boxHeight = boxRect.height;

//         if (posX < 0) {
//             posX = 0;
//             box.dataset.direction = 'right';
//         } else if (posX + boxWidth > window.innerWidth) {
//             posX = window.innerWidth - boxWidth;
//             box.dataset.direction = 'left';
//         }

//         if (posY < 0) {
//             posY = 0;
//             box.dataset.direction = 'down';
//         } else if (posY + boxHeight > window.innerHeight) {
//             posY = window.innerHeight - boxHeight;
//             box.dataset.direction = 'up';
//         }

//         // Обновляем позицию
//         box.style.left = `${posX}px`;
//         box.style.top = `${posY}px`;
//     });
// }