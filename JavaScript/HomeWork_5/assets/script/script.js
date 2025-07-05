let myForm = document.forms.toDoForm;
let myList = document.querySelector('.my-list');
let errorText = document.querySelector('.error-text');
let btnClear = document.querySelector('.my-btn-clear');
let btnClearSelected = document.querySelector('.my-btn-selected');
let arr = [];
let ids = [];

//загрузка контента из локального хранилища
document.addEventListener('DOMContentLoaded', () => {
    let json = localStorage.getItem('tasks');
    if (json) {
        //добавление в arr всех элементов из localStorage
        arr = JSON.parse(json);
        //отрисовка всех элементов из arr
        for (let element of arr) {
            drawItem(element);
        }
    };
    //проверка активности кнопок полного и выборочного удаления
    checkContent();
    checkSelectedDeleteBtn();
});

//отображение ошибки ввода (если введены пробелы)
myForm.title.addEventListener('keyup', () => {
    let str = event.target.value;

    str.trim().length == 0 ?
        errorText.style.display = 'block' :
        errorText.style.display = 'none';
});

myForm.addEventListener('submit', () => {
    event.preventDefault();
    let text = myForm.title.value;

    if (text && text.trim()) {
        errorText.style.display = 'none';

        let item = {
            title: text,
            isDone: false,
            id: Date.now()
        }

        arr.push(item);
        drawItem(item);
        localStorage.setItem('tasks', JSON.stringify(arr));
    } else {
        errorText.style.display = 'block';
    }

    //после добавления нового элемента в список меняем активность кнопки deleteAll (btnClear)
    checkContent();
    myForm.reset();
});

myList.addEventListener('click', () => {
    if (event.target.tagName == 'DIV' && event.target.classList.contains('remove')) {
        //удаление элемента из html
        event.target.parentElement.parentElement.remove();
        
        //вычисление id элемента и удаление его из localStorage по id через функцию
        deleteById(event.target.parentElement.parentElement.dataset.id);

        //проверка кнопки полного и выборочного удаления (если вдруг после точечного удаления ничего не осталось или точечно удален "выбранный" элемент)
        checkContent();
        checkSelectedDeleteBtn();
    } else if (event.target.tagName == 'DIV' && event.target.classList.contains('done')) {

        let id = event.target.parentElement.parentElement.dataset.id;
        let element = arr.filter(element => element.id == id)[0];
        arr = arr.filter(element => element.id != id);

        if (event.target.parentElement.parentElement.classList.contains('active')) {
            event.target.parentElement.parentElement.classList.remove('active');
            element.isDone = false;
        } else {
            event.target.parentElement.parentElement.classList.add('active');
            element.isDone = true;
        }
        arr.push(element);
        localStorage.setItem('tasks', JSON.stringify(arr));
    }

    //добавление выделения элемента списка через добавление класса checked
    else if (event.target.tagName == 'DIV' && event.target.classList.contains('item')) {
        //получение id выбранного элемента
        let checkedId = event.target.dataset.id;

        if (event.target.classList.contains('checked')) {
            event.target.classList.remove('checked');
            //нахождение id выбранного элемента в массиве ids
            let index = ids.indexOf(checkedId);
            //удаление выбранного элемента из массива ids по индексу
            ids.splice(index, 1);
            checkSelectedDeleteBtn();
        } else {
            event.target.classList.add('checked');
            //добавление id выбранного элемента в массив ids 
            ids.push(checkedId);
            checkSelectedDeleteBtn();
        }
    };
});

//кнопка очистки deleteAll
btnClear.addEventListener('click', () => {
    //очистка списка
    myList.innerHTML = '';
    //удаление из локального хранилища
    localStorage.clear();
    //проверяем кнопки полного удаления и удаления выделенного
    checkContent();
    checkSelectedDeleteBtn();
});

btnClearSelected.addEventListener('click', () => {
    //сделать кнопку удаления выделенных строк, если строки не выделены - кнопка задизейблена
    let linesToDelete = document.querySelectorAll('.checked');
    linesToDelete.forEach(item => item.remove());

    //удаление элементов по списку из массива ids, который содержит выбранные элементы
    for (let element of ids){
        deleteById(element);
    }
    //очистка массива выбранных элементов
    ids = [];

    //деактивация кнопки после удаляения помеченных элементов
    btnClearSelected.disabled = true;
    checkContent();
});

//вспомогательная функция для проверки есть ли в списке элементы или нет для активации кнопки полной очистки
function checkContent() {
    myList.firstElementChild ?
        btnClear.disabled = false :
        btnClear.disabled = true;
}

//вспомогательная функция, проверяет есть ли выбранные элементы, если нет - кнопка не активна, если есть - кнопка активна
function checkSelectedDeleteBtn() {
    let checkedElements = myList.querySelectorAll('.checked');
    checkedElements.length == 0 ?
        btnClearSelected.disabled = true :
        btnClearSelected.disabled = false;
}
//функция отрисовки контента
function drawItem(item) {
    myList.innerHTML += `<div data-id=${item.id} class="list-group-item list-group-item-action item ${item.isDone ? 'active' : ''}">
        <div class="content">
        ${item.title}
        </div>
            <div class="btns">
                <div class="done">
                    ✔
                </div>
                <div class="remove">
                    ❌
                </div>
            </div>
        </div>`;
};

//функция удаления по id элемента
function deleteById(id){
    //прохождение по массиву arr, содержащему все объекты
    for (let i = 0; i< arr.length; i++){
        //если переданный id содержится в массиве arr - удаление его по индексу
        if (id == arr[i].id){
            arr.splice(i,1);
        }
    }

    //перезапись в localStorage значений из arr
    localStorage.removeItem('tasks');
    localStorage.setItem('tasks', JSON.stringify(arr));
}