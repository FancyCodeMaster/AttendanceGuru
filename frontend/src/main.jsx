import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import ErrorPage from './Pages/ErrorPage/ErrorPage.jsx';
import Signup from './Pages/Signup/Signup.jsx';
import Login from './Pages/Login/Login.jsx';
import Dashboard from './Pages/Dashboard/Dashboard';

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
    path : '/dashboard',
    element : <Dashboard />
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
