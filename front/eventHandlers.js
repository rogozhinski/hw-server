//при нажатии клавиш в input'e...
document.addEventListener('keypress', function(e) {
    // если нажали enter...
    if (e.keyCode === 13) {
        let inputValue = document.getElementsByClassName('input')[0].value
        // ...и поле ввода не пустое...
        if (inputValue !== ""){
            //... то записываем введенное значение
            todoMachine.actions.setItem(inputValue);
            // и очищаем input, если там что-то есть
            document.getElementsByClassName('input')[0].value = '';
        }
    }
})

document.addEventListener('click', e => {
    const target = e.target;

    // если кликнуть на крестик у элемента, тот удалится со всей своей оберткой 
    if (target.className.includes('delete-button')){
        todoMachine.actions.removeItem(target)
    }  
    // если кликнуть на отметку выполнения, то она сменит свое состояние 
    if (target.className.includes('done-checker')){
        todoMachine.actions.changeItemStatus(target)
    }  
});
    


