document.querySelectorAll('.file-upload-browse').forEach(function(button) {
    button.addEventListener('click', function() {
        const input = this.closest('.col-sm-9').querySelector('.file-upload-default');
        input.click(); // ouvre le sélecteur de fichiers
    });
});

document.querySelectorAll('.file-upload-default').forEach(function(input) {
    input.addEventListener('change', function() {
        const fileName = this.files[0] ? this.files[0].name : '';
        const textInput = this.closest('.col-sm-9').querySelector('.file-upload-info');
        textInput.value = fileName; // affiche le nom du fichier
    });
});