import { invoke } from '../api.js';

const form = document.querySelector('#vector-form');
const xInput = document.querySelector('#x-val');
const yInput = document.querySelector('#y-val');
const outputEl = document.querySelector('#output');

async function handleCalculate(e) {
    e.preventDefault();

    const x = parseFloat(xInput.value);
    const y = parseFloat(yInput.value);

    outputEl.textContent = await invoke('magnitude', {x, y});
}

window.addEventListener('DOMContentLoaded', () => {
    if (form) {
        form.addEventListener('submit', handleCalculate);
    }
});