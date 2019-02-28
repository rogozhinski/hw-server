// state machine
let todoMachine = {

    counter: 1,

    items: {},

    actions: {

        // добавляем новый элемент
        setItem: (itemText) => {

            // создадим обертку
            let itemWrapper = document.createElement('div');
            itemWrapper.className = "item-wrapper";
            itemWrapper.id = todoMachine.counter;

            // сделаем отметку выполнения 
            let doneChecker = document.createElement('div');
            doneChecker.className = "done-checker";
            
            // поле с текстом элемента
            let itemDiv = document.createElement('div');
            itemDiv.className = "item";
            itemDiv.innerHTML = itemText;

            // кнопку удаления
            let deleteButton = document.createElement('div');
            deleteButton.className = "delete-button bloko-icon_24 bloko-icon_cancel";

            itemWrapper.appendChild(doneChecker);
            itemWrapper.appendChild(itemDiv);
            itemWrapper.appendChild(deleteButton);
            let list = document.getElementsByClassName('todo-list')[0];
            list.insertBefore(itemWrapper, list.firstChild);
            
            let itemJson = {
                id: todoMachine.counter.toString(),
                text: itemText,
                done: "false"
            };

            todoMachine.items[todoMachine.counter] = itemJson

            window.fetch("http://localhost:9999/new",{
                method: 'POST',
                headers: {
                    'Content-Type': 'text/plain'
                    },
                mode: 'no-cors',
                body: JSON.stringify(itemJson)
            })
            todoMachine.counter++;
        },

        removeItem: (target) =>{
            let parent = target.parentElement;
            delete todoMachine.items[parent.id];
            parent.parentNode.removeChild(parent);
            window.fetch("http://localhost:9999/remove?id="+parent.id.toString(),{
                method: 'GET',
                mode: 'no-cors',
            })
        },

        // снятие или установка отметки о выполнении
        changeItemStatus: (target) => {
            let parent = target.parentElement;
            if (todoMachine.items[parent.id].done === "false") {
                todoMachine.items[parent.id].done = "true";
                target.className = "bloko-icon_24 bloko-icon_done done-checker";
            } else {
                todoMachine.items[parent.id].done = "false";
                target.className = "done-checker";
            }
            window.fetch("http://localhost:9999/switch?id="+parent.id.toString(),{
                method: 'GET',
                mode: 'no-cors',
            })
        },
    }
};

