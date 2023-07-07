/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./src/renderer/index.html",
    "./src/renderer/src/**/*.{js,ts,jsx,tsx}",
  ],
  darkMode: 'class', 
  theme: {
    extend: {
      colors : {
        kellyGreen : '#4cbb17',
        neonBlue : '#4d4dff',
        discordBlue : '#5765f2',
        discordBlack : '#37393f',
        discordWhite : '#f1f1f1',
        discordDarkBlack : '#202225'
      }
    },
  },
  plugins: [],
}

