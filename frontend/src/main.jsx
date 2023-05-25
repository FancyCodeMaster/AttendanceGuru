import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import ErrorPage from './Pages/ErrorPage/ErrorPage.jsx';
import Signup from './Pages/Signup/Signup.jsx';
import Login from './Pages/Login/Login.jsx';

const router = createBrowserRouter([
  {
    path: "/signup",
    element: <Signup />,
  },
  {
    path : '/login',
    element : <Login />,
  },
  {
    path : "*",
    element : <ErrorPage />,
    errorElement : <ErrorPage />
  }
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
