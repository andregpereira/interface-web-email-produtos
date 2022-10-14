async function filtrar(e, dataEnvio) {
	e.preventDefault();

	location.href = "/email/lista/" + dataEnvio.value;
}