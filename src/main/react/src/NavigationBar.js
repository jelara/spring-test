import { Link } from 'react-router-dom';
import logo from './img/logo.svg'

export default function NavigationBar() {
	return (
		<>
			<div className="topNavigationMenu">
				<img id="topLogo" src={logo} alt="Logotipo de Thincrs" />
				<Link to="/">Listado de personas</Link>
				<Link to="/buscarPersona">Buscar persona</Link>
				<Link to="/nuevaPersona">Crear nueva persona</Link>
				<a href="/login">Iniciar sesión</a>
			</div>
		</>
	);
}
