document.getElementById("addressForm").addEventListener("submit", function(event) {
    event.preventDefault(); 

    const cep = document.getElementById("cep").value;

    if (cep.length !== 8) {
        alert("Por favor, insira um CEP válido.");
        return;
    }

    fetch(`/cep?cep=${cep}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao buscar o endereço");
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("rua").value = data.logradouro;
            document.getElementById("bairro").value = data.bairro;
            document.getElementById("cidade").value = data.localidade;
            document.getElementById("estado").value = data.uf;
        })
        .catch(error => {
            console.error("Erro:", error);
            alert("Não foi possível buscar os dados do CEP.");
        });
});
