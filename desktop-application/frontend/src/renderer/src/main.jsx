import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

import { AuthProvider } from './context/AuthProvider';
import ErrorPage from './Pages/ErrorPage/ErrorPage.jsx';
import Login from './Pages/Login/Login';

const router = createBrowserRouter([
  {
    path : '/',
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
    <AuthProvider>
      <RouterProvider router={router} />
    </AuthProvider>
  </React.StrictMode>,
)
