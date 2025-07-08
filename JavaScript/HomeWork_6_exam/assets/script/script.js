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
let filmsHeader = document.querySelector('.films-head');
let detailsHeader = document.querySelector('.details-head');
let filmsList = document.querySelector('.film-data');
let navigation = document.querySelector('nav');
let pageObjects = document.querySelector('.pagination');
let detailsContainer = document.querySelector('.details-container');

submitForm.addEventListener('submit', async () => {
    event.preventDefault();

    filmsList.innerHTML = ''; //очищаем результат при повторном поиске
    detailsContainer.hidden=true;
    detailsHeader.hidden=true;
    paging.currentPage = 1; //явно устанавливаем на 1-ю страницу

    titleName = submitForm.title.value;
    titleType = submitForm.selectType.value;

    if (titleName && titleName.trim()) {
        filmsData = await omdbApi.searchByTitle(titleName, titleType, paging.fisrtPage);
        drawFilms(filmsData);
        paging.maxPages = Math.ceil(filmsData.totalResults / 10);
        drawPagination(paging);
        changeActivePage(paging.currentPage);
    } else {
        filmsHeader.hidden = true;
        navigation.hidden = true;
    }
    filmsHeader.scrollIntoView({behavior:'smooth'});
    submitForm.reset();
});

function drawFilms(filmsData) {
    filmsList.innerHTML = '';
    filmsHeader.hidden = false;

    for (const film of filmsData.Search) {
        let tempDiv = document.createElement('div');
        tempDiv.innerHTML = `
            <div class="col film-card">
                <div class="card flex-row">
                    <img src="${film.Poster}" onerror="this.src='./assets/img/1.png'" alt="./assets/img/1.png" class="card-img-left img-fluid">
                    <div class="card-body py-0">
                        <h5 class="film-type">${film.Type}</h5>
                        <h4 class="film-title">${film.Title}</h4>
                        <h3 class="film-year">${film.Year}</h3>
                        <button class="btn btn-primary details-button">Details</button>
                    </div>
                </div>
            </div>
        `;

        let filmCard = tempDiv.firstElementChild;
        filmsList.appendChild(filmCard);

        let detailsButton = filmCard.querySelector('.details-button');
        detailsButton.addEventListener('click', async () => showFilmDetails(film.imdbID));
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
    event.preventDefault();
    if (event.target.classList.contains('last')) {
        paging.currentPage = paging.maxPages;
    } else if (event.target.classList.contains('first')) {
        paging.currentPage = paging.fisrtPage;
    } else {
        paging.currentPage = event.target.innerHTML;
    }

    filmsData = await omdbApi.searchByTitle(titleName, titleType, paging.currentPage);
    detailsContainer.hidden=true;
    detailsHeader.hidden=true;
    drawFilms(filmsData);
    drawPagination(paging);
    changeActivePage(paging.currentPage);
    filmsHeader.scrollIntoView({behavior:'smooth'});
});

function changeActivePage(currentPage) {
    let currentActive = document.getElementById(currentPage);
    try {
        currentActive.classList.add('active');
    } catch {
        return;
    }
};

async function showFilmDetails(id) {
    event.preventDefault();
    let filmDetails = await omdbApi.loadDetails(id);
    drawInfo(filmDetails);
}

function drawInfo(filmDetails){
    detailsContainer.innerHTML = '';
    detailsContainer.hidden=false;
    detailsHeader.hidden=false;
    detailsContainer.insertAdjacentHTML('beforeend',`
        <div class="details-card">
            <img src="${filmDetails.Poster}" onerror="this.src='./assets/img/1.png'" alt="">
            <div class="details-body">
                <div class="details-description">
                    <span class="details-type">Title:</span>
                    <span class="details-value">${filmDetails.Title}</span>
                </div>
                <div class="details-description">
                    <span class="details-type">Released:</span>
                    <span class="details-value">${filmDetails.Released}</span>
                </div>
                <div class="details-description">
                    <span class="details-type">Genre:</span>
                    <span class="details-value">${filmDetails.Genre}</span>
                </div>
                <div class="details-description">
                    <span class="details-type">Country:</span>
                    <span class="details-value">${filmDetails.Country}</span>
                </div>
                <div class="details-description">
                    <span class="details-type">Director:</span>
                    <span class="details-value">${filmDetails.Director}</span>
                </div>
                <div class="details-description">
                    <span class="details-type">Writer:</span>
                    <span class="details-value">${filmDetails.Writer}</span>
                </div>
                <div class="details-description">
                    <span class="details-type">Actors:</span>
                    <span class="details-value">${filmDetails.Actors}</span>
                </div>
                <div class="details-description">
                    <span class="details-type">Awards:</span>
                    <span class="details-value">${filmDetails.Awards}</span>
                </div>
            </div>
        </div>
        `);
        detailsContainer.scrollIntoView({behavior:'smooth'});
}