import { createRoot } from 'react-dom/client';

// Clear the existing HTML content
import { jsx as _jsx } from "react/jsx-runtime";
document.body.innerHTML = '<div id="app"></div>';

// Render your React component instead
const root = createRoot(document.getElementById('app'));
root.render( /*#__PURE__*/_jsx("h1", {
  children: "Hello, world"
}));