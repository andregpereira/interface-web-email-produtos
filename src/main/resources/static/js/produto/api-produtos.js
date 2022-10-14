async function criar(e) {
	e.preventDefault();

	var formProduto =
		JSON.stringify($("#formProduto").serializeArray().reduce((a, x) => ({ ...a, [x.name]: x.value }), {}));

	await $.ajax({
		type: "POST",
		url: "http://localhost:8082/produto",
		data: formProduto,
		success: function() {
			alert("Produto cadastrado");
			location.reload();
		},
		error: function() {
			alert("Ocorreu um erro ao registrar o produto");
		},
		dataType: "json",
		contentType: "application/json"
	});
}

async function atualizar(e) {
	e.preventDefault();

	var formProduto =
		JSON.stringify($("#formProduto").serializeArray().reduce((a, x) => ({ ...a, [x.name]: x.value }), {}));

	await $.ajax({
		type: "PUT",
		url: "http://localhost:8082/produto",
		data: formProduto,
		success: function() {
			alert("Produto atualizado");
			location.href = '/produto/lista';
		},
		error: function() {
			alert("Ocorreu um erro ao atualizar o produto");
		},
		dataType: "json",
		contentType: "application/json"
	});
}

async function lista() {
	await $.ajax({
		type: "GET",
		url: "http://localhost:8082/produto/lista",
		success: function(data) {
			$.each(data, function(i, produto) {
				$(".dados-produtos-js").append(
					"<tr><td>" + produto.id + "</td>" +
					"<td>" + produto.nome + "</td>" +
					"<td>" + produto.categoria + "</td>" +
					"<td>" + produto.preco + "</td>" +
					"<td>" + produto.descricao + "</td>" +
					"<td><div class='d-flex justify-content-around'><form action='/produto/alterar/" + produto.id + "' method='get'><button class='fas fa-edit' type='submit' title='Editar'></button></form><form><button class='fas fa-trash' type='submit' title='Excluir' onclick='excluir(event, " + `"` + produto.id + `"` + ")'></button></form></div></td></tr>"
				);
			});
		},
		error: function() {
			alert("Ocorreu um erro ao resgatar a lista de produtos");
		},
	});
}

async function excluir(e, id) {
	e.preventDefault();

	await $.ajax({
		type: "DELETE",
		url: "http://localhost:8082/produto/" + id,
		success: function() {
			alert("Produto excluído");
			location.reload();
		},
		error: function() {
			alert("Ocorreu um erro ao excluir o produto");
		},
	});
}
