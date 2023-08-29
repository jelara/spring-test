import React, { useState, useEffect } from 'react';
import { Table } from 'reactstrap';

function ListaPersonas() {

	const [personas, setPersonas] = useState([]);

	useEffect(function() {
		fetch("/api/v1/personas", { redirect: "error" })
			.then(response => response.json())
			.then(response => setPersonas(response))
			.catch(() => setPersonas([{id: '', nombre: 'Debe iniciar sesión para ver las personas.'}]));
	}, []);

	return (
		<>
			<h1>Personas en la base de datos</h1>
			<Table striped>
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
					</tr>
				</thead>
				<tbody>
					{personas.map(persona => (
						<tr>
							<td>
								{persona.id}
							</td>
							<td>
								{persona.nombre}
							</td>
						</tr>
					))}
				</tbody>
			</Table>
		</>
	);
}

export default ListaPersonas;