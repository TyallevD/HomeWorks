let box = {
    element: document.querySelector('.box'),
    top: 10,
    left: 10,
    isUp: false,
    isLeft: false
}
setInterval(() => {
    if (box.top < window.innerHeight - 165 && !box.isUp) {
        console.log("Двигай вниз")
        box.element.style.top = box.top + "px";
        box.top += 10;
    } else if (box.left < window.innerWidth - 165 && !box.isLeft) {
        console.log("Двигай вправо")
        box.isUp = true;
        box.element.style.left = box.left + "px";
        box.left += 10;
    } else if (box.top > 0 && box.isUp) {
        console.log("Двигай вверх")
        box.isLeft = true;
        box.element.style.top = box.top + "px";
        box.top -= 10;
    } else if (box.left > 0 && box.isLeft) {
        console.log("Двигай влево")
        box.element.style.left = box.left + "px";
        box.left -= 10;
    }
}, 1 * 10);
