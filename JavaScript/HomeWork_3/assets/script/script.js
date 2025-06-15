/*
1) при старте запрашивается количество коробок +
2) при старте запрашивается время на игру +
3) на экране создается то количество коробок, что ввел пользователь (минимум 5, максимум 1000):
- коробки с разным номером (от 1 до введенного количества)
- коробки с разным цветом
- коробки двигаются "хаотично"
4) расчитывается время на выполнения
5) после старта начинается обратный отсчет:
 - если пользователь успел уничтожить все коробки - время останавливается, отображается статус "победа"
 - если пользователь не успел уничтожить все коробки - время останавливается, коробки останавливаются, отображается статус "поражение"
*/

let num_boxes;
while (true) {
    num_boxes = prompt("Введите количество контейнеров от 5 до 1000");
    if (num_boxes == null) {
        alert("Ввод отменён");
        break;
    }
    if (!isNaN(Number(num_boxes))) {
        if (num_boxes < 5) {
            num_boxes = 5;
        } else if (num_boxes > 1000) {
            num_boxes = 1000;
        }
        break;
    }
}

let status = document.querySelector('.status');
status.innerText = 'Осталось коробок: ' + num_boxes;

let timer_input;
let timer_value;
while (true) {
    timer_input = prompt(`Введите время игры:
        1 = 1 min
        2 = 2 min
        3 = 5 min
        4 = 10 min`);
    if (timer_input == null) {
        alert("Ввод отменён");
        break;
    }
    switch(timer_input){
        case '1':
            timer_value = 60 * 1000;
            break;
        case '2':
            timer_value = 2* 60 * 1000;
            break;
        case '3':
            timer_value = 5 * 60 * 1000;
            break;
        case '4':
            timer_value = 10 * 60 * 1000;
            break;
    }
    if (timer_input=='1' || timer_input =='2' || timer_input == '3' || timer_input == '4'){
        break;
    }
}

let timer = document.querySelector('.timer');
timer.innerText = 'Времени осталось: ' + timer_value;

gameTime = setInterval(()=>{
    timer_value -=10000; //пока ускорение нужно значение 1000
    timer.innerText = 'Времени осталось: ' + timer_value;
    if (timer_value==0){
        status.innerText = 'Поражение! Осталось коробок: '+ num_boxes;
        clearInterval(gameTime);
    }
}, 1 * 1000)