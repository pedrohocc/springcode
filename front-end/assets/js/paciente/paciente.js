function buscarTodosPacientes() {
  fetch("http://localhost:8080/client", { method: "GET" })
    .then((res) => {
      let json = res.json();
      return json;
    })
    .then((dados) => {
      const listaPacientes = [];

      for (const paciente of dados) {
        if (paciente.isActive == true) {
          const novoPaciente = {
            id: paciente.id,
            nome: paciente.name,
            cpf: paciente.cpf,
            pagamento: paciente.paymentStatus,
            ativo: paciente.isActive,
          };
          listaPacientes.push(novoPaciente);
        }
      }

      adicionarItensTabela(listaPacientes);
    });
}

async function buscarPacienteId(id) {
  const paciente = await fetch(`http://localhost:8080/client/${id}`, {
    method: "GET",
  })
    .then((res) => {
      return res.json();
    })
    .then((dado) => {
      const resultado = {
        id: dado.id,
        nome: dado.name,
        cpf: dado.cpf,
        idade: dado.age,
        rua: dado.streetAddress,
        numero: dado.numberAddress,
        bairro: dado.districtAddress,
        cidade: dado.cityAddress,
        cep: dado.zipCode,
        telefone: dado.phone,
        diaPagamento: dado.paymentDate,
        statusPagamento: dado.paymentStatus,
        ativo: dado.isActive,
      };
      return resultado;
    });

  return paciente;
}

function criarPaciente() {
  const nomeInput = document.querySelector("#nomePaciente").value;
  const cpfInput = document.querySelector("#cpfPaciente").value;
  const idadeInput = document.querySelector("#idadePaciente").value;
  const ruaInput = document.querySelector("#rua").value;
  const numeroInput = document.querySelector("#numero").value;
  const bairroInput = document.querySelector("#bairro").value;
  const cidadeInput = document.querySelector("#cidade").value;
  const cepInput = document.querySelector("#cep").value;
  const telefoneInput = document.querySelector("#telefone").value;
  const dataPagamentoInput = document.querySelector("#dataPagamento").value;
  const statusPagamentoInput = document.querySelector("#statusPagamento").value;

  const data = new Date(dataPagamentoInput);
  const instant = data.toISOString();

  const novoPaciente = {
    name: nomeInput,
    cpf: cpfInput,
    streetAddress: idadeInput,
    numberAddress: ruaInput,
    districtAddress: numeroInput,
    cityAddress: bairroInput,
    zipCode: cidadeInput,
    zipCode: cepInput,
    phone: telefoneInput,
    paymentDate: instant,
    paymentStatus: Boolean(statusPagamentoInput),
    isActive: Boolean(1),
  };

  fetch(`http://localhost:8080/client`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(novoPaciente),
  }).then(() => {
    alert("Item Criado");
    location.reload();
  });
}

async function deletarPaciente(id) {
  const paciente = await buscarPacienteId(id);
  fetch(`http://localhost:8080/client/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      id: paciente.id,
      name: paciente.nome,
      cpf: paciente.cpf,
      age: paciente.idade,
      streetAddress: paciente.idade,
      numberAddress: paciente.rua,
      districtAddress: paciente.numero,
      cityAddress: paciente.bairro,
      zipCode: paciente.cidade,
      zipCode: paciente.cep,
      phone: paciente.telefone,
      paymentDate: paciente.diaPagamento,
      paymentStatus: paciente.statusPagamento,
      isActive: Boolean(0),
    }),
  }).then(() => {
    alert("Item Excluido");
    location.reload();
  });
}

function editarPaciente() {
  const idInput = document.querySelector("#editarIdPaciente").value;
  const nomeInput = document.querySelector("#editarNomePaciente").value;
  const cpfInput = document.querySelector("#editarCpfPaciente").value;
  const idadeInput = document.querySelector("#editarIdadePaciente").value;
  const ruaInput = document.querySelector("#editarRua").value;
  const numeroInput = document.querySelector("#editarNumero").value;
  const bairroInput = document.querySelector("#editarBairro").value;
  const cidadeInput = document.querySelector("#editarCidade").value;
  const cepInput = document.querySelector("#editarCep").value;
  const telefoneInput = document.querySelector("#editarTelefone").value;
  const dataPagamentoInput = document.querySelector(
    "#editarDataPagamento"
  ).value;
  const statusPagamentoInput = document.querySelector(
    "#editarStatusPagamento"
  ).value;
  const ativoInput = document.querySelector("#editarAtivo").value;

  const data = new Date(dataPagamentoInput);
  const instant = data.toISOString();

  const pacienteEditado = {
    id: idInput, 
    name: nomeInput,
    cpf: cpfInput,
    age: idadeInput,
    streetAddress: ruaInput,
    numberAddress: numeroInput,
    districtAddress: bairroInput,
    cityAddress: cidadeInput,
    zipCode: cepInput,
    phone: telefoneInput,
    paymentDate: instant,
    paymentStatus: Boolean(statusPagamentoInput),
    isActive: Boolean(ativoInput)
  };

  fetch(`http://localhost:8080/client/${idInput}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(pacienteEditado),
  }).then(() => {
    alert("Item Editado");
    location.reload();
  });
}

function adicionarItensTabela(listaPacientes) {
  const corpoTabela = document.querySelector("#corpoTabela");

  for (const paciente of listaPacientes) {
    const tr = document.createElement("tr");
    const thId = document.createElement("th");
    const tdNome = document.createElement("td");
    const tdCpf = document.createElement("td");
    const tdPagamento = document.createElement("td");
    const tdAtivo = document.createElement("td");
    const tdAcoes = document.createElement("td");

    thId.scope = "row";
    thId.textContent = paciente.id;
    tdNome.textContent = paciente.nome;
    tdCpf.textContent = paciente.cpf;
    tdPagamento.textContent = paciente.pagamento;
    tdPagamento.textContent == "true"
      ? (tdPagamento.style.color = "green")
      : (tdPagamento.style.color = "red");
    tdAtivo.textContent = paciente.ativo;
    tdAcoes.innerHTML += `<input data-bs-toggle="modal" data-bs-target="#editar" type="button" value="✏️" onClick="editarPacienteBnt(${paciente.id})">`;
    tdAcoes.innerHTML += `<input type="button" value="❌" onClick="excluirPacienteBnt(${paciente.id})">`;
    tr.appendChild(thId);
    tr.appendChild(tdNome);
    tr.appendChild(tdCpf);
    tr.appendChild(tdPagamento);
    tr.appendChild(tdAtivo);
    tr.appendChild(tdAcoes);
    corpoTabela.appendChild(tr);
  }
}

function editarPacienteBnt(id) {
  inserirInformacoesInputEditar(id);
}

function excluirPacienteBnt(id) {
  const confirmacao = confirm("Deseja excluir esse Paciente?");

  if (confirmacao) {
    deletarPaciente(id);
  }
}

async function inserirInformacoesInputEditar(id) {
  const idInput = document.querySelector("#editarIdPaciente");
  const nomeInput = document.querySelector("#editarNomePaciente");
  const cpfInput = document.querySelector("#editarCpfPaciente");
  const idadeInput = document.querySelector("#editarIdadePaciente");
  const ruaInput = document.querySelector("#editarRua");
  const numeroInput = document.querySelector("#editarNumero");
  const bairroInput = document.querySelector("#editarBairro");
  const cidadeInput = document.querySelector("#editarCidade");
  const cepInput = document.querySelector("#editarCep");
  const telefoneInput = document.querySelector("#editarTelefone");
  const dataPagamentoInput = document.querySelector("#editarDataPagamento");
  const statusPagamentoInput = document.querySelector("#editarStatusPagamento");
  const ativoInput = document.querySelector("#editarAtivo");

  const res = await buscarPacienteId(id);

  let data = new Date(res.diaPagamento)
  data = data.toISOString()

  idInput.value = res.id;
  nomeInput.value = res.nome;
  cpfInput.value = res.cpf;
  idadeInput.value = res.idade;
  ruaInput.value = res.rua;
  numeroInput.value = res.numero;
  bairroInput.value = res.bairro;
  cidadeInput.value = res.cidade;
  cepInput.value = res.cep;
  telefoneInput.value = res.telefone;
  dataPagamentoInput.value = data;
  statusPagamentoInput.value =  Number(res.statusPagamento);
  ativoInput.value = Number(res.ativo);
}
