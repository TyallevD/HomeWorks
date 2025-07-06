import * as omdbApi from './omdbApi.js'


let submitForm = document.forms.searchForm;
submitForm.addEventListener('submit', async ()=>{
    event.preventDefault();

    let titleName = submitForm.title.value;
    let titleType = submitForm.selectType.value;

    //проверочная
    console.log(titleName +" " + titleType);
    drawFilms();

    // запрос по названию и типу, потом раскомментить
    // if (titleName && titleName.trim()){
    //     let filmsData = await omdbApi.searchByTitle(titleName, titleType);
    //     console.log(filmsData);
    //     drawFilms(filmsData);
    // }

    submitForm.reset();
});

// function drawFilms(filmsData){
//     for (const film of filmsData.Search){
//         document.querySelector('.film-data').insertAdjacentHTML('afterend',`
//         <div class="col-4">
//             <img src="${film.Poster}" alt="./assets/img/1.jpg">
//             <div class="card-body">
//                 <h4>${film.Title}</h4>
//                 <p class="card-text">описание</p>
//             </div>
//         </div>`
//     );
//     }
// }

//функция для теста отрисовки
function drawFilms(){
    for (let i =0; i<10; i++){
        document.querySelector('.film-data').insertAdjacentHTML('afterend',`
        <div class="col-3">
            <img src="./assets/img/1.jpg" alt="">
            <div class="card-body">
                <h4>название</h4>
                <p class="card-text">описание</p>
            </div>
        </div>`
    );
    }
}

