//http://www.omdbapi.com/?apikey=be8fee90&i=tt3896198
let apikey = 'be8fee90';
let baseURL = 'http://www.omdbapi.com';

export async function searchByTitle(titleName, titleType,page) {
    let response = await fetch(`${baseURL}/?apikey=${apikey}&s=${titleName}&type=${titleType}&page=${page}`);
    let data = await response.json();
    return data;
}