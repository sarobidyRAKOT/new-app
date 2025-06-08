function show (divShow, divHiddens) {

    /**
     * show and hidden `div`
     * divHiddens : tableau
     */
    const show = document.getElementById(divShow);
    show.style.display = "block"
    
    divHiddens.forEach (div => {
        document.getElementById (div).style.display = "none"
    })
}