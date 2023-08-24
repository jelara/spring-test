import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Alert, Button, Form, FormGroup, Input, Label } from 'reactstrap';

function InsertarPersona() {
	
	const [message, setMessage] = useState("");
	const [formStatus, setFormStatus] = useState("ready");
	const navigate = useNavigate();

	function insertarPersona(event) {
		event.preventDefault();

		console.log(event);

		const endpoint = event.target.action;
		const data = Array.from(event.target.elements)
			.filter((input) => input.name)
			.reduce((obj, input) => Object.assign(obj, { [input.name]: input.value }), {});

		setFormStatus("sending");
		
		fetch(endpoint, {
			method: 'POST',
			headers: {
				Accept: 'application/json',
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(data),
		}).then((response) => {
			if (response.status !== 200) {
				throw new Error(response.statusText);
			}
			console.log(response);
			return response.json();
		}).then(() => {
			navigate("/");
		}).catch((err) => {
			setFormStatus('ready');
			setMessage(err.toString());
		});
	}

	return (
		<>
		{ formStatus != 'ready' ? <Alert color="info">Enviando...</Alert> : '' }
		{ message ? <Alert color="danger">{message}</Alert> : '' }
		<Form action='/api/v1/personas' method='post' onSubmit={insertarPersona}>
			<FormGroup>
				<Label for="inputNombre">Nombre:</Label>
				<Input id="inputNombre" name="nombre" placeholder="Escribe aquí tu nombre" />
			</FormGroup>
			<FormGroup>
				<Label for="apellidos">Apellidos:</Label>
				<Input id="apellidos" name="apellidos" />
			</FormGroup>
			<FormGroup>
				<Label for="fechaNacimiento">Fecha de nacimiento:</Label>
				<Input type="date" id="fechaNacimiento" name="fechaNacimiento" />
			</FormGroup>
			<FormGroup>
				<Label for="genero">Género:</Label>
				<Input id="genero" name="genero" />
			</FormGroup>
			<FormGroup>
				<Label for="entidadNacimiento">Entidad de nacimiento:</Label>
				<Input id="entidadNacimiento" name="entidadNacimiento" />
			</FormGroup>
			<FormGroup>
				<Label for="curp">CURP:</Label>
				<Input id="curp" name="curp" />
			</FormGroup>
			<Button disabled={formStatus != "ready"}>
				Insertar
			</Button>
		</Form>
		</>
	);
}

export default InsertarPersona;