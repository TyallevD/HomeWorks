let myForm = document.forms.toDoForm;
let myList = document.querySelector('.my-list');
let errorText = document.querySelector('.error-text');
let btnClear = document.querySelector('.my-btn-clear');
let btnClearSelected = document.querySelector('.my-btn-selected');

myForm.title.addEventListener('keyup', () => {
    let str = event.target.value;

    // if (str.trim().length == 0) {
    //     errorText.style.display = 'block';
    // } else {
    //     errorText.style.display = 'none';
    // }
    //поменял if-else на тернарный оператор
    str.trim().length == 0 ?
        errorText.style.display = 'block' :
        errorText.style.display = 'none';
});

myForm.addEventListener('submit', () => {
    event.preventDefault();
    let title = myForm.title.value;

    if (title && title.trim()) {
        errorText.style.display = 'none';
        myList.innerHTML += `<div class="list-group-item list-group-item-action item">
        <div class="content">
        ${title}
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
    } else {
        errorText.style.display = 'block';
    }

    //после добавления нового элемента в список меняем активность кнопки deleteAll (btnClear)
    checkContent();
    myForm.reset();
});

myList.addEventListener('click', () => {
    if (event.target.tagName == 'DIV' && event.target.classList.contains('remove')) {
        event.target.parentElement.parentElement.remove();
    } else if (event.target.tagName == 'DIV' && event.target.classList.contains('done')) {
        if (event.target.parentElement.parentElement.style.backgroundColor != 'green') {
            event.target.parentElement.parentElement.style.backgroundColor = 'green';
            event.target.parentElement.parentElement.style.color = 'white';
            event.target.style.color = 'white';
        } else {
            event.target.parentElement.parentElement.removeAttribute('style');
            event.target.style.color = 'green';
        }
    }

    //добавление выделения элемента списка через добавление класса checked
    else if (event.target.tagName == 'DIV' && event.target.classList.contains('item')) {
        if (event.target.classList.contains('checked')) {
            event.target.classList.remove('checked');
            checkSelectedDeleteBtn();
        } else {
            event.target.classList.add('checked');
            checkSelectedDeleteBtn();
        }
    };
});

//кнопка очистки deleteAll
btnClear.addEventListener('click', () => {
    myList.innerHTML = '';

    //проверяем кнопки полного удаления и удаления выделенного
    checkContent();
    checkSelectedDeleteBtn();
});

btnClearSelected.addEventListener('click', () => {
    //сделать кнопку удаления выделенных строк, если строки не выделены - кнопка задизейблена
    let linesToDelete = document.querySelectorAll('.checked');
    linesToDelete.forEach(item => item.remove());

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