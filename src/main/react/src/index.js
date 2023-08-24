import React from 'react';
import ReactDOM from 'react-dom/client';
import InsertarPersona from './InsertarPersona';
import Layout from './Layout';
import ListaPersonas from './ListaPersonas';
import BuscarPersona from './BuscarPersona';

import reportWebVitals from './reportWebVitals';

import {
	createBrowserRouter,
	RouterProvider,
} from "react-router-dom";

import './style/styles.css';
import 'bootstrap/dist/css/bootstrap.css';

const router = createBrowserRouter([
	{
		path: "/",
		element: <Layout />,
		children: [
	
			{
				path: "/",
				element: <ListaPersonas />,
			},
			{
				path: "/nuevaPersona",
				element: <InsertarPersona />,
			},
			{
				path: "/buscarPersona",
				element: <BuscarPersona />,
			}
		]
	}
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
	<React.StrictMode>
		<RouterProvider router={router} />
	</React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
