import * as omdbApi from './omdbApi.js'

let filmsData;
let submitForm = document.forms.searchForm;
let titleName;
let titleType;
let paging = {
    fisrtPage: 1,
    currentPage: 1,
    maxPages: 1
};
let filmsHeader = document.querySelector('.films-head')
let filmsList = document.querySelector('.film-data');
let navigation = document.querySelector('nav');
let pageObjects = document.querySelector('.pagination');

submitForm.addEventListener('submit', async () => {
    event.preventDefault();

    filmsList.innerHTML = ''; //очищаем результат при повторном поиске
    paging.currentPage = 1; //явно устанавливаем на 1-ю страницу

    titleName = submitForm.title.value;
    titleType = submitForm.selectType.value;

    if (titleName && titleName.trim()) {
        filmsData = await omdbApi.searchByTitle(titleName, titleType, paging.fisrtPage);
        console.log(filmsData);//убрать потом
        drawFilms(filmsData, true);
        paging.maxPages = Math.ceil(filmsData.totalResults / 10);
        drawPagination(paging);
        changeActivePage(paging.currentPage);
    } else {
        filmsHeader.hidden = true;
        navigation.hidden = true;
    }

    submitForm.reset();
});

function drawFilms(filmsData, containsFilms) {
    if (!containsFilms) {
        filmsList.innerHTML = '';
    }
    filmsHeader.hidden = false;
    for (const film of filmsData.Search) {
        filmsList.insertAdjacentHTML('beforeend', `
        <div class="col film-card">
            <div class="card flex-row">
                <img src="${film.Poster}" onerror="this.src='./assets/img/1.jpg'" alt="./assets/img/1.jpg" class="card-img-left img-fluid">
                <div class="card-body py-0">
                    <h5 class="film-type">${film.Type}</h5>
                    <h4 class="film-title">${film.Title}</h4>
                    <h3 class="film-year">${film.Year}</h3>
                    <button type="submit" class="btn btn-primary details-button">Details</button>
                </div>
            </div>
        </div>`
        );
    }
}

function drawPagination(paging) {
    pageObjects.innerHTML = '';
    if (paging.maxPages > 1) {
        navigation.hidden = false;
        pageObjects.insertAdjacentHTML('beforeend', `
            <li class="page-item">
                <a class="page-link first" href="#" aria-label="First">&laquo;</a>
            </li>
            `);
        for (let i = paging.fisrtPage; i <= paging.maxPages; i++) {
            pageObjects.insertAdjacentHTML('beforeend', `
            <li class="page-item" id="${i}">
                <a class="page-link" href="#">${i}</a>
            </li>
            `);
        }
        pageObjects.insertAdjacentHTML('beforeend', `
            <li class="page-item">
                <a class="page-link last" href="#" aria-label="Last">&raquo;</a>
            </li>
        `);
    }
}

navigation.addEventListener('click', async () => {
    if (event.target.classList.contains('last')) {
        paging.currentPage = paging.maxPages;
    } else if (event.target.classList.contains('first')) {
        paging.currentPage = paging.fisrtPage;
    } else {
        paging.currentPage = event.target.innerHTML;
    }

    filmsData = await omdbApi.searchByTitle(titleName, titleType, paging.currentPage);
    drawPagination(paging);
    changeActivePage(paging.currentPage)
    drawFilms(filmsData, false);
});

function changeActivePage(currentPage) {
    let currentActive = document.getElementById(currentPage);
    try {
        currentActive.classList.add('active');
    } catch {
        return;
    }
};
