let box = {
    element: document.querySelector('.box'),
    x: 0,
    y: 0,
    direction: 'down'
};

let iteration = 1;
let lastIteration = 3;
let moveAction;

box.element.textContent = iteration;


moveAction = setInterval(() => {
    switch (box.direction) {
        case 'down':
            if (box.y < window.innerHeight - 165) {
                box.y += 10;
            } else {
                box.direction = 'right';
            }
            break;
        case 'right':
            if (box.x < window.innerWidth - 165) {
                box.x += 10;
            } else {
                box.direction = 'up';
            }
            break;
        case 'up':
            if (box.y > 0) {
                box.y -= 10;
            } else {
                box.direction = 'left';
            }
            break;
        case 'left':
            if (box.x > 0) {
                if (iteration == lastIteration) {
                    box.element.textContent = 'Finish'
                }
                box.x -= 10;
            } else {
                if (iteration < lastIteration) {
                    iteration++;
                    box.element.textContent = iteration;
                    box.direction = 'down';
                } else {
                    clearInterval(moveAction);
                    box.element.remove();
                }
            }
    }

    box.element.style.top = box.y + 'px';
    box.element.style.left = box.x + 'px';
}, 1 * 10)