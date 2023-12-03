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
      '1a': '#151313',
      '1b': '#201D1D',
      '1c': '#000000',
      '2a': '#BB4430',
      '3a': '#7EBDC2',
      '4a': '#F3DFA2',
      '5a': '#EFE6DD',
    },
    colors: {
      'main': '#222831',
      'second': '#393E46',
      'third': '#FF7600',
      'fourth': '#EEEEEE',
      '1a': '#151313',
      '1b': '#201D1D',
      '2a': '#BB4430',
      '3a': '#7EBDC2',
      '4a': '#F3DFA2',
      '5a': '#EFE6DD',
    }
  },
  plugins: [],

};
