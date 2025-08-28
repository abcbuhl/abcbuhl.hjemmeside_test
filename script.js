// Mobile nav toggle
const nav = document.getElementById('site-nav');
const toggle = document.querySelector('.nav-toggle');
if (toggle && nav) {
  toggle.addEventListener('click', () => {
    const open = nav.classList.toggle('open');
    toggle.setAttribute('aria-expanded', String(open));
  });
}

// Theme toggle (light/dark)
const root = document.documentElement;
const themeBtn = document.getElementById('theme-toggle');
const STORAGE_KEY = 'handsup-theme';

function applyTheme(mode) {
  if (mode === 'dark') {
    root.setAttribute('data-theme', 'dark');
  } else {
    root.removeAttribute('data-theme');
  }
}

const saved = localStorage.getItem(STORAGE_KEY);
if (saved === 'light' || saved === 'dark') {
  applyTheme(saved);
}

themeBtn?.addEventListener('click', () => {
  const isDark = root.getAttribute('data-theme') === 'dark';
  const next = isDark ? 'light' : 'dark';
  localStorage.setItem(STORAGE_KEY, next);
  applyTheme(next);
});

// Footer year
const yearEl = document.getElementById('year');
if (yearEl) yearEl.textContent = String(new Date().getFullYear());

