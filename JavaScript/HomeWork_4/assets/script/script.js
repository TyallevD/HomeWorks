let myForm = document.forms.toDoForm;
let myList = document.querySelector('.my-list');
let errorText = document.querySelector('.error-text');
let btnClear = document.querySelector('.my-btn-clear');
let btnClearSelected = document.querySelector('.my-btn-selected');

myForm.title.addEventListener('keyup', () => {
    let str = event.target.value;

    if (str.trim().length == 0) {
        errorText.style.display = 'block';
    } else {
        errorText.style.display = 'none';
    }
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

    myForm.reset();
});

myList.addEventListener('click', () => {
    if (event.target.tagName == 'DIV' && event.target.classList.contains('remove')) {
        event.target.parentElement.parentElement.remove();
    } else if (event.target.tagName == 'DIV' && event.target.classList.contains('done')) {
        if (event.target.parentElement.parentElement.style.backgroundColor != 'green') {
            event.target.parentElement.parentElement.style.backgroundColor = 'green';
            event.target.parentElement.parentElement.style.color='white';
            event.target.style.color = 'white';
        } else {
            event.target.parentElement.parentElement.removeAttribute('style');
            event.target.style.color = 'green';
        }
    }
});

btnClear.addEventListener('click', () => {
    // сделать кнопку очистки, изначально должна быть задизейблена, если нет айтемов
});

btnClearSelected.addEventListener('click', ()=>{
    //сделать кнопку удаления выделенных строк, если строки не выделены - кнопка задизейблена
});