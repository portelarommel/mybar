document.addEventListener("DOMContentLoaded", function () {

    const cpf = document.getElementById("cpf");

    cpf.addEventListener("input", function () {

        let valor = cpf.value.replace(/\D/g, "");

        valor = valor.substring(0, 11);

        if (valor.length > 9) {
            valor = valor.replace(/(\d{3})(\d{3})(\d{3})(\d{1,2})/, "$1.$2.$3-$4");
        } else if (valor.length > 6) {
            valor = valor.replace(/(\d{3})(\d{3})(\d+)/, "$1.$2.$3");
        } else if (valor.length > 3) {
            valor = valor.replace(/(\d{3})(\d+)/, "$1.$2");
        }

        cpf.value = valor;
    });

});