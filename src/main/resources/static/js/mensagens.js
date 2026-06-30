document.addEventListener("DOMContentLoaded", function () {
    const msg = document.getElementById("mensagem");

    if (!msg) return;

    const texto = msg.dataset.texto;
    const tipo = msg.dataset.tipo;

    switch (tipo) {
        case "erro":
            alert("Erro: " + texto);
            break;
        case "sucesso":
            alert("Sucesso: " + texto);
            break;
        default:
            alert(texto);
    }
});