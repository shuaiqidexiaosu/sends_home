/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  theme: {
    extend: {},
  },
  darkMode: 'class',
  plugins: [require('daisyui')],
  daisyui: {
    themes: ['light', 'retro'],
    base: true, // 默认启用基础样式
    styled: true, // 开启组件样式
    utils: true, // 开启实用工具类
  },
}
