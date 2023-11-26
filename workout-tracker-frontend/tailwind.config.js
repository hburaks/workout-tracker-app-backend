/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    extend: {},
    fontFamily: {
      sans: ['ui-sans-serif', 'system-ui'],
      serif: ['ui-serif', 'Georgia'],
      mono: ['Helvetica', 'SFMono-Regular'],
      display: ['Oswald'],
      body: ['"Open Sans"'],
    },
    boxShadow: {
      '3xl': '0 6px 5px 0px rgba(0, 0, 0, 0.3)',
    }
  },
  plugins: [],

};
