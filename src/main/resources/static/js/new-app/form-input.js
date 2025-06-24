// FONCTION POUR AJOUTER ET SUPPRIMER `input form`

let index = 1;
document.addEventListener("click", function(e) {
    if (e.target.classList.contains("add-row")) {
        e.preventDefault();
        const container = document.getElementById("details-container");
        const newRow = document.querySelector(".detail-row").cloneNode(true);

        // Remplace les index dans les attributs name
        newRow.querySelectorAll("[name]").forEach(function(input) {
            const name = input.getAttribute("name");
            const updatedName = name.replace(/\[\d+\]/, `[${index}]`);
            input.setAttribute("name", updatedName);
            if (!input.value.trim()) {
                console.log("vide");
            }
            input.value = ""; // Réinitialiser les champs
        });

        container.appendChild(newRow);
        index++;
    }

    if (e.target.classList.contains("remove-row")) {
        e.preventDefault();
        const row = e.target.closest(".detail-row");
        if (document.querySelectorAll(".detail-row").length > 1) {
            console.log(document.querySelectorAll(".detail-row").length);
            
            row.remove();
        }
    }
});