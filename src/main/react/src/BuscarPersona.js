import React, { useState } from 'react';
import { Alert, Button, Form, FormGroup, Input, Label } from 'reactstrap';

function BuscarPersona() {

	const [message, setMessage] = useState("");
	const [formStatus, setFormStatus] = useState("ready");
	const [persona, setPersona] = useState(null);

	function insertarPersona(event) {
		event.preventDefault();

		const endpoint = event.target.action;
		const data = Array.from(event.target.elements)
			.filter((input) => input.name)
			.reduce((obj, input) => Object.assign(obj, { [input.name]: input.value }), {});

		setFormStatus("sending");

		fetch(endpoint + '?' + new URLSearchParams(data), {
			method: 'GET',
			headers: {
				Accept: 'application/json',
				'Content-Type': 'application/json',
			}
		}).then((response) => {
			if (response.status !== 200) {
				throw new Error(response.statusText);
			}
			console.log(response);
			return response.json();
		}).then(response => {
			setPersona(response[0]);
			setFormStatus('ready');
		}).catch((err) => {
			setFormStatus('ready');
			setMessage(err.toString());
		});
	}

	return (
		<>
			{formStatus !== 'ready' ? <Alert color="info">Enviando...</Alert> : ''}
			{message ? <Alert color="danger">{message}</Alert> : ''}
			<Form action='/api/v1/personas' method='get' onSubmit={insertarPersona}>
				<FormGroup>
					<Label for="curp">CURP:</Label>
					<Input id="curp" name="curp" />
				</FormGroup>
				<Button disabled={formStatus !== "ready"}>
					Buscar
				</Button>
				{
					persona && <FormGroup>
						<Label for="nombre">Nombre</Label>
						<Input plaintext id="nombre" value={persona.nombre} />
					</FormGroup>
				}
			</Form>
		</>
	);
}

export default BuscarPersona;