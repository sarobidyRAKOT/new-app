const detailsContainer = document.getElementById('details-container');

detailsContainer.addEventListener('click', function (event) {
    // Chercher si on clique sur un bouton "add-row" ou "remove-row"
    const addBtn = event.target.closest('.add-row');
    const removeBtn = event.target.closest('.remove-row');

    // Si clic sur bouton ajouter
    if (addBtn) {
        event.preventDefault();

        const lastRow = detailsContainer.querySelector('.detail-row:last-child');
        const item_code = lastRow.querySelector('.item_code').value.trim();
        const qty = lastRow.querySelector('.qty').value.trim();
        const uom = lastRow.querySelector('.uom').value.trim();

        console.log(item_code)
        if (!item_code) {
            alert("Veuillez remplir l'Item code avant d’ajouter une nouvelle ligne.");
            return;
        }
        if (!qty) {
            alert('Veuillez remplir la Quantité avant d’ajouter une nouvelle ligne.');
            return;
        }
        if (!uom) {
            alert("Veuillez remplir l'Unité avant d’ajouter une nouvelle ligne.");
            return;
        }
        
        const newRow = lastRow.cloneNode(true);
        newRow.querySelector('.item_code').value = '';
        newRow.querySelector('.qty').value = '';
        newRow.querySelector('.uom').value = 'Nos';

        // Ajouter juste après la dernière ligne
        lastRow.after(newRow);
    }

    // Si clic sur bouton supprimer
    if (removeBtn) {
        event.preventDefault();

        const rowToRemove = removeBtn.closest('.detail-row');
        const allRows = detailsContainer.querySelectorAll('.detail-row');

        if (allRows.length > 1) {
            rowToRemove.remove();
        } else {
            alert('Vous ne pouvez pas supprimer la dernière ligne.');
        }
    }
});
