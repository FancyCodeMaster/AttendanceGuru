/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      backgroundImage : {
        'login' : "url('src/assests/Images/login.jpg')",
        'teacher-avatar' : "url('src/assets/Images/teacher-avatar.jpg')",
        'student-avatar' : "url('src/assets/Images/student-avatar.jpg')",
        'homepage' : "url('src/assets/Images/homepage.jpg)",
      }
    },
  },
  plugins: [],
}

