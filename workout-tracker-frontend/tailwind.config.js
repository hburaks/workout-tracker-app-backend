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
      'bottom': '0 6px 5px 0px rgba(0, 0, 0, 0.3)',
      'right': '6px 0px 5px 0px rgba(0, 0, 0, 0.3)'
    },
    backgroundColor: {
      'main': '#222831',
      'second': '#393E46',
      'third': '#FF7600',
      'fourth': '#EEEEEE',

    },
    colors: {
      'main': '#222831',
      'second': '#393E46',
      'third': '#FF7600',
      'fourth': '#EEEEEE',
    }
  },
  plugins: [],

};
