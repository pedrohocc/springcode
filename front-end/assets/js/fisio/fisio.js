function buscarTodosFisio() {
  fetch("http://localhost:8080/physio", { method: "GET" })
    .then((res) => {
      let json = res.json();
      return json;
    })
    .then((dados) => {
      const listaFisio = [];

      for (const fisio of dados) {
        const novoFisio = {
          id: fisio.id,
          nome: fisio.name,
          coffito: fisio.coffito,
          ativo: fisio.isActive,
        };
        listaFisio.push(novoFisio);
      }

      adicionarItensTabela(listaFisio);
    });
}

async function buscarFisioId(id) {
  const fisioterapeuta = await fetch(`http://localhost:8080/physio/${id}`, {
    method: "GET",
  })
    .then((res) => {
      return res.json();
    })
    .then((dado) => {
      const resultado = {
        id: dado.id,
        nome: dado.name,
        coffito: dado.coffito,
        cpf: dado.cpf,
        rua: dado.streetAddress,
        numero: dado.numberAddress,
        bairro: dado.districtAddress,
        cidade: dado.cityAddress,
        cep: dado.zipCode,
        ativo: dado.isActive,
      };
      return resultado;
    });

  return fisioterapeuta;
}

function criarFisio() {
  const nomeInput = document.querySelector("#nomeFisio").value;
  const cpfInput = document.querySelector("#cpfFisio").value;
  const coffitoInput = document.querySelector("#coffitoFisio").value;
  const ruaInput = document.querySelector("#rua").value;
  const numeroInput = document.querySelector("#numero").value;
  const bairroInput = document.querySelector("#bairro").value;
  const cidadeInput = document.querySelector("#cidade").value;
  const cepInput = document.querySelector("#cep").value;

  const novoFisio = {
    name: nomeInput,
    cpf: cpfInput,
    coffito: coffitoInput,
    streetAddress: ruaInput,
    numberAddress: numeroInput,
    districtAddress: bairroInput,
    cityAddress: cidadeInput,
    zipCode: cepInput,
    isActive: 1
  }

  fetch(`http://localhost:8080/physio`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(novoFisio),
  }).then(() => {
    alert("Item Criado");
    location.reload();
  });
}

function deletarFisio(id) {
  fetch(`http://localhost:8080/physio/${id}`, { method: "DELETE" }).then(() => {
    alert("Item Excluido");
    location.reload();
  });
}

function editarFisio() {
  const id = document.querySelector("#informeId").value;
  const nomeInput = document.querySelector("#nomeFisioEditar").value;
  const cpfInput = document.querySelector("#cpfFisioEditar").value;
  const coffitoInput = document.querySelector("#coffitoFisioEditar").value;
  const ruaInput = document.querySelector("#ruaEditar").value;
  const numeroInput = document.querySelector("#numeroEditar").value;
  const bairroInput = document.querySelector("#bairroEditar").value;
  const cidadeInput = document.querySelector("#cidadeEditar").value;
  const cepInput = document.querySelector("#cepEditar").value;
  const ativoInput = document.querySelector("#ativoEditar").value;

  const fisioEditado = {
    id: Number(id),
    name: nomeInput,
    cpf: cpfInput,
    coffito: coffitoInput,
    streetAddress: ruaInput,
    numberAddress: numeroInput,
    districtAddress: bairroInput,
    cityAddress: cidadeInput,
    zipCode: cepInput,
    isActive: Boolean(Number(ativoInput)),
  };

  fetch(`http://localhost:8080/physio/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(fisioEditado),
  }).then(() => {
    alert("Item Editado");
    location.reload();
  });
}

function adicionarItensTabela(listaFisio) {
  const corpoTabela = document.querySelector("#corpoTabela");

  for (const fisioterapeuta of listaFisio) {
    const tr = document.createElement("tr");
    const thId = document.createElement("th");
    const tdNome = document.createElement("td");
    const tdCoffito = document.createElement("td");
    const tdAtivo = document.createElement("td");
    const tdAcoes = document.createElement("td");

    thId.scope = "row";
    thId.textContent = fisioterapeuta.id;
    tdNome.textContent = fisioterapeuta.nome;
    tdCoffito.textContent = fisioterapeuta.coffito;
    tdAtivo.textContent = Number(fisioterapeuta.ativo);
    tdAcoes.innerHTML += `<input data-bs-toggle="modal" data-bs-target="#editar" type="button" value="✏️" onClick="editarFisioBnt(${fisioterapeuta.id})">`;
    tdAcoes.innerHTML += `<input type="button" value="❌" onClick="excluirFisoBnt(${fisioterapeuta.id})">`;
    tr.appendChild(thId);
    tr.appendChild(tdNome);
    tr.appendChild(tdCoffito);
    tr.appendChild(tdAtivo);
    tr.appendChild(tdAcoes);
    corpoTabela.appendChild(tr);
  }
}

function editarFisioBnt(id) {
  inserirInformacoesInputEditar(id);
}

function excluirFisoBnt(id) {
  const confrimacao = confirm("Deseja excluir esse fisioterapeuta?");

  if (confrimacao) {
    deletarFisio(id);
  }
}

async function inserirInformacoesInputEditar(id) {
  const idInput = document.querySelector("#informeId");
  const nomeInput = document.querySelector("#nomeFisioEditar");
  const cpfInput = document.querySelector("#cpfFisioEditar");
  const coffitoInput = document.querySelector("#coffitoFisioEditar");
  const ruaInput = document.querySelector("#ruaEditar");
  const numeroInput = document.querySelector("#numeroEditar");
  const bairroInput = document.querySelector("#bairroEditar");
  const cidadeInput = document.querySelector("#cidadeEditar");
  const cepInput = document.querySelector("#cepEditar");
  const ativoInput = document.querySelector("#ativoEditar");

  const res = await buscarFisioId(id);

  idInput.value = res.id;
  nomeInput.value = res.nome;
  cpfInput.value = res.cpf;
  coffitoInput.value = res.coffito;
  nomeInput.value = res.nome;
  ruaInput.value = res.rua;
  numeroInput.value = res.numero;
  bairroInput.value = res.bairro;
  cidadeInput.value = res.cidade;
  cepInput.value = res.cep;
  ativoInput.value = Number(res.ativo);
}